package com.emnets.transaction.service;

import com.emnets.transaction.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lannisite
 * @program UserDao
 * @description 描述
 * @date 2023/2/16 22:11
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserService {

    @Autowired
    private UserDao userDao;

    //  转账方法
    public void accountMoney(){
        //  扣钱
        userDao.reduceMoney();
        //int i = 1/0;

        //  加钱
        userDao.addMoney();
    }
}
