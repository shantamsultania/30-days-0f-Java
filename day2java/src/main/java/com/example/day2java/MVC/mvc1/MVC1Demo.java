package com.example.day2java.MVC.mvc1;

import com.example.day2java.MVC.mvc1.Controller.StudentController;
import com.example.day2java.MVC.mvc1.Model.Student;
import com.example.day2java.MVC.mvc1.View.StudentView;

public class MVC1Demo {

    public static Student setModelData() {
        Student modelStudent = new Student();
        modelStudent.setStudentName("Shantam");
        modelStudent.setStudentDOB("18 april 2021");
        modelStudent.setStudentGrade("A");
        modelStudent.setStudentId("100");
        modelStudent.setStudentStream("CSE");
        return modelStudent;
    }


    public static void main(String[] args) {

        Student modelStudent = setModelData();

        StudentView studentView = new StudentView();

        StudentController studentController = new StudentController(modelStudent, studentView);

        studentController.showData();
        studentController.setStudentName("New Name");
        System.out.println("Updated Student name = " + studentController.getUpdatedStudentName());
        studentController.showData();
    }
}
