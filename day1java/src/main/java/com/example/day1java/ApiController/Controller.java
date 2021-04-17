package com.example.day1java.ApiController;

import com.example.day1java.Data.Employee;
import com.example.day1java.serviceProvider.ServiceHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private final ServiceHandler serviceHandler = new ServiceHandler();

    @GetMapping("/connect")
    public String connect() {
        return "Api connection success";
    }


    @GetMapping("/employee/getall")
    public List<Employee> getAllData() {
        return serviceHandler.getAllData();
    }

    @PostMapping("/employee/add")
    public String addData(@RequestBody Employee employee) {
        serviceHandler.addEmployee(employee);
        return "data added successfully ";
    }

    @PutMapping("/employee/update/{name}/{salary}")
    public String update(@PathVariable String name, @PathVariable String salary) {
        serviceHandler.update(name, salary);
        return "Data updated";
    }

    @GetMapping("/employee/searchbyname/{name}")
    public List<Employee> getEmployeeByName(@PathVariable String name) {
        return serviceHandler.searchByName(name);
    }

    @GetMapping("/employee/searchbyid/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        return serviceHandler.searchById(id);
    }


    @GetMapping("/employee/searchbydep/{dep}")
    public List<Employee> getEmployeeByDep(@PathVariable String dep) {
        return serviceHandler.searchByDepartment(dep);
    }

    @DeleteMapping("/employee/delete/{id}")
    public String deleteEmployeeDetails(@PathVariable String id) {
        return serviceHandler.deleteEmployee(id);
    }

}
