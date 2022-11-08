package com.emnets.java1101.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 获取字符输出流
 */



@WebServlet(name = "ResponseDemo4", value = "/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1。设置流的编码
        response.setCharacterEncoding("GBK");
        //  2。告诉浏览器，服务器发生的消息体数据的编码。建议浏览器使用该编码解码
        response.setHeader("Content-type","text/html;charset=utf-8");
        //  3.简单设置方法：
        response.setContentType("text/html;charset=utf-8");

        //  1.获取字符输出流
        PrintWriter pw = response.getWriter();

        //  2.输出数据
        //  response获取的流不需要刷新，因为response在一次响应完成后会自动的被销毁
        pw.write("<h1> hello response </h1>");
        //  流的print方法可以自动刷新
        pw.print("");

    }
}
