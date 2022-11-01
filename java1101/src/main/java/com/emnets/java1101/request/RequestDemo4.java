package com.emnets.java1101.request;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lannisite
 * @program RequestDemo1
 * @description 描述
 * @date 2022/11/1 15:14
 */
@WebServlet("/RequestDemo4")
public class RequestDemo4 extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Object msg = req.getAttribute("msg");
        System.out.println("demo4 is accessed");
        System.out.println(msg);

        ServletContext servletContext = req.getServletContext();
        System.out.println(servletContext);
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
