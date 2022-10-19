package com.java1013.annotation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lannisite
 * @program TestCheck
 * @description 描述
 * @date 2022/10/13 11:14
 */

public class TestCheck {

    public static void main(String[] args) throws Exception {
        //  1.创建计算器对象
        Calculator calculator = new Calculator();

        //  2。获取字节码文件对象
        Class cls = calculator.getClass();
        //  3.获取所有的方法
        Method[] methods = cls.getDeclaredMethods();
        int number = 0; //  出现异常的次数
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));
        for(Method method:methods){
            //  4.判断方法上是否有check注解
            if(method.isAnnotationPresent(Check.class)){
                //  5.有则执行
                try {
                    method.invoke(calculator);
                } catch (Exception e) {
                    //  6.捕获异常，
                    number++;
                    bw.write(String.format("%s 方法出异常了！\n",method.getName()));
                    bw.write(String.format("异常名称： %s \n",e.getCause().getClass().getSimpleName()));
                    bw.write(String.format("异常原因： %s \n",e.getCause().getMessage()));
                    bw.write("-------------------------------\n");
                }
            }
        }

        bw.write(String.format("本次测试一共出现%d次异常\n",number));
        bw.flush();
        bw.close();

    }

}
