package com.Services;

import java.util.ArrayList;

import com.Modules.Course;

public class CourseServices {

    private ArrayList<Course> courseList = new ArrayList<>();

    // Add Course
    public void addCourse(Course course) {

        if (searchByCourseId(course.getCourseId()) != null) {

            System.out.println("Course Id already exists");
            return;
        }

        courseList.add(course);

        System.out.println("Course Added Successfully");
    }

    // Display Courses
    public void displayCourses() {

        if (courseList.isEmpty()) {

            System.out.println("No Courses Available");
            return;
        }

        for (Course course : courseList) {

            System.out.println(course);
        }
    }

    // Search Course
    public Course searchByCourseId(int id) {

        for (Course course : courseList) {

            if (course.getCourseId() == id) {

                return course;
            }
        }

        return null;
    }

    // Search Course by Name
    public Course searchByCourseName(String courseName) {

        for (Course course : courseList) {

            if (course.getCourseName()
                    .equalsIgnoreCase(courseName)) {

                return course;
            }
        }

        return null;
    }

    // Delete Course
    public void deleteCourse(int id) {

        Course course = searchByCourseId(id);

        if (course != null) {

            courseList.remove(course);

            System.out.println("Course Deleted Successfully");

        } else {

            System.out.println("Course Not Found");
        }
    }

    public int totalCourses() {

        return courseList.size();
    }
}