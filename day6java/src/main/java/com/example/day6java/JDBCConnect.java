package com.example.day6java;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class JDBCConnect {

    @Autowired
    private static final JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public static void main(String[] args) {

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setURL("jdbc:mysql://localhost" +
                ":3306/jdbc");
        jdbcTemplate.setDataSource(dataSource);

        try {

            // create
            String sqlCreateStatement = "create table jdbc.testTable(id VARCHAR(255),name VARCHAR(255))";
            jdbcTemplate.execute(sqlCreateStatement);

            // insert
            String id = "10";
            String name = "shantam";

            String sql2 = "insert into testTable values('" + id + "','" + name + "')";
            jdbcTemplate.execute(sql2);

            // read for database
            String sql1 = "SELECT * FROM testTable";
            List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(sql1);

            for (Map<String, Object> stringObjectMap : resultSet) {

                for (Map.Entry<String, Object> e : stringObjectMap.entrySet()) {
                    System.out.println("-------------------");
                    System.out.println("key" + e.getKey());
                    System.out.println("object " + e.getValue());
                    System.out.println("-----------------------");
                }
            }


//            // Delete
            String sql4 = "DROP table testTable";
            jdbcTemplate.execute(sql4);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
