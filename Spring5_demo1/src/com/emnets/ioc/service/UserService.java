package com.emnets.ioc.service;

import com.emnets.ioc.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author lannisite
 * @program UserService
 * @description 描述
 * @date 2023/2/10 10:54
 */

//在注解里面 value 属性值可以省略不写，相当于bean中的id
// 默认值是类名称，首字母小写
// UserService -- userService
@Component(value = "userService")   //  等价于：<bean id ="userService" class = "package path">
public class UserService {

    //  定义Dao属性，并且不需要set方法！
//    @Autowired
//    @Qualifier(value = "userDaoImpl1")
//    private UserDao userDao;


    //@Resource                        //   根据类型进行注入
    @Resource(name = "userDaoImpl1")   //   根据名称进行注入
    private UserDao userDao;

    @Value(value = "value annotation")
    private String name;


    public void add(){
        System.out.println(name);
        userDao.add();

    }
}
