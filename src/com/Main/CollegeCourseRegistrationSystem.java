package com.Main;

import java.util.*;

import com.Modules.*;
import com.Services.*;

public class CollegeCourseRegistrationSystem {

    static Scanner sc = new Scanner(System.in);

    static UserServices us = new UserServices();
    static CourseServices cs = new CourseServices();
    static RegistrationServices rs = new RegistrationServices();

    public static void main(String[] args) {

        int choice;

        do {
           
            System.out.println("----------COLLEGE COURSE REGISTRATION SYSTEM-----------");
           

            System.out.println("1. Admin Login");
            System.out.println("2. Student Registration");
            System.out.println("3. Student Login");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:
                adminLogin();
                break;

            case 2:
                studentRegistration();
                break;

            case 3:
                studentLogin();
                break;

            case 4:
                System.out.println("Thank You!");
                break;

            default:
                System.out.println("Invalid Choice");
            }

        } while (choice != 4);
    }

    // Student Registration
    private static void studentRegistration() {

        System.out.println("------STUDENT REGISTRATION------");

        System.out.print("Enter Student Id: ");
        int studentId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        System.out.print("Enter Mobile Number: ");
        String mobileNumber = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Year: ");
        int year = sc.nextInt();

        Student student = new Student(studentId,studentName,email, password,mobileNumber,department,year);

        us.addStudent(student);
    }

    // Student Login
    private static void studentLogin() {

        sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        Student student = us.studentLogin(email, password);

        if (student != null) {

            System.out.println("Login Successful");

            studentMenu(student);

        } else {

            System.out.println("Invalid Credentials");
        }
    }

    // Student Menu
    private static void studentMenu(Student student) {

        int choice;

        do {

            System.out.println("------STUDENT MENU-----");

            System.out.println("1. View All Courses");
            System.out.println("2. Search Course");
            System.out.println("3. Register for Course");
            System.out.println("4. Drop Course");
            System.out.println("5. View My Registered Courses");
            System.out.println("6. Logout");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:
                cs.displayCourses();
                break;

            case 2:
                searchCourse();
                break;

            case 3:
                registerCourse(student);
                break;

            case 4:
                dropCourse(student);
                break;

            case 5:
                rs.viewStudentRegistrations(student);
                break;

            case 6:
                System.out.println("Student Successfully Logged Out");
                break;

            default:
                System.out.println("Invalid Choice");
            }

        } while (choice != 6);
    }

    // Search Course
    private static void searchCourse() {

        System.out.print("Enter Course Id: ");
        int courseId = sc.nextInt();

        Course course = cs.searchByCourseId(courseId);

        if (course != null) {

            System.out.println("Course Found");
            System.out.println(course);

        } else {

            System.out.println("Course Not Found");
        }
    }

    // Register Course
    private static void registerCourse(Student student) {

        cs.displayCourses();

        System.out.print("\nEnter Course Id to Register: ");
        int courseId = sc.nextInt();

        Course course = cs.searchByCourseId(courseId);

        if (course == null) {

            System.out.println("Course Not Found");
            return;
        }

        rs.registerCourse(student, course);
    }

    // Drop Course
    private static void dropCourse(Student student) {

        rs.viewStudentRegistrations(student);

        System.out.print("\nEnter Course Id to Drop: ");
        int courseId = sc.nextInt();

        rs.dropCourse(student, courseId);
    }

    // Admin Login
    private static void adminLogin() {

        sc.nextLine();

        System.out.print("\nEnter Admin Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Admin Password: ");
        String password = sc.nextLine();

        Admin admin = us.adminLogin(email, password);

        if (admin != null) {

            System.out.println("Welcome Admin");

            adminMenu();

        } else {

            System.out.println("Invalid Credentials");
        }
    }

    // Admin Menu
    private static void adminMenu() {

        int choice;

        do {

            System.out.println("------ADMIN MENU------ ");

            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Search Course");
            System.out.println("4. Delete Course");
            System.out.println("5. View All Students");
            System.out.println("6. View All Registrations");
            System.out.println("7. Logout");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:
                addCourse();
                break;

            case 2:
                cs.displayCourses();
                break;

            case 3:
                searchCourse();
                break;

            case 4:
                deleteCourse();
                break;

            case 5:
                us.displayStudents();
                break;

            case 6:
                rs.viewAllRegistrations();
                break;

            case 7:
                System.out.println("Admin Successfully Logged Out");
                break;

            default:
                System.out.println("Invalid Choice");
            }

        } while (choice != 7);
    }

    // Add Course
    private static void addCourse() {

        System.out.println("------ADD COURSE-----");

        System.out.print("Enter Course Id: ");
        int courseId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course Name: ");
        String courseName = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Instructor Name: ");
        String instructorName = sc.nextLine();

        System.out.print("Enter Credits: ");
        int credits = sc.nextInt();

        System.out.print("Enter Maximum Seats: ");
        int maxSeats = sc.nextInt();

        Course course = new Course(courseId, courseName, department,instructorName,credits, maxSeats, maxSeats );

        cs.addCourse(course);
    }

    // Delete Course
    private static void deleteCourse() {

        System.out.print("\nEnter Course Id to Delete: ");
        int courseId = sc.nextInt();

        cs.deleteCourse(courseId);
    }
}