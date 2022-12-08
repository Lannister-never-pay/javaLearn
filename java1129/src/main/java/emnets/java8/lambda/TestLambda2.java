package emnets.java8.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author lannisite
 * @program TestLambda2
 * @description 描述
 * @date 2022/11/30 11:25
 */

public class TestLambda2 {


    @Test
    public void test1(){

        /**
         * 匿名内部类
         */
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello lambda!");
            }
        };

        /**
         * lambda
         */
        Runnable r1 = () -> System.out.println("hello Lambda");

    }


    @Test
    public void test2(){
        Consumer<String> con = (x)->System.out.println(x);
        con.accept("hello lambda!");
    }

    @Test
    public void test3(){
        Comparator<Integer> com = (x,y)->{
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
    }

    public Integer operation(Integer num,MyFunction mf){
        return mf.getValue(num);
    }


    @Test
    public void test4(){
        System.out.println(operation(100,x->x*x));
    }





}
