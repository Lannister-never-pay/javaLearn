package com.emnets.java1020.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RequestDemo3", value = "/RequestDemo3")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //  演示获取请求头数据：user-agent
        String agent = request.getHeader("user-agent");
        System.out.println(agent);

        // 判断agent浏览器版本
        if(agent.contains("Chrome")){
            System.out.println("谷歌浏览器");
        }else if(agent.contains("Firefox")){
            System.out.println("火狐浏览器");
        }else if(agent.contains("Safari")){
            System.out.println("safari浏览器");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
