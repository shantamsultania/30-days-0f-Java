package com.example.day5java.JDBCConnect;

import com.example.day5java.ConnectionCreds;

import java.sql.*;

public class JdbcConnect {

    public static void main(String[] args) {

        ConnectionCreds connectionCreds = new ConnectionCreds();
        try {
            Connection connection = DriverManager.getConnection(connectionCreds.getUrl(),connectionCreds.getPassword(),connectionCreds.getUser());
            Statement statement = connection.createStatement();

            // create a Database Table
//            String sqlCreateStatement = "create table jdbc.testTable(id VARCHAR(255),name VARCHAR(255))";
//            statement.execute(sqlCreateStatement);

            // insert into database
            String id = "10";
            String name = "shantam";

            String sql2 ="insert into testTable values('"+id+"','"+name+"')";
            statement.execute(sql2);

            // read for database
            String sql1 = "SELECT * FROM testTable";
            ResultSet resultSet = statement.executeQuery(sql1);

            // print
            while (resultSet.next())
            {
//                System.out.println(                resultSet.getStatement());
//                System.out.println(resultSet.getCursorName());
//                System.out.println(resultSet.getFetchSize());
                System.out.println(resultSet.getObject(2));
//            int size = resultSet.getMetaData().getColumnCount();
//            for (int i = 1; i <= size; i++) {
//
//                System.out.println(resultSet.getMetaData().getColumnName(i));
//                System.out.println(resultSet.getString(resultSet.getMetaData().getColumnName(i)));
//            }
            }
            System.out.println("--------------------");



//             //Delete
//            String sql4 = "DROP table testTable";
//            statement.execute(sql4);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
