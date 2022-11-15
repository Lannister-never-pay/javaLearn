package com.emnets.java1115.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lannisite
 * @program ProxyTest
 * @description 描述
 * @date 2022/11/15 20:22
 */

public class ProxyTest {


    public static void main(String[] args) {
        //  1.创建真实对象
        Lenovo lenovo = new Lenovo();

        /**
         *   2.动态代理增强lenovo对象
         *   三个参数：
         *      1.类加载器 : 真实对象.getClass().getClassLoader()
         *      2.接口数组 : 真实对象.getClass().getInterfaces()
         *      3.处理器   :
         */
        SaleComputer proxy_lenovo = (SaleComputer)Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 代理逻辑编写的方法：代理对象调用的所有方法，都会触发该方法执行。
             * 增强代码的逻辑就会在这个方法中执行
             * @param proxy 代理对象，就是指proxy_lenovo这个对象，一般不用
             * @param method 代理对象调用的方法会封装成对象，变成参数传递进来
             * @param args 代理对象调用方法时，传递的实际参数，封装进args,这里面就会有8000这种参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //  首先判断方法是否是需要增强的方法
                if(method.getName().equals("sale")){
                    //  1.增强返回值
                    double money = (double) args[0];
                    money *= 0.85;
                    System.out.println("专车接你....");
                    String obj = (String)method.invoke(lenovo, money);
                    System.out.println("免费送货....");
                    return obj+"_鼠标垫";
                }else {
                    //  相当于使用真实对象调用该方法
                    Object obj = method.invoke(lenovo, args);
                    //  这个返回值就是调用了方法后接收的返回值，会根据操作方法的不同而完全不同。
                    return obj;
                }
            }
        });

        //  3.调用方法
          String  computer = proxy_lenovo.sale(8000);
          System.out.println(computer);
        //proxy_lenovo.show();
    }
}
