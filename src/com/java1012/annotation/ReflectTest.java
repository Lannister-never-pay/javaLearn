package com.java1012.annotation;

/**
 * @author lannisite
 * @program ReflectTest
 * @description 描述
 * @date 2022/10/12 15:05
 */

import com.sun.tools.javac.comp.Annotate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 框架类
 */
@Pro(className = "com.java1012.annotation.Demo1",method = "show")
public class ReflectTest {

    public static void main(String[] args) throws Exception {

        //  1.解析注解，
        //  1.1 获取该类的字节码文件的对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;

        //  2.获取上边的注解对象
        Pro an  = reflectTestClass.getAnnotation(Pro.class);//  其实就是在内存中生成了一个该注解接口的子类实现对象
 
        //  3.调用注解对象中定义的抽象方法，获取返回值
        String className = an.className();
        String methodName = an.method();
        System.out.println(className);
        System.out.println(methodName);

        Class cls = Class.forName(className);

        Object obj = cls.newInstance();

        Method method = cls.getMethod(methodName);

        method.invoke(obj);
    }
}
