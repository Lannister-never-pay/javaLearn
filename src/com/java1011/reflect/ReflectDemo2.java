package com.java1011.reflect;

/**
 * @author lannisite
 * @program ReflectDemo2
 * @description 描述
 * @date 2022/10/11 16:27
 */

import com.java1011.reflect.domain.Person;
import sun.misc.Perf;

import java.lang.reflect.Field;

/**
 * 1. 获取成员变量
 *    1. Field[]  getFields()；Field  getField(String name);
 *    2. Field[]  getDeclaredFields()；Field  getDeclaredField(String name);
 * 2. 获取构造方法: 跟上面类似：Constructor<?>[] getConstructors()
 * 3. 获取成员方法 :Method[] getMethods();
 * 4. 获取类名   String getName()
 */
public class ReflectDemo2 {



    public static void main(String[] args) throws Exception {

        //  0.获取class对象
        Class personCls = Person.class;

        //  1.获取成员变量
        Field[] fields = personCls.getDeclaredFields();
        for (Field f:fields){
            System.out.println(f.getName());
        }

        //  1.2 获取制定名称的变量
        Field a = personCls.getField("a");
        //  获取成员变量a的值
        Person p = new Person();
        Object value = a.get(p);
        System.out.println(value);
        a.set(p,"张三");
        System.out.println(p.toString());
    }
}
