package org.emnets.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    /**
     * 使用restFul模拟用户资源的CRUD
     * /user       GET    查询所有
     * /user/1     GET    根据id查
     * /user      POST    添加用户信息
     * /user      DELETE  删除
     * /user      PUT     修改
     */

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有");
        return "success";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUserByID(@PathVariable("id")Integer id){
        System.out.println("查询所有id为"+id.toString()+"的用户");
        return "success";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String insertUser(String username,String password){
        System.out.println(username+" "+password);
        return "success";
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updateUser(String username,String password){
        System.out.println("修改用户信息"+username+" "+password);
        return "success";
    }






}
