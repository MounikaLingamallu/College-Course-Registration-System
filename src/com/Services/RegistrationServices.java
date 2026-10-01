package com.Services;

import java.util.ArrayList;
import com.Modules.Course;
import com.Modules.Registration;
import com.Modules.Student;

public class RegistrationServices {
	
    private ArrayList<Registration> registrationList =new ArrayList<>();

    private int registrationCounter = 1;

    // Register Course
    public void registerCourse(Student student, Course course) {
        if (course.getAvailableSeats() <= 0) {
            System.out.println("No Seats Available for this Course");
            return;
        }

        if (isAlreadyRegistered(student, course)) {
            System.out.println("Student is already registered for this Course");
            return;
        }

        Registration registration = new Registration( registrationCounter++,student,course);
        registrationList.add(registration);

        // Reduce available seats
        course.setAvailableSeats(course.getAvailableSeats() - 1);
        System.out.println("Course Registration Successful");
        System.out.println(registration);
    }

    // Check Duplicate Registration
    public boolean isAlreadyRegistered(Student student,Course course) {
        for (Registration registration : registrationList) {
            if (registration.getStudent().getUserId() == student.getUserId()&&registration.getCourse().getCourseId()== course.getCourseId()) {
                return true;
            }
        }
        return false;
    }

    // Search Registration
    public Registration searchRegistration(int registrationId) {
        for (Registration registration : registrationList) {
            if (registration.getRegistrationId()  == registrationId) {
                return registration;
            }
        }

        return null;
    }

    // Drop Course
    public void dropCourse( Student student,int courseId) {
        Registration registration = null;
        for (Registration r : registrationList) {
            if (r.getStudent().getUserId()== student.getUserId()&& r.getCourse().getCourseId()== courseId) {
                registration = r;
                break;
            }
        }

        if (registration != null) {
            Course course = registration.getCourse();

            // Restore seat
            if (course.getAvailableSeats() < course.getMaxSeats()) {
                course.setAvailableSeats(course.getAvailableSeats() + 1 );
            }
                registrationList.remove(registration);
                System.out.println("Course Dropped Successfully");
            } else {
            	System.out.println( "Registration Not Found");
        }
    }

    // View All Registrations
    public void viewAllRegistrations() {
        if (registrationList.isEmpty()) {
            System.out.println(
                    "No Registrations Available");
            return;
        }
        for (Registration registration :registrationList) {
            System.out.println(registration);
        }
    }

    // View Student Registrations
    public void viewStudentRegistrations(Student student) {
        boolean found = false;
        for (Registration registration : registrationList) {
            if (registration.getStudent() .getUserId()== student.getUserId()) {
                System.out.println(registration);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No Registered Courses Available");
        }
    }

    public int totalRegistrations() {
        return registrationList.size();
    }
}