package com.example.day5java.DatabaseConnectSpringBoot;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeServiceProviderApi {

    private final EmployeeDao employeeDao = new EmployeeDaoImpl();

    public EmployeeServiceProviderApi() {
    }

    @GetMapping("/jdbc/createtable")
    public void createTable() {
        employeeDao.createTable();
    }

    @GetMapping("/jdbc/getall")
    public List<Employee> getAll() {
        for (Employee employee : employeeDao.showAllData()) {
            System.out.println("data :" + employee);
        }
        return employeeDao.showAllData();
    }

    @PostMapping("/jdbc/adddata")
    public void addData(@RequestBody Employee employee) {
        System.out.println(employee);
        employeeDao.insertData(employee);
    }

    @DeleteMapping("/jdbc/table/delete")
    public void deleteTable() {
        employeeDao.deleteTable();
    }

    @DeleteMapping("/jdbc/row/delete/{id}")
    public void delete(@PathVariable String id) {
        employeeDao.deleteData(id);
    }


}
