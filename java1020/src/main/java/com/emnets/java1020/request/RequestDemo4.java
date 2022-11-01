package com.emnets.java1020.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RequestDemo4", value = "/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String referer =  request.getHeader("referer");
       System.out.println(referer);

       //   防盗链
        //  这个防盗链有点弱智，毕竟有token，并且还有跨域限制，盗链基本不存在
        if(referer !=null){
            if(referer.contains("/java1019")){
                System.out.println("正常播放");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("播放电影");
            }else{
                System.out.println("请转到java1019访问");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
