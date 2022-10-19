package com.java1013.annotation;

/**
 * @author lannisite
 * @program Calculator
 * @description 描述
 * @date 2022/10/13 11:01
 */

public class Calculator {

    @Check
    public void add(){
        String str = null;
        str.toString();
        System.out.println("1+0="+(1+0));
    }
    @Check
    public void sub(){
        System.out.println("1-0="+(1-0));
    }
    @Check
    public void mul(){
        System.out.println("1*0="+(1*0));
    }
    @Check
    public void div(){
        System.out.println("1/0="+(1/0));
    }

    public void show(){
        System.out.println("Calculator is showing");
    }


}
