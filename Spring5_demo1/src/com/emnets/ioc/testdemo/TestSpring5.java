package com.emnets.ioc.testdemo;

import com.emnets.ioc.bean.Book;
import com.emnets.ioc.bean.Emp;
import com.emnets.ioc.bean.Orders;
import com.emnets.ioc.collectiontype.Course;
import com.emnets.ioc.collectiontype.Stu;
import com.emnets.ioc.config.SpringConfig;
import com.emnets.ioc.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lannisite
 * @program TestSpring5
 * @description 描述
 * @date 2022/12/15 10:55
 */

public class TestSpring5 {

    @Test
    public void testBean1(){
        //  1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        //  2.获取配置文件
        User user = context.getBean("user", User.class);

        System.out.println(user);

        user.add();

    }


    @Test
    public void testBean3(){
        //  1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");

        //  2.获取配置文件
        Emp emp = context.getBean("emp", Emp.class);

        System.out.println(emp);

    }


    @Test
    public void testBean4(){
        //  1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");

        //  2.获取配置文件
        Emp emp = context.getBean("emp", Emp.class);

        System.out.println(emp);
    }


    @Test
    public void testBean2(){
        //  1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        //  2.获取配置文件
        Stu stu = context.getBean("stu", Stu.class);

        System.out.println(stu);
    }


    @Test
    public void testBean5(){
        //  1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");

        //  2.获取配置文件
        Book book = context.getBean("book", Book.class);

        System.out.println(book );
    }

    @Test
    public void testBean6(){
        //  1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean6.xml");

        //  2.获取配置文件
        Course book = context.getBean("MyBean", Course.class);

        System.out.println(book);
    }

    @Test
    public void testBean7(){
        //  1.加载spring配置文件
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean7.xml");
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bean7.xml");

        //  2.获取配置文件
        Orders orders = context.getBean("orders", Orders.class);

        System.out.println(orders);

        context.close();
    }


    @Test
    public void testBean8(){
        //  1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean8.xml");

        //  2.获取配置文件
        com.emnets.ioc.autowire.Emp emp = context.getBean("emp", com.emnets.ioc.autowire.Emp.class);
        
        System.out.println(emp);
    }

    @Test
    public void testService(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean01.xml");

        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }


    @Test
    public void testService2(){
        //  加载配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }

}
