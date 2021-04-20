package com.example.day4java.MockMvc.Controller;


import com.example.day4java.MockMvc.Model.EmployeeModel;
import com.example.day4java.MockMvc.View.EmployeeView;
import lombok.Data;

@Data
public class EmployeeController {

    private EmployeeModel model;
    private EmployeeView view;

    public EmployeeController(EmployeeModel model, EmployeeView view) {
        this.model = model;
        this.view = view;
    }

    public void updateName(String name) {
        model.setEmployeeName(name);
    }

    public String getEmployeeName() {
        return view.showEmployeeName(model);
    }

    public EmployeeModel getData() {
        return view.showEmployeeDetails(model);
    }

}
