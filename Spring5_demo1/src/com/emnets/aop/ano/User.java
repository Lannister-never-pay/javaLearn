package com.emnets.aop.ano;

import org.springframework.stereotype.Component;

/**
 * @author lannisite
 * @program User
 * @description 描述
 * @date 2023/2/10 22:59
 */

//  被增强的类
@Component
public class User {
    public void add(){
        System.out.println("add!");
    }
}
