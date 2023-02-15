package com.emnets.aop.test;

import com.emnets.aop.ano.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lannisite
 * @program TestAop
 * @description 描述
 * @date 2023/2/10 23:17
 */

public class TestAop {

    @Test
    public void testAopAno(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean02.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }

}
