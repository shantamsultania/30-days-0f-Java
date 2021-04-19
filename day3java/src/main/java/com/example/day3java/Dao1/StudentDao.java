package com.example.day3java.Dao1;

import java.util.List;

public interface StudentDao {


    List<Student> getAllStudents();

    Student getStudent(String id);

    void addStudent(Student student);

    void updateStudentName(String id, String name);

    void deleteStudent(Student student);

}
