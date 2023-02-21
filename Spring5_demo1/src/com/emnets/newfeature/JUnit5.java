package com.emnets.newfeature;

import com.emnets.transaction.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author lannisite
 * @program JUnit5
 * @description 描述
 * @date 2023/2/17 16:30
 */

@SpringJUnitConfig(locations = "classpath:bean02.xml")
public class JUnit5 {

    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        userService.accountMoney();

        String[] list = new String[10];
        

    }
}
