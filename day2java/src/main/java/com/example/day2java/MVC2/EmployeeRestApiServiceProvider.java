package com.example.day2java.MVC2;

import com.example.day2java.MVC2.Controller.EmployeeController;
import com.example.day2java.MVC2.Model.EmployeeModel;
import com.example.day2java.MVC2.View.EmployeeView;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeRestApiServiceProvider {

    private final EmployeeView employeeView = new EmployeeView();
    private final List<EmployeeController> employeeControllerList = new ArrayList<>();

    EmployeeRestApiServiceProvider() {
        setEmployeeControllerList();
    }

    public void setEmployeeControllerList() {
        EmployeeModel e1 = new EmployeeModel();
        e1.setEmployeeSalary("10000");
        e1.setEmployeeDepartment("cse");
        e1.setEmployeeDOJ("10 April");
        e1.setEmployeeFeedback("nice coder ");
        e1.setEmployeeId("001");
        e1.setEmployeeName("shantam");

        EmployeeView employeeView = new EmployeeView();

        EmployeeController employeeController = new EmployeeController(e1, employeeView);
        employeeControllerList.add(employeeController);
    }


    @GetMapping("/getallemp")
    public List<EmployeeModel> getAllEmployees() {
//        setEmployeeControllerList();
        List<EmployeeModel> employeeModelList = new ArrayList<>();

        for (EmployeeController employeeController : employeeControllerList) {
            employeeModelList.add(employeeController.getData());
        }

        return employeeModelList;
    }

    @GetMapping("/getoneemp/{name}")
    public EmployeeModel getOneEmployee(@PathVariable String name) {
        if (!employeeControllerList.isEmpty()) {
            for (EmployeeController employeeController : employeeControllerList) {
                if (employeeController.getEmployeeName().equalsIgnoreCase(name)) {
                    return employeeController.getData();
                }
            }
        }
        System.out.println("no employee found");
        return null;
    }

    @PostMapping("/addemp")
    public String addEmployee(@RequestBody EmployeeModel employeeModel) {
        EmployeeController employeeController = new EmployeeController(employeeModel, employeeView);
        employeeControllerList.add(employeeController);
        return "Employee added successfully";
    }

    @PutMapping("/updateempname/{name}/{name2}")
    public String nameUpdate(@PathVariable String name, @PathVariable String name2) {
        if (!employeeControllerList.isEmpty()) {
            for (EmployeeController employeeController : employeeControllerList) {
                if (employeeController.getEmployeeName().equals(name)) {
                    employeeController.updateName(name2);
                    return "updated name " + employeeController.getEmployeeName();
                }
            }

        }
        return "Name not found";
    }


}
