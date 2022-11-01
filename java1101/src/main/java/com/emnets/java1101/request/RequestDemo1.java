package com.emnets.java1101.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @author lannisite
 * @program RequestDemo1
 * @description 描述
 * @date 2022/11/1 15:14
 */
@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //  post  获取请求参数
        String username = req.getParameter("username");
        System.out.println("post");
        System.out.println(username);

        String hobby[] = req.getParameterValues("hobby");
        for(String item : hobby){
            System.out.print(item+" ");
        }
        System.out.println();
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String name= parameterNames.nextElement();
            System.out.print(name+" : ");
            String parameter = req.getParameter(name);
            System.out.println(parameter);
        }

        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keyset = parameterMap.keySet();
        for(String key : keyset){
            //  根据key获取value
            String[] values = parameterMap.get(key);
            System.out.println(key+" : ");
            for(String v : values){
                System.out.print(v+" ");
            }
            System.out.println();
        }

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  get 获取请求参数
//        String username = req.getParameter("username");
//        System.out.println("get");
//        System.out.println(username);
//
//        String pwd[] = req.getParameterValues("password");
//        System.out.println(pwd);

            this.doPost(req,resp);
    }
}
