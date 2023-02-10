package com.emnets.ioc.collectiontype;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author lannisite
 * @program Stu
 * @description 描述
 * @date 2023/2/9 15:42
 */

public class Stu {

    private String[] courses;

    private List<String> list;

    private Map<String,String> maps;

    private Set<String>sets;

    private List<Course>courseList;

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "\n courses=" + Arrays.toString(courses) +
                "\n list=" + list +
                "\n maps=" + maps +
                "\n sets=" + sets +
                "\n sets=" + courseList +
                "\n}";
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }
}
