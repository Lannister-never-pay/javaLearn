package com.java1012.annotation;

/**
 * @author lannisite
 * @program MyAnno
 * @description 描述
 * @date 2022/10/12 16:19
 */

public @interface MyAnno {

    //  ppublic 和 abstract 修饰符可以不写
    int age();
    String name() default "zhangsan";





}
