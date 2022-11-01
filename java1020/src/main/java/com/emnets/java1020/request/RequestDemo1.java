package com.emnets.java1020.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RequestDemo1", value = "/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  1.获取请求方式 GET
        System.out.println(request.getMethod());
        //  2.获取虚拟目录
        System.out.println(request.getContextPath());
        //  3.获取Servlet路径
        System.out.println(request.getServletPath());
        //  4.获取get方式的请求参数：
        System.out.println(request.getQueryString());
        //  5.获取请求URI
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());
        //  6.获取协议及版本
        System.out.println(request.getProtocol());
        //  7.获取客户机的IP地址
        System.out.println(request.getRemoteAddr());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
