package com.java1011.reflect;

/**
 * @author lannisite
 * @program ReflectTest
 * @description 描述
 * @date 2022/10/12 15:05
 */

import com.java1011.reflect.domain.Person;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 框架类
 */
public class ReflectTest {


    public static void main(String[] args) throws Exception {

        // 1.1创建pro对象
        Properties pro = new Properties();

        // 1.2 加载配置文件，转换为一个集合
        // 1.2.1 类加载器
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        //  获取资源对应的字节流
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);

        //  2.获取配置文件中的定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        //  3.加载该类进内存
        Class cls = Class.forName(className);

        //  4.创建对象
        Object obj = cls.newInstance();

        //  5.获取方法对象
        Method method = cls.getMethod(methodName);

        //  6.执行方法
        method.invoke(obj);
    }
}
