package emnets.java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Java8内置的四大核心函数式接口
 *
 * Consumer\<T> 消费型接口
 *
 * Supplier\<T> 供给型接口
 *
 * Function\<T,R> 函数型接口
 *
 * Predicate\<T> 断定型接口
 */

public class TestLambda3 {


    @Test
    public void test1(){
       consumerLambda(100.0,x-> System.out.println("consume $"+x));
    }

    /**
     * consumer<T> 消费型接口
     */
    public void consumerLambda(double money, Consumer<Double> con){
        con.accept(money);
    }


    @Test
    public void test2(){
        System.out.println(supplyLambda(10,()->(int) (Math.random()*100))); ;
    }

    /**
     * Supplier<T> 供给型接口
     */
    public List<Integer> supplyLambda(int num, Supplier<Integer>sup){
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<num;i++){
            list.add(sup.get());
        }
        return list;
    }

    @Test
    public void test3(){
        System.out.println(FunctionLambda("hello lambda", String::toUpperCase));
    }

    /**
     * 函数型接口
     */
    public String FunctionLambda(String str, Function<String,String>fun){
        return fun.apply(str);
    }

    @Test
    public void test4(){
        System.out.println(PredicateLambda(Arrays.asList("fewf","fgreg","f","g","fe","oq","gfewgr"), x->x.length()>2));
    }

    /**
     * 断言型接口
     */
    public List<String> PredicateLambda(List<String>str, Predicate<String> pre){
        return str.stream().filter(pre).collect(Collectors.toList());
    }



}
