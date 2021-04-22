package com.example.day6java.JDBCConnectSpringBoot;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeDaoImpl implements EmployeeDao {


    @Override
    public List<Employee> showAllData(JdbcTemplate jdbcTemplate) {

        List<Employee> employeeList = new ArrayList<>();
        try {
            String sqlReadData = "SELECT * FROM employeeTable";

            List<Map<String, Object>> result = jdbcTemplate.queryForList(sqlReadData);
            for (Map<String, Object> stringObjectMap : result) {
                Employee employee = new Employee();
                for (Map.Entry<String, Object> e : stringObjectMap.entrySet()) {
                    switch (e.getKey()) {
                        case "id":
                            employee.setEmployeeId((String) e.getValue());
                            break;
                        case "name":
                            employee.setEmployeeName((String) e.getValue());
                            break;
                        case "department":
                            employee.setEmployeeDepartment((String) e.getValue());
                            break;
                        default:
                            System.out.println("unknown key "+e.getKey());
                    }
                }
                employeeList.add(employee);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void createTable(JdbcTemplate jdbcTemplate) {
        String sqlCreateStatement = "create table employeeTable(id VARCHAR(255),name VARCHAR(255),department VARCHAR(255))";
        try {
            jdbcTemplate.execute(sqlCreateStatement);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void insertData(Employee employee,JdbcTemplate jdbcTemplate) {
        String sqlInsertDataStatement = "insert into employeeTable values('" + employee.getEmployeeId() + "','" + employee.getEmployeeName() + "','" + employee.getEmployeeDepartment() + "')";
        try {
            jdbcTemplate.execute(sqlInsertDataStatement);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteData(String id,JdbcTemplate jdbcTemplate) {
        String sqlDropRowStatement = "DELETE FROM employeeTable WHERE id =" + id;
        try {
            jdbcTemplate.execute(sqlDropRowStatement);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteTable(JdbcTemplate jdbcTemplate) {
        String sqlDropTableStatement = "DROP table employeeTable";
        try {
            jdbcTemplate.execute(sqlDropTableStatement);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
}
