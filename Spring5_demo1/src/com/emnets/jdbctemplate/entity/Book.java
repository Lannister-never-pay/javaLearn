package com.emnets.jdbctemplate.entity;

/**
 * @author lannisite
 * @program User
 * @description 描述
 * @date 2023/2/16 11:53
 */

public class Book {
    private String userID;
    private String userName;
    private String uStatus;

    public String getUserID() {
        return userID;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", uStatus='" + uStatus + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public String getuStatus() {
        return uStatus;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setuStatus(String uStatus) {
        this.uStatus = uStatus;
    }
}
