package com.example.day6java.JDBCConnectSpringBoot;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface EmployeeDao {

    List<Employee> showAllData(JdbcTemplate jdbcTemplate);

    void createTable(JdbcTemplate jdbcTemplate);

    void insertData(Employee employee,JdbcTemplate jdbcTemplate);

    void deleteData(String id,JdbcTemplate jdbcTemplate);

    void deleteTable(JdbcTemplate jdbcTemplate);
}
