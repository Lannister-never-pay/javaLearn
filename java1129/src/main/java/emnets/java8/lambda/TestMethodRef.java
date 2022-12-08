package emnets.java8.lambda;

/**
 * @author lannisite
 * @program TestMethodRef
 * @description 描述
 * @date 2022/12/1 14:55
 */


import emnets.java8.domain.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用：若Lambda体中的
 */
public class TestMethodRef {

    @Test
    public void test1(){

        Consumer<String>con = x -> System.out.println(x);
        //  println 存在实例方法
        PrintStream ps = System.out;
        //  注意这里，println的括号都可以省略不写，因为只有方法名
        con = ps::println;
    }


    @Test
    public void test2(){
        Employee emp = new Employee();
        emp.setName("张三");
        Supplier<String> sup = emp::getName;
        System.out.println(sup.get());
    }


    @Test
    public void test3(){
        Comparator<Integer> com = Integer::compare;
    }

    @Test
    public void test4(){
        BiPredicate<String ,String> bp = (x,y) -> x.equals(y);
        bp = String::equals;
    }

    @Test
    public void test5(){
        Supplier<Employee> sup = ()->new Employee();
        Supplier<Employee> sup2 = Employee::new;

        Function<String,Employee> fun = (x) -> new Employee(x);
        Function<String,Employee> fun2 = Employee::new;
    }

    @Test
    public void test6(){
        Function<Integer,String[]> fun = x -> new String[x];
        Function<Integer,String[]> fun2 = String[]::new;
    }

}
