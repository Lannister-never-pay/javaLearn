package com.emnets.spring5.testdemo;

import com.emnets.spring5.User;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lannisite
 * @program TestSpring5
 * @description 描述
 * @date 2022/12/15 10:55
 */

public class TestSpring5 {

    @Test
    public void testAdd(){
        //  1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        //  2.获取配置文件
        User user = context.getBean("user", User.class);

        System.out.println(user);
        user.add();

    }
}
