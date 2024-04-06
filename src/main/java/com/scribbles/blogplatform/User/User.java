package com.scribbles.blogplatform.User;

public class User {
    private int UserId;
    private String  UserName;
    private String  UserPhoneNo;
    private String UserEmail;

    public User(int userId, String userName, String userPhoneNo, String userEmail) {
        UserId = userId;
        UserName = userName;
        UserPhoneNo = userPhoneNo;
        UserEmail = userEmail;
    }

    public User() {

    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPhoneNo() {
        return UserPhoneNo;
    }

    public void setUserPhoneNo(String userPhoneNo) {
        UserPhoneNo = userPhoneNo;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", UserName='" + UserName + '\'' +
                ", UserPhoneNo=" + UserPhoneNo +
                ", UserEmail='" + UserEmail + '\'' +
                '}';
    }
}
