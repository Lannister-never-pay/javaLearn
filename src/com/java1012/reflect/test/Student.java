package com.java1012.reflect.test;

/**
 * @author lannisite
 * @program student
 * @description 描述
 * @date 2022/10/12 12:12
 */

public class Student {
    public String name;
    public boolean gender;
    public int age;
    public String degree;

    private String idNumber;
    private String address;
    private double height;
    private double weight;

    private int mathGrade;
    private int chineseGrade;
    private int EnglishGrade;
    private int physicsGrade;
    private int biologyGrade;
    private int geographyGrade;

    public Student(){

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", degree='" + degree + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", address='" + address + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", mathGrade=" + mathGrade +
                ", chineseGrade=" + chineseGrade +
                ", EnglishGrade=" + EnglishGrade +
                ", physicsGrade=" + physicsGrade +
                ", biologyGrade=" + biologyGrade +
                ", geographyGrade=" + geographyGrade +
                '}';
    }
}
