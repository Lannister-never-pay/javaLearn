package com.emnets.ioc.factorybean;

import com.emnets.ioc.collectiontype.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author lannisite
 * @program MyBean
 * @description 描述
 * @date 2023/2/9 17:08
 */

public class MyBean implements FactoryBean<Course> {

    //  定义返回bean
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("adv");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
