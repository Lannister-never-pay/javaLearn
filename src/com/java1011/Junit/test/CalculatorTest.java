package com.java1011.Junit.test;

import com.java1011.Junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author lannisite
 * @program CalculatorTest
 * @description 描述
 * @date 2022/10/11 11:41
 */

public class CalculatorTest {

    @Before
    public void init(){
        System.out.println("初始化完成！");
    }

    @After
    public void close(){
        System.out.println("资源已释放！");
    }

    /**
     * 测试add方法
     */
    @Test
    public void testAdd(){
        System.out.println("测试开始执行：");
        Calculator c = new Calculator();
        int result = c.add(1,2);
        System.out.println(result);
        Assert.assertEquals(3,result);
    }


    /**
     * 测试sub方法
     */
    @Test
    public void testSub(){
        System.out.println("测试开始执行：");
        Calculator c = new Calculator();
        int result = c.sub(3,2);
        System.out.println(result);
    }
}
