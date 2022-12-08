package emnets.java8.domain;

/**
 * @author lannisite
 * @program Employee
 * @description 描述
 * @date 2022/11/29 16:21
 */

public class Employee {
    private String name;
    private int age;
    private double salary;
    private Status Status;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee(String name, int age, double salary, Employee.Status status) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        Status = status;
    }

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee.Status getStatus() {
        return Status;
    }

    public void setStatus(Employee.Status status) {
        Status = status;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", Status=" + Status +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public enum Status{
        FREE,
        BUSY,
        VOCATION
    }

}
