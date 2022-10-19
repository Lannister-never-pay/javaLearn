package com.java1012.reflect.test;

import com.java1012.reflect.MyUtil;
import org.junit.Before;
import org.junit.Test;

/**
 * @author lannisite
 * @program copyPropertiesTest
 * @description 描述
 * @date 2022/10/12 12:22
 */

public class MyUtilTest {

    @Before
    public void init(){

    }

    @Test
    public void TestCopyProperties() throws Exception {
        Person zhangsan = new Person("zhangsan",true,25,"master","3701011999701014392","JiNan","student",180.0,70.0,2500);
        Student zhangsanStu = new Student();
        System.out.println(zhangsan.toString());
        System.out.println(zhangsanStu.toString());
        zhangsanStu = MyUtil.copyProperties(zhangsan,zhangsanStu);
        System.out.println("============================================");
        System.out.println(zhangsan.toString());
        System.out.println(zhangsanStu.toString());
    }



}
