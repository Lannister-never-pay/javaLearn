package emnets.java8.Stream;

import emnets.java8.domain.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author lannisite
 * @program TestStreamAPI
 * @description 描述
 * @date 2022/12/1 17:29
 */

public class TestStreamAPI {

    //  需求：获取当前公司中年龄大于35的员工信息
    List<Employee> employees = Arrays.asList(
            new Employee("张三",18,9999.99),
            new Employee("李四",38,5555.99),
            new Employee("王五",50,4329.99),
            new Employee("赵六",16,7654.99),
            new Employee("田七",8,1663.99)
    );





    /**
     * 创建Stream
     */
    @Test
    public void test1(){

        List<String>list = new ArrayList<>();
        Stream<String> stream = list.stream();

        Employee[] emps = new Employee[10];
        Stream<Employee> employeeStream = Arrays.stream(emps);

        Stream<String> stringStream = Stream.of("aa", "bb", "cc");

        //  迭代
        Stream<Integer> integerStream = Stream.iterate(0, (x) -> x + 2);

        //  生成
        Stream<Double> doubleStream = Stream.generate(Math::random);

    }

    @Test
    public void test2(){
        //  中间操作
        Stream<Employee> stream = employees.stream()
                .filter(e -> e.getAge() > 35);
        //  终止操作
        stream.forEach(System.out::println);
    }



}
