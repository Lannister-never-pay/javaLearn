package com.java1011.reflect;

/**
 * @author lannisite
 * @program ReflectDemo1
 * @description 描述
 * @date 2022/10/11 15:23
 */

import com.java1011.reflect.domain.Person;
import com.java1011.reflect.domain.Student;

/**
 * 获取Class的三种方式
 * 1. Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
 * 2. 类名.class：通过类名.class属性方式获取
 * 3. 对象.getClass()：通过对象继承的Object类里的getClass方法获取。
 */
public class ReflectDemo1 {


    public static void main(String[] args) throws Exception {

        //  1. Class.forName
        Class<?>cls =  Class.forName("com.java1011.reflect.domain.Person");
        System.out.println(cls);

        //  2.
        Class<?> cls2 = Person.class;
        System.out.println(cls2);

        //  3.
        Person p = new Person();
        Class<? extends Person> cls3 =  p.getClass();
        System.out.println(cls3);

        //  == 笔记是否指向堆内存中同一个对象
        System.out.println(cls==cls2);  //  true
        System.out.println(cls2==cls3); //  true

        Class c = Student.class;
    }
}
