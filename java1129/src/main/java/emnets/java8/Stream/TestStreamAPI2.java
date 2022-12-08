package emnets.java8.Stream;

import emnets.java8.domain.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lannisite
 * @program TestStreamAPI
 * @description 描述
 * @date 2022/12/1 17:29
 */

public class TestStreamAPI2 {


    //  需求：获取当前公司中年龄大于35的员工信息
    List<Employee> employees = Arrays.asList(
            new Employee("张三",18,9999.99),
            new Employee("李四",38,5555.99),
            new Employee("王五",50,4329.99),
            new Employee("赵六",16,7654.99),
            new Employee("田七",8,1663.99)
    );


    @Test
    public void test1(){
        List<Employee> stream_api = employees.stream()
                .filter(x -> x.getAge() > 10).collect(Collectors.toList());
    }

    @Test
    public void test2(){
        employees.stream().filter(e->{
            System.out.println("limit");
               return  e.getSalary() > 5000;
        }).limit(5).forEach(System.out::println);
    }

    @Test
    public void test3(){
        employees.stream().filter(e->{
            System.out.println("limit");
            return  e.getSalary() > 5000;
        }).skip(2).forEach(System.out::println);
    }

    @Test
    public void test4(){
        employees.stream()
                .filter(e->e.getSalary() > 5000)
                .skip(2)
                .distinct()
                .forEach(System.out::println);
    }


    @Test
    public void test5(){
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
        list.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }


    public static Stream<Character> filterCharacter(String str){
        List<Character>list = new ArrayList<>();
        for(Character ch:str.toCharArray()){
            list.add(ch);
        }
        return list.stream();
    }

    @Test
    public void test6(){
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");

        //  用map，返回Stream<Stream<Character>>
        Stream<Stream<Character>> streamStream = list.stream()
                .map(TestStreamAPI2::filterCharacter);
        //  用flatMap，返回Stream<Character>
        Stream<Character> characterStream = list.stream()
                .flatMap(TestStreamAPI2::filterCharacter);
    }


    @Test
    public void test7(){

        employees.stream()
                .sorted((e1,e2)->{
                    if(e1.getAge()!=e2.getAge()){
                        return -e1.getAge()+e2.getAge();
                    }else return e1.getName().compareTo(e2.getName());
                }).forEach(System.out::println);
    }

}
