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
@WebServlet("/RequestDemo2")
public class RequestDemo2 extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //  1.设置流的编码：
        req.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");

        System.out.println(username);
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
