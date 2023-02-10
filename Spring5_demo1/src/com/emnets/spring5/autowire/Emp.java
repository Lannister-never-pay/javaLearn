package com.emnets.spring5.autowire;

/**
 * @author lannisite
 * @program Emp
 * @description 描述
 * @date 2023/2/9 22:50
 */

public class Emp {
    private Dept dept;

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void test(){
        System.out.println(dept);
    }
}
