package emnets.java8.lambda;

import com.sun.source.util.Trees;
import emnets.java8.domain.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lannisite
 * @program TestLambda
 * @description 描述
 * @date 2022/11/29 16:10
 */

public class TestLambda {

    /**
     * 匿名内部类
     */
    @Test
    public void test1(){

        //  匿名内部类实现接口，匿名内部类的实例作为参数
        Comparator<Integer> com =  new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    /**
     * lambda表达式
     */
    @Test
    public void test2(){
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
        TreeSet<Integer> ts = new TreeSet<>(Integer::compare);
    }

    //  需求：获取当前公司中年龄大于35的员工信息
    List<Employee> employees = Arrays.asList(
            new Employee("张三",18,9999.99),
            new Employee("李四",38,5555.99),
            new Employee("王五",50,4329.99),
            new Employee("赵六",16,7654.99),
            new Employee("田七",8,1663.99)
    );






    @Test
    public void test3(){
        FilterEmployees(employees).forEach(System.out::println);
    }

    public List<Employee> FilterEmployees(List<Employee>list){

        return list.stream().filter(x->x.getAge()>35&&x.getSalary()>5000).collect(Collectors.toList());
    }


    @Test
    public void test4(){

        Collections.sort(employees,(x,y)->{
            if(x.getAge()!=y.getAge())return Integer.compare(x.getAge(),y.getAge());
            else return x.getName().compareTo(y.getName());
        });

        employees.forEach(System.out::println);

    }


}
