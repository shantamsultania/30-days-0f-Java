package com.example.day3java.Dao1;

public class testDaoImplementation {

    public static void main(String[] args) {

        StudentDao studentDao = new StudentDaoImplementation();

        // Get all
        System.out.println("---------------------------------");

        for (Student allStudent : studentDao.getAllStudents()) {
            System.out.println(allStudent);
        }

        // Get one
        System.out.println("---------------------------------");
        System.out.println(studentDao.getStudent("100"));

        // add
        System.out.println("---------------------------------");
        Student newStudent = new Student();
        newStudent.setStudentName("student3");
        newStudent.setStudentId("103");
        newStudent.setStudentGrade("A+");
        studentDao.addStudent(newStudent);
        System.out.println(studentDao.getStudent("103"));

        // update
        System.out.println("---------------------------------");
        studentDao.updateStudentName("103", "shantam");
        System.out.println(studentDao.getStudent("103"));

        // Delete
        System.out.println("---------------------------------");
        studentDao.deleteStudent(newStudent);

        System.out.println("---------------------------------");

        for (Student allStudent : studentDao.getAllStudents()) {
            System.out.println(allStudent);
        }

    }
}
