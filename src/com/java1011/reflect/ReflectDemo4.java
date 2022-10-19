package com.java1011.reflect;

/**
 * @author lannisite
 * @program ReflectDemo4
 * @description 描述
 * @date 2022/10/11 17:19
 */

import com.java1011.reflect.domain.Person;

import java.lang.reflect.Method;

/**
 * 反射获取方法
 */

public class ReflectDemo4 {

    public static void main(String[] args) throws Exception{

        Class personClass = Person.class;

        Method eatMethod = personClass.getMethod("eat",String.class);

        Person p = new Person();

        eatMethod.invoke(p,"meat");

        Method[] methods = personClass.getMethods();
        for (Method m:methods){
            System.out.println(m);
            System.out.println(m.getName());
        }


    }
}
