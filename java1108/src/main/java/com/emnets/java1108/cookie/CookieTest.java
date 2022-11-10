package com.emnets.java1108.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 访问一个servlet，如果是第一次访问，则提示您好，欢迎首次访问；否则提示欢迎回来，你上一次访问：时间
 */
@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        Cookie[] cookies = request.getCookies();
        String lastTime=null;
        if(cookies!=null && cookies.length > 0){
            for(Cookie c:cookies){

                if(c.getName().equals("lastTime")){
                    lastTime = c.getValue();
                }
            }
        }
        if(lastTime!=null){
            //URL 解码
            String decode = URLDecoder.decode(lastTime,"utf-8");
            response.getWriter().write("<h1>欢迎回来 上次访问时间："+decode+"<h1>");
        }else{
            response.getWriter().write("<h1>欢迎首次访问！<h1>");
        }
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String format = dateFormat.format(date);

        //  URL编码
        String encode = URLEncoder.encode(format, "utf-8");


        Cookie cookie =  new Cookie("lastTime",encode);
        cookie.setMaxAge(60*60*24*30);
        response.addCookie(cookie);
    }
}
