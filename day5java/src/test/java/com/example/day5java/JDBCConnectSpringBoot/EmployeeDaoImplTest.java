package com.example.day5java.JDBCConnectSpringBoot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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