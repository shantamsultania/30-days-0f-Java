package com.example.day5java.DatabaseConnectSpringBoot;

import org.junit.jupiter.api.Test;

class EmployeeDaoImplTest {


    @Test
    public void testInsert()
    {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        Employee employee = new Employee();
        employee.setEmployeeId("1");
        employee.setEmployeeDepartment("cse");
        employee.setEmployeeName("ss");
        employeeDao.insertData(employee);
    }

}