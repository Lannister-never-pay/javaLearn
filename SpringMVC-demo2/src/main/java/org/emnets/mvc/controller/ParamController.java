package org.emnets.mvc.controller;

import org.emnets.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author lannisite
 * @program ParamController
 * @description 描述
 * @date 2023/3/3 16:27
 */
@Controller
public class ParamController {


    /**
     * 通过servlet获取参数
     * @param request req
     * @return str
     */
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: "+username+" pwd: "+password);
        return "success";
    }

    /**
     * 通过控制器方法的形参获取请求参数
     */
    @RequestMapping("/testParam")
    public String testParm(@RequestParam("user_name")String username, @RequestParam("password") String password, String[] hobby){

        System.out.println("username: "+username+" pwd: "+password +" hobby: "+ Arrays.toString(hobby));
        return "success";
    }


    /**
     * 通过控制器方法的形参获取请求头信息
     */
    @RequestMapping("/testHeader")
    public String testHeader(@RequestHeader("Host") String host,HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println("host: "+host);
        return "success";
    }

    /**
     * 通过控制器方法的形参获取cookie信息
     */
    @RequestMapping("/testCookie")
    public String testCookie(@CookieValue("JSESSIONID") String JSessionID){
        System.out.println(JSessionID);
        return "success";
    }


    /**
     * 使用bean接收参数
     */
    @RequestMapping("/testBean")
    public String testBean(User user){
        System.out.println(user);
        return "success";
    }

}
