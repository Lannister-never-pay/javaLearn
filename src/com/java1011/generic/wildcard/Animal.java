package com.java1011.generic.wildcard;

/**
 * @author lannisite
 * @program animal
 * @description 描述
 * @date 2022/10/10 15:40
 */

public class Animal {

    private String name;
    private int age;

    public Animal(){

    }

    public Animal(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public void speak(){
        System.out.println(name+" is speaking!");
    }

}
