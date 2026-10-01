package com.Modules;

public class Course {

    private int courseId;
    private String courseName;
    private String department;
    private String instructorName;
    private int credits;
    private int maxSeats;
    private int availableSeats;

    public Course() {
    }

    public Course(int courseId,String courseName,String department,String instructorName,int credits, int maxSeats, int availableSeats) {

        this.courseId = courseId;
        this.courseName = courseName;
        this.department = department;
        this.instructorName = instructorName;
        this.credits = credits;
        this.maxSeats = maxSeats;
        this.availableSeats = availableSeats;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {

        return "Course [courseId=" + courseId + ", courseName=" + courseName+ ", department=" + department + ", instructorName=" + instructorName+ ", credits=" + credits
                + ", maxSeats=" + maxSeats + ", availableSeats=" + availableSeats + "]";
    }
}