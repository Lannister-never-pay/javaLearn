package com.emnets.transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author lannisite
 * @program UserDaoImpl
 * @description 描述
 * @date 2023/2/16 22:12
 */

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void addMoney() {
        String sql = "update t_account set money=money+? where user_name=?";
        jdbcTemplate.update(sql,100,"mary");
    }

    @Override
    public void reduceMoney() {
        String sql = "update t_account set money=money-? where user_name=?";
        jdbcTemplate.update(sql,100,"lucy");
    }
}
