package com.emnets.java1020.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "RequestDemo2", value = "/RequestDemo2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取所有请求头名称
        Enumeration<String> headerNames =  request.getHeaderNames();

        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();

            //2.通过请求头的名称获取请求头的值
            String value = request.getHeader(name);
            System.out.println(name+" : "+value);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
