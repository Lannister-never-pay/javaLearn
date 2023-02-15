package com.emnets.aop.ano;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author lannisite
 * @program UserProxy
 * @description 描述
 * @date 2023/2/10 23:00
 */

//  增强方法类
@Component
@Aspect
@Order(3)
public class UserProxy {

    //  相同切入点
    @Pointcut("execution(* com.emnets.aop.ano.User.add(..))")
    public void pointDemo(){

    }


    //  做前置通知
    //  @Before注解表示作为前置通知
    @Before(value = "pointDemo()")
    public void before(){
        System.out.println("before....");
    }

    //  在增强方法之后执行,成为最终通知，不管有没有异常都会执行
    @After(value = "execution(* com.emnets.aop.ano.User.add(..))")
    public void after(){
        System.out.println("after.....");
    }

    //  在增强方法的返回值之后执行，如果有异常就不会执行
    @AfterReturning(value = "execution(* com.emnets.aop.ano.User.add(..))")
    public void afterReturning(){
        System.out.println("afterReturning.....");
    }

    //  仅在有异常时执行
    @AfterThrowing(value = "execution(* com.emnets.aop.ano.User.add(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing.....");
    }

    //  环绕通知，会在add之前和之后都执行
    @Around(value = "execution(* com.emnets.aop.ano.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前");

        //  被增强的方法,proceed方法表示
        proceedingJoinPoint.proceed();
        //  有异常之后就不会执行
        System.out.println("环绕之后");
    }
}
