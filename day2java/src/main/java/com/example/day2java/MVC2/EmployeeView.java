package com.example.day2java.MVC2;

public class EmployeeView {

    public EmployeeModel showEmployeeDetails(EmployeeModel employeeModel)
    {
        System.out.println("Employee Details are as follows = "+employeeModel);
        return employeeModel;
    }

    public String showEmployeeName(EmployeeModel employeeModel)
    {
        System.out.println("Employee Name : "+employeeModel.getEmployeeName());
        return employeeModel.getEmployeeName();
    }

//    public void showEmployeeId(EmployeeModel employeeModel)
//    {
//        System.out.println("Employee Id : "+employeeModel.getEmployeeId());
//    }
//
//    public void showEmployeeSalary(EmployeeModel employeeModel)
//    {
//        System.out.println("Employee Salary : "+employeeModel.getEmployeeSalary());
//    }

}
