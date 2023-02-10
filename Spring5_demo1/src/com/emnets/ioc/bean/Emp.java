package com.emnets.ioc.bean;

/**
 * @author lannisite
 * @program emp
 * @description 描述
 * @date 2023/2/9 14:58
 */

public class Emp {

    private String ename;
    private String gender;
    private Dept dept;      //  员工属于某一个部门，使用对象形式编写

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Dept getDept() {
        return dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", gender='" + gender + '\'' +
                ", dept=" + dept +
                '}';
    }
}
