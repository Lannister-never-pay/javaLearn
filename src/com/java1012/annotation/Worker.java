package com.java1012.annotation;

/**
 * @author lannisite
 * @program Worker
 * @description 描述
 * @date 2022/10/12 20:00
 */
@MyAnno(age = 25)
@MyAnno3
public class Worker {

    @MyAnno3
    public String name;

    @MyAnno3
    public void show(){

    }
}
