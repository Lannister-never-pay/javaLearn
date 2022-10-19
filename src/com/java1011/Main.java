package com.java1011;

import com.java1011.generic.GenericClass;
import com.java1011.generic.GenericInterface;
import com.java1011.generic.function.NumberShowImpl;
import com.java1011.generic.function.StringShowImpl;
import com.java1011.generic.wildcard.Cat;

public class Main {

    /**
     * 测试范型类
     */
    public static void GenericClassTest(){
        GenericClass<String> demo = new GenericClass<>("this is my first generic!");
        System.out.println(demo.getValue());
        GenericClass<Integer> demo2 = new GenericClass<>(212);
        System.out.println(demo2.getValue());
    }

    /**
     * 测试范型接口
     */
    public static void GenericInterfaceTest(){
        GenericInterface<String> g1 = new StringShowImpl();
        g1.show("this is my first generic function!");
        GenericInterface<Integer> g2 = new NumberShowImpl();
        g2.show(328);
    }


    /**
     * 测试范型方法
     */
    public static void GenericMethodTest(){
        GenericClass.GenericFunction("das");
    }

    /**
     * 范型通配符测试
     */
    public static void wildcardTest(){
        Cat cat1 = new Cat();
        cat1.speak();
    }


    public static void main(String[] args) {

        //GenericClassTest();
        //GenericInterfaceTest();
        //GenericMethodTest();
        GenericInterface<Integer> g = new NumberShowImpl();
        g.show(123);

        NumberShowImpl n = new NumberShowImpl();
        n.show(123);
        n.see();


    }
}
