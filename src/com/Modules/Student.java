package com.Modules;

public class Student extends User {

    private String mobileNumber;
    private String department;
    private int year;

    public Student() {
    }

    public Student(int userId, String userName, String mailID,String password,String mobileNumber, String department, int year) {

        super(userId, userName, mailID, password);

        this.mobileNumber = mobileNumber;
        this.department = department;
        this.year = year;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {

        return "Student [studentId=" + getUserId() + ", studentName=" + getUserName()+ ", email=" + getMailID()
               + ", mobileNumber=" + mobileNumber  + ", department=" + department + ", year=" + year + "]";
    }
}