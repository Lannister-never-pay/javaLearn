package com.emnets.java1108.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lannisite
 * @program user
 * @description 描述
 * @date 2022/11/10 16:48
 */

public class User {

    private String name;
    private int age;
    private Date birthday;

    public String getBirStr(){
        if(birthday!=null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return simpleDateFormat.format(this.birthday);
        }
        return "";
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
