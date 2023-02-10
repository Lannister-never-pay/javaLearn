package com.emnets.spring5.dao;

import org.springframework.stereotype.Repository;

/**
 * @author lannisite
 * @program UserDaoImpl
 * @description 描述
 * @date 2023/2/10 14:46
 */

@Repository(value = "userDaoImpl1")
public class UserDaoImpl implements UserDao{

    @Override
    public void add() {
        System.out.println("userDao adds!");
    }
}
