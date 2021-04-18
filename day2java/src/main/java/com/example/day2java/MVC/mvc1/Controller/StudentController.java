package com.example.day2java.MVC.mvc1.Controller;

import com.example.day2java.MVC.mvc1.Model.Student;
import com.example.day2java.MVC.mvc1.View.StudentView;

public class StudentController {

    private final Student model;
    private final StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void showData() {
        view.showStudent(model);
    }

    // upDate Model Data
    public void setStudentName(String name) {
        model.setStudentName(name);
    }

    public String getUpdatedStudentName() {
        return model.getStudentName();
    }
}
