package com.emnets.transaction.test;

import com.emnets.transaction.config.TxConfig;
import com.emnets.transaction.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author lannisite
 * @program TestAccount
 * @description 描述
 * @date 2023/2/16 22:18
 */

public class TestAccount {


     private static final UserService userService;

     static {
         ApplicationContext context = new  ClassPathXmlApplicationContext("bean03.xml");
         userService = context.getBean("userService",UserService.class);
     }

//    @Autowired
//    private UserService userService;



    @Test
    public void TestAccount(){
        userService.accountMoney();
    }



    @Test
    public void testAccount2(){
         ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
         UserService  userService = context.getBean("userService",UserService.class);
         userService.accountMoney();
    }


    @Test
    public void testGenericApplicationContext(){
         // 1.创建GenericApplicationContext对象
        GenericApplicationContext context = new GenericApplicationContext();
        //  2.调用context的方法对象注册
        context.refresh();
        context.registerBean("bean1",User.class,()->new User());
        //  3.获取在spring注册的对象
        User bean = context.getBean(User.class);
        Object bean1 = context.getBean("bean1");
        System.out.println(bean);
        System.out.println(bean1);
    }

}
