package com.emnets.java1101.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ResponseDemo1", value = "/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            System.out.println("demo1");

            //  访问/responseDemo1，会自动跳转到/responseDemo2资源
            //  1.设置状态码302
            response.setStatus(302);
            //  2.设置响应头location
            response.setHeader("location","/java1101_war_exploded/responseDemo2");
            //  简便的重定向方法
            response.sendRedirect("/java1101_war_exploded/responseDemo2");
    }
}
