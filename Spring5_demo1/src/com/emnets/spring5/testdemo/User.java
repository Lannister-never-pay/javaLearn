package com.emnets.spring5.testdemo;

/**
 * @author lannisite
 * @program User
 * @description 描述
 * @date 2022/12/15 10:47
 */

public class User {

    private String username;




    public void add(){
        //System.out.println("add!");
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }

    public User() {

    }

    public User(String username) {
        this.username = username;
    }

    public void setUsername(String username) {
        this.username=username;
    }
}
