package com.java1011.reflect;

/**
 * @author lannisite
 * @program ReflectDemo3
 * @description 描述
 * @date 2022/10/11 17:19
 */

import com.java1011.reflect.domain.Person;

import java.lang.reflect.Constructor;

/**
 * constructor 反射的相关函数
 */

public class ReflectDemo3 {

    public static void main(String[] args) throws Exception {

        Class personClass = Person.class;

        Constructor constructor = personClass.getConstructor(String.class,int.class);
        //  用构造器创建对象
        Object person = constructor.newInstance("zhangsan",23);
        System.out.println(person);

        personClass.newInstance();
    }
}
