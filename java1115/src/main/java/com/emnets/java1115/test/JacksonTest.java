package com.emnets.java1115.test;


import com.emnets.java1115.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

/**
 * @author lannisite
 * @program JacksonTest
 * @description 描述
 * @date 2022/11/22 11:48
 */

public class JacksonTest {

    //  Java对象转为json（字符传串）
    @Test
    public void test1() throws Exception {
        Person p = new Person();
        p.setName("dyg");
        p.setAge(23);
        p.setGender("男");

        //  2.创建Jackson的核心对象  ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //  3.转换
        String json = mapper.writeValueAsString(p);
        System.out.println(json);

        //  写入文件
        mapper.writeValue(new File("./a.txt"),p);

        //  关联到writer中
        mapper.writeValue(new FileWriter("./b.txt"),p);

    }


    //  Java对象转为json相关的注解
    @Test
    public void test2() throws Exception {
        Person p = new Person();
        p.setName("dyg");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        //  2.创建Jackson的核心对象  ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //  3.转换
        String json = mapper.writeValueAsString(p);
        System.out.println(json);
    }


    //  Java对象转为json  List
    @Test
    public void test3() throws Exception {
        Person p = new Person();
        p.setName("dyg");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        Person p1 = new Person();
        p1.setName("gdf");
        p1.setAge(23);
        p1.setGender("男");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("fds");
        p2.setAge(23);
        p2.setGender("男");
        p2.setBirthday(new Date());



        List<Person> ps = new ArrayList<>();
        ps.add(p);
        ps.add(p1);
        ps.add(p2);

        //  2.创建Jackson的核心对象  ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //  3.转换
        String json = mapper.writeValueAsString(ps);
        System.out.println(json);
    }

    //  map
    @Test
    public void test4() throws Exception {

        Map<String,Object> map = new HashMap<>();
        map.put("name","zs");
        map.put("age",23);
        map.put("gender",true);


        //  2.创建Jackson的核心对象  ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //  3.转换
        String json = mapper.writeValueAsString(map);
        System.out.println(json);
    }

    @Test
    public void test5() throws Exception {
        //  1.
        String json = "{\"gender\":true,\"name\":\"zs\",\"age\":23}";
        //  2.
        ObjectMapper mapper = new ObjectMapper();
        //  3.
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);

    }




}
