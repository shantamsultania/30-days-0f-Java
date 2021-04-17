package com.example.day1java.serviceProvider;

import com.example.day1java.Data.Employee;
//import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

//@Slf4j
public class ServiceHandler {

    List<Employee> employeeList = new ArrayList<>();

    public ServiceHandler() {
        addDefaultData();
    }

    public void addDefaultData() {
        Employee e1 = new Employee();
        e1.setEmployeeSalary("10000");
        e1.setEmployeeDepartment("cse");
        e1.setEmployeeDOJ("10april");
        e1.setEmployeeFeedback("bahut mc insan hai");
        e1.setEmployeeId("001");
        e1.setEmployeeName("ss");
        employeeList.add(e1);
    }

    public List<Employee> getAllData() {
//        log.info("Data  = {}", employeeList);
        return employeeList;

    }

    public void addEmployee(Employee employee) {
        if (employee != null) {
//            log.info(" data added ");
            employeeList.add(employee);
        }
    }


    public void update(String name, String salary) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeName().equals(name)) {
//                log.info("Data updated ");
                employee.setEmployeeSalary(salary);
                break;
            }
        }
    }

    public List<Employee> searchByName(String name) {
        List<Employee> employeeListByName = new ArrayList<>();

        for (Employee employee : employeeList) {
            if (employee.getEmployeeName().equals(name)) {
                employeeListByName.add(employee);
            }
        }
        if (employeeListByName.isEmpty()) {
//            log.info("no employee by name " + name);
        }
        return employeeListByName;
    }

    public Employee searchById(String id) {

        for (Employee employee : employeeList) {
            if (employee.getEmployeeId().equals(id)) {
                return employee;
            }
        }
//        log.debug("No employee by ID " + id);
        return null;
    }

    public List<Employee> searchByDepartment(String department) {

        List<Employee> employeeListByDepartment = new ArrayList<>();

        for (Employee employee : employeeList) {
            if (employee.getEmployeeDepartment().equals(department)) {
                employeeListByDepartment.add(employee);
            }
        }
        if (employeeListByDepartment.isEmpty()) {
//            log.info("no employee in this department " + department);
        }
        return employeeListByDepartment;
    }

    public String deleteEmployee(String id) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeId().equals(id)) {
                employeeList.remove(employee);
//                log.info("Employee removed ");
                return "employee details deleted";
            }
        }
//        log.info("Employee not removed ");
        return "employee with employee id "+id+" does not exists";
    }

}
