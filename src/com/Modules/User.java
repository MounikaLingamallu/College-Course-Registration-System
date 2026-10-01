package com.Modules;

public class User {

    private int userId;
    private String userName;
    private String mailID;
    private String password;

    public User() {
    }

    public User(int userId, String userName, String mailID, String password) {

        this.userId = userId;
        this.userName = userName;
        this.mailID = mailID;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMailID() {
        return mailID;
    }

    public void setMailID(String mailID) {
        this.mailID = mailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {

        return "User [userId=" + userId + ", userName=" + userName+ ", mailID=" + mailID + "]";
    }
}