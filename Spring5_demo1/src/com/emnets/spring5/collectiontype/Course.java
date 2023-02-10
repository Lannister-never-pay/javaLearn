package com.emnets.spring5.collectiontype;

/**
 * @author lannisite
 * @program Course
 * @description 描述
 * @date 2023/2/9 16:26
 */

public class Course {

    private String cname;

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cname='" + cname + '\'' +
                '}';
    }
}
