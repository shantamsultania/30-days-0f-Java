package com.example.day3java.Dao2;

import com.example.day3java.Dao2.Employee;
import com.example.day3java.Dao2.EmployeeDao;
import com.example.day3java.Dao2.EmployeeDaoImplementation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestServiceProvider {

    private EmployeeDao employeeDao = new EmployeeDaoImplementation();

    @GetMapping("/empdao/getall")
    public List<Employee> getEmployeeList()
    {
        return employeeDao.getAllEmployee();
    }


    @GetMapping("/empdao/getone/{id}")
    public Employee getOneEmployee(@PathVariable String id)
    {
        return employeeDao.getEmployeeById(id);
    }

    @PostMapping("/empdao/add")
    public void addEmployee(@RequestBody Employee employee)
    {
        employeeDao.addEmployee(employee);
    }

    @PutMapping("/empdao/update/{id}/{name}")
    public void updateEmployee(@PathVariable String id , @PathVariable String name)
    {
        employeeDao.updateEmployee(id, name);
    }

    @DeleteMapping("/empdao/delete/{id}")
    public void deleteEmployee(@PathVariable String id)
    {
        employeeDao.deleteEmployee(id);
    }

}
