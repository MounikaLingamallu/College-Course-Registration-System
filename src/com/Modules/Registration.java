package com.Modules;

public class Registration {

    private int registrationId;
    private Student student;
    private Course course;

    public Registration() {
    }

    public Registration(int registrationId, Student student, Course course) {

        this.registrationId = registrationId;
        this.student = student;
        this.course = course;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {

        return "Registration [registrationId=" + registrationId + ", student=" + student.getUserName() + ", course=" 
                + course.getCourseName() + ", courseId=" + course.getCourseId() + "]";
        
    }
}