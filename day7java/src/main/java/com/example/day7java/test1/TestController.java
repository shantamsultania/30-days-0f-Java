package com.example.day7java.test1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    private List<Employee> employeeList = new ArrayList<>();

    TestController()
    {
        Employee employee1 = new Employee();
        employee1.setDepartment("engineering");
        employee1.setId("01");
        employee1.setName("shantam");
        employee1.setSalary("100000");
        employeeList.add(employee1);

        Employee employee2 = new Employee();
        employee2.setDepartment("Management");
        employee2.setId("02");
        employee2.setName("priya");
        employee2.setSalary("100");

        employeeList.add(employee2);
    }

    @RequestMapping("/employee")
    public List<Employee> getAll()
    {
        return employeeList;
    }

    //search
    @RequestMapping("/employee/{id}")
    public Employee getOne(@PathVariable String id)
    {
        for (Employee employee : employeeList) {
            if (employee.getId().equalsIgnoreCase(id))
            {
                return employee;
            }
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/addemployee")
    public String addEmployee(@RequestBody Employee employee)
    {
        employeeList.add(employee);
        return "employee added successfully";
    }

    @RequestMapping(method = RequestMethod.POST,value = "/addmulemployee")
    public String addMultiEmployee(@RequestBody List<Employee> employees)
    {
        employeeList.addAll(employees);
        return "employees added = "+employees.size();
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/updateemployee")
    public String updateEmployee(@RequestBody Employee employee)
    {
        boolean flag = false;
        for (Employee employee1 : employeeList) {
            if (employee1.getId().  equalsIgnoreCase(employee.getId()))
            {
                flag = true;
                employee1.setDepartment(employee.getDepartment());
                employee1.setSalary(employee.getSalary());
            }
        }
        return flag ?  "data updated ": " data not updated as employee not found "+employee.getId();
    }

}
