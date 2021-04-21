package com.example.day5java.JDBCConnectSpringBoot;

import com.example.day5java.ConnectionCreds;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private Statement statement;
    private Connection connection;

    public EmployeeDaoImpl() {
        ConnectionCreds connectionCreds = new ConnectionCreds();
        try {
            connection = DriverManager.getConnection(connectionCreds.getUrl(), connectionCreds.getPassword(), connectionCreds.getUser());
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Employee> showAllData() {

        List<Employee> employeeList = new ArrayList<>();
        try {
            String sqlGetStatement = "SELECT * FROM employeeTable";
            ResultSet resultSet = statement.executeQuery(sqlGetStatement);

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmployeeName(resultSet.getString("name"));
                employee.setEmployeeDepartment(resultSet.getString("department"));
                employee.setEmployeeId(resultSet.getString("id"));
                employeeList.add(employee);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void createTable() {
        String sqlCreateStatement = "create table jdbc.employeeTable(id VARCHAR(255),name VARCHAR(255),department VARCHAR(255))";
        try {
            statement.execute(sqlCreateStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void insertData(Employee employee) {
        String sqlInsertDataStatement = "insert into employeeTable values('" + employee.getEmployeeId() + "','" + employee.getEmployeeName() + "','" + employee.getEmployeeDepartment() + "')";
        try {
            statement.execute(sqlInsertDataStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteData(String id) {
        String sqlDropRowStatement = "DELETE FROM employeeTable WHERE id =" + id;
        try {
            statement.execute(sqlDropRowStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteTable() {
        String sqlDropTableStatement = "DROP table employeeTable";
        try {
            statement.execute(sqlDropTableStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
