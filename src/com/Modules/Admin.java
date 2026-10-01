package com.Modules;

public class Admin extends User {

    public Admin(int userId, String userName,String mailID, String password) {
        super(userId, userName, mailID, password);
    }
    @Override
    public String toString() {
        return "Admin [userId=" + getUserId()+ ", userName=" + getUserName()+ ", mailID=" + getMailID() + "]";
    }
}