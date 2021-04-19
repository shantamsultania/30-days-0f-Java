package com.example.day3java.Dao2;

import com.example.day3java.Dao2.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> getAllEmployee();

    public Employee getEmployeeById(String id);

    public void addEmployee(Employee employee);

    public void updateEmployee(String id,String name);

    public void deleteEmployee(String id);
}
