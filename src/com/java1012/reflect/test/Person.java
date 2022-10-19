package com.java1012.reflect.test;

/**
 * @author lannisite
 * @program Person
 * @description 描述
 * @date 2022/10/12 12:05
 */

public class Person {

    public String name;
    public boolean gender;
    public int age;
    public String degree;

    private String idNumber;
    private String address;
    private String job;
    private double height;
    private double weight;

    protected double wealth;

    public Person(){

    }

    public Person(String name, boolean gender, int age, String degree, String idNumber, String address, String job, double height, double weight, double wealth) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.degree = degree;
        this.idNumber = idNumber;
        this.address = address;
        this.job = job;
        this.height = height;
        this.weight = weight;
        this.wealth = wealth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", degree='" + degree + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", address='" + address + '\'' +
                ", job='" + job + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", wealth=" + wealth +
                '}';
    }
}
