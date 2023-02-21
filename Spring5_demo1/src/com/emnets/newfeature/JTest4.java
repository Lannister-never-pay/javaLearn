package com.emnets.newfeature;

import com.emnets.transaction.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lannisite
 * @program JTest4
 * @description 描述
 * @date 2023/2/17 16:12
 */

@RunWith(SpringJUnit4ClassRunner.class)     //指定现在使用的JUnit版本
@ContextConfiguration("classpath:bean02.xml")       //  加载指定配置文件
public class JTest4 {

    //  之前Service需要在context里面加载，现在由于context注解，可以直接注入Service对象
    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        userService.accountMoney();
    }
}
