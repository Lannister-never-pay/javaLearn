package com.emnets.java1101.request;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/RequestDemo3")
public class RequestDemo3 extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo3 is accessed");

        //  存储数据到request域中
        req.setAttribute("msg","halo ha");

        req.getRequestDispatcher("RequestDemo4").forward(req,resp);

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
