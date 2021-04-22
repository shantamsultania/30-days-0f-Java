package com.example.day6java.JDBCConnectSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeServiceRestApi {

    @Autowired(required = true)
    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    private final EmployeeDao employeeDao = new EmployeeDaoImpl();


    @GetMapping("/jdbcc/createtable")
    public void createTable() {
        employeeDao.createTable(jdbcTemplate);
    }

    @GetMapping("/jdbcc/getall")
    public List<Employee> getAll() {
        for (Employee employee : employeeDao.showAllData(jdbcTemplate)) {
            System.out.println("data :" + employee);
        }
        return employeeDao.showAllData(jdbcTemplate);
    }

    @PostMapping("/jdbcc/adddata")
    public void addData(@RequestBody Employee employee) {
        System.out.println(employee);
        employeeDao.insertData(employee,jdbcTemplate);
    }

    @DeleteMapping("/jdbcc/table/delete")
    public void deleteTable() {
        employeeDao.deleteTable(jdbcTemplate);
    }

    @DeleteMapping("/jdbcc/row/delete/{id}")
    public void delete(@PathVariable String id) {
        employeeDao.deleteData(id,jdbcTemplate);
    }


}
