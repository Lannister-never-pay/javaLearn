package com.emnets.ioc.bean;

/**
 * @author lannisite
 * @program Dept
 * @description 描述
 * @date 2023/2/9 14:57
 */

public class Dept {
    private String dname;

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
