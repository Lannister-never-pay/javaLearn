package com.emnets.java1101.test;

import com.emnets.java1101.domain.User;
import org.junit.Test;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @author lannisite
 * @program BeanUtilsTest
 * @description 描述
 * @date 2022/11/1 23:00
 */

public class BeanUtilsTest {

    @Test
    public void test(){

        User user = new User();
        try {
            BeanUtils.setProperty(user,"username","dyg");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
