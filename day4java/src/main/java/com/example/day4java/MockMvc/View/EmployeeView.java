package com.example.day4java.MockMvc.View;


import com.example.day4java.MockMvc.Model.EmployeeModel;

public class EmployeeView {

    public EmployeeModel showEmployeeDetails(EmployeeModel employeeModel) {
        System.out.println("Employee Details are as follows = " + employeeModel);
        return employeeModel;
    }

    public String showEmployeeName(EmployeeModel employeeModel) {
        System.out.println("Employee Name : " + employeeModel.getEmployeeName());
        return employeeModel.getEmployeeName();
    }

    public void showEmployeeId(EmployeeModel employeeModel) {
        System.out.println("Employee Id : " + employeeModel.getEmployeeId());
    }

}
