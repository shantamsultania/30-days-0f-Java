package com.example.day5java.JDBCConnectSpringBoot;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> showAllData();

    public void createTable();

    public void insertData(Employee employee);

    public void deleteData(String id);

    public void deleteTable();
}
