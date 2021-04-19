package com.example.day3java.Dao1;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImplementation implements StudentDao {


    List<Student> studentList = new ArrayList<>();

    StudentDaoImplementation() {
        Student stu1 = new Student();
        stu1.setStudentId("100");
        stu1.setStudentGrade("A");
        stu1.setStudentName("student1");

        Student stu2 = new Student();
        stu2.setStudentName("student2");
        stu2.setStudentGrade("B");
        stu2.setStudentId("101");

        studentList.add(stu1);
        studentList.add(stu2);
    }


    @Override
    public List<Student> getAllStudents() {
        return studentList;
    }

    @Override
    public Student getStudent(String id) {
        for (Student student : studentList) {
            if (student.getStudentId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public void updateStudentName(String id, String name) {
        for (Student student : studentList) {
            if (student.getStudentId().equals(id)) {
                student.setStudentName(name);
            }
        }

    }

    @Override
    public void deleteStudent(Student student) {
        studentList.remove(student);
    }
}
