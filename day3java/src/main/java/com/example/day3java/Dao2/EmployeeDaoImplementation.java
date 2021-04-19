package com.example.day3java.Dao2;

import com.example.day3java.Dao2.Employee;
import com.example.day3java.Dao2.EmployeeDao;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImplementation implements EmployeeDao {

    List<Employee> employeeList = new ArrayList<>();

    public EmployeeDaoImplementation()
    {
        Employee emp1 = new Employee();
        emp1.setEmployeeDepartment("CSE");
        emp1.setEmployeeId("100");
        emp1.setEmployeeName("Employee1");
        employeeList.add(emp1);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String id) {

        for (Employee employee : employeeList) {
            if (employee.getEmployeeId().equals(id))
            {
                return employee;
            }
        }

        return null;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public void updateEmployee(String id, String name) {

        for (Employee employee : employeeList) {
            if (employee.getEmployeeId().equals(id))
            {
                employee.setEmployeeName(name);
            }
        }

    }

    @Override
    public void deleteEmployee(String id) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeId().equals(id))
            {
                employeeList.remove(employee);
                break;
            }
        }

    }
}
