package com.emnets.aop;

/**
 * @author lannisite
 * @program UserDaoImpl
 * @description 描述
 * @date 2023/2/10 16:56
 */

public class UserDaoImpl implements UserDao {
    @Override
    public int add(int a, int b) {
        System.out.println("add方法执行了");
        return a+b;
    }

    @Override
    public String update(String id) {
        return id;
    }
}
