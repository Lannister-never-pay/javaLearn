package emnets.java8.Stream;

import emnets.java8.domain.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import emnets.java8.domain.Employee.Status;

/**
 * @author lannisite
 * @program TestStreamAPI
 * @description 描述
 * @date 2022/12/1 17:29
 */

public class TestStreamAPI3 {

    //  需求：获取当前公司中年龄大于35的员工信息
    List<Employee> employees = Arrays.asList(
            new Employee("张三",18,9999.99, Status.FREE),
            new Employee("李四",38,5555.99,Status.BUSY),
            new Employee("王五",50,4329.99,Status.VOCATION),
            new Employee("赵六",16,7654.99,Status.BUSY),
            new Employee("田七",8,1663.99,Status.BUSY)
    );


    /**
     * 查找与匹配
     */
    @Test
    public void test1(){
        boolean b = employees.stream()
                .allMatch(e -> e.getStatus().equals(Status.BUSY));


        boolean b1 = employees.stream().anyMatch(e -> e.getStatus().equals(Status.BUSY));

        Optional<Employee> first = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .findFirst();

        first.orElse(new Employee());


        long count = employees.stream()
                .count();

        Optional<Double> min = employees.stream().map(Employee::getSalary).min(Double::compare);
        System.out.println(min.get());
    }


    @Test
    public void test3(){
        List<Integer>list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer reduce = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(reduce);


        Optional<Double> reduce1 = employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println();
    }

    @Test
    public void test4(){
        //  使用list
        List<String> collect = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

        //  使用set
        Set<String> set = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);

        //  使用构造
        HashSet<String> stringHashSet = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));

    }

    @Test
    public void test5(){
        Long aLong = employees.stream().collect(Collectors.counting());
        System.out.println(aLong);

        Double avg = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);

        Double sum = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);

        Optional<Employee> max = employees.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println(max.get());

        Optional<Double> min = employees.stream().map(Employee::getSalary).min(Double::compareTo);
        System.out.println(min.get());

        Map<Status, List<Employee>> statusListMap = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(statusListMap);
    }

    @Test
    public void test6() {
        Map<Status, List<Employee>> statusListMap =
                employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(statusListMap);
    }

    @Test
    public void test7() {
        Map<Status, Map<String, List<Employee>>> statusMapMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(e -> {
            if (e.getAge() > 50) return "老年";
            else if (e.getAge() <= 50 && e.getAge() > 30) return "中年";
            else return "青年";
        })));
        System.out.println(statusMapMap);
    }

    @Test
    public void test8(){
        Map<Boolean, List<Employee>> listMap = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 8000));

        DoubleSummaryStatistics collect = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect.getAverage());
        System.out.println(collect.getMax());
        System.out.println(collect.getSum());



        String collectStr = employees.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println(collectStr);


    }




}
