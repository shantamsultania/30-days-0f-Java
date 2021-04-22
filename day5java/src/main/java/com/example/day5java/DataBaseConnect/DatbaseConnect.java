package com.example.day5java.DataBaseConnect;

import com.example.day5java.ConnectionCred;

import java.sql.*;

public class DatbaseConnect {

    public static void main(String[] args) {

        ConnectionCred connectionCred = new ConnectionCred();
        try {
            Connection connection = DriverManager.getConnection(connectionCred.getUrl(), connectionCred.getPassword(), connectionCred.getUser());
            Statement statement = connection.createStatement();

            // create a Database Table
            String sqlCreateStatement = "create table jdbc.testTable(id VARCHAR(255),name VARCHAR(255))";
            statement.execute(sqlCreateStatement);

            // insert into database
            String id = "10";
            String name = "shantam";

            String sql2 = "insert into testTable values('" + id + "','" + name + "')";
            statement.execute(sql2);

            // read for database
            String sql1 = "SELECT * FROM testTable";
            ResultSet resultSet = statement.executeQuery(sql1);

            // print
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + " , " + resultSet.getString("name"));
            }


            // Delete
            String sql4 = "DROP table testTable";
            statement.execute(sql4);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
