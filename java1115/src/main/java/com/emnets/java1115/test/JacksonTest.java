package com.emnets.java1115.test;


import com.emnets.java1115.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;

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

        mapper.writeValue(new File("./a.txt"),p);

    }

}
