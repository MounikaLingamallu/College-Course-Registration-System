package com.Services;

import java.util.ArrayList;

import com.Modules.Admin;
import com.Modules.Student;

public class UserServices {

    private ArrayList<Student> studentList = new ArrayList<>();

    private Admin admin = new Admin(1,"College Admin", "admin@gmail.com","1234");

    // Add Student
    public void addStudent(Student student) {

        if (searchByStudentId(student.getUserId()) != null) {

            System.out.println("Student Id already exists");
            return;
        }

        if (searchByEmail(student.getMailID()) != null) {

            System.out.println("Email already exists");
            return;
        }

        studentList.add(student);

        System.out.println("Student Registered Successfully");
    }

    // Display Students
    public void displayStudents() {

        if (studentList.isEmpty()) {

            System.out.println("No Students Available");
            return;
        }

        for (Student student : studentList) {

            System.out.println(student);
        }
    }

    // Student Login
    public Student studentLogin(String email, String password) {

        for (Student student : studentList) {

            if (student.getMailID().equalsIgnoreCase(email)  && student.getPassword().equals(password)) {

                return student;
            }
        }

        return null;
    }

    // Admin Login
    public Admin adminLogin(String email, String password) {

        if (admin.getMailID().equalsIgnoreCase(email)
                && admin.getPassword().equals(password)) {

            return admin;
        }

        return null;
    }

    // Search Student
    public Student searchByStudentId(int id) {

        for (Student student : studentList) {

            if (student.getUserId() == id) {

                return student;
            }
        }

        return null;
    }

    // Search Email
    public Student searchByEmail(String email) {

        for (Student student : studentList) {

            if (student.getMailID().equalsIgnoreCase(email)) {

                return student;
            }
        }

        return null;
    }

    // Delete Student
    public void deleteStudent(int id) {

        Student student = searchByStudentId(id);

        if (student != null) {

            studentList.remove(student);

            System.out.println("Student Deleted Successfully");

        } else {

            System.out.println("Student Not Found");
        }
    }

    public int totalStudents() {

        return studentList.size();
    }
}