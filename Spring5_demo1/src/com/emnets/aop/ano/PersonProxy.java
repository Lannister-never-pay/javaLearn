package com.emnets.aop.ano;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author lannisite
 * @program PersonProxy
 * @description 描述
 * @date 2023/2/14 17:25
 */

@Component
@Aspect
@Order(1)
public class PersonProxy {

    //  @Before注解表示作为前置通知
    @Before(value = "execution(* com.emnets.aop.ano.User.add(..))")
    public void before(){
        System.out.println("Person before....");
    }


}
