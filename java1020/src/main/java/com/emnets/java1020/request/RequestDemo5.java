package com.emnets.java1020.request;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "RequestDemo4", value = "/RequestDemo5")
public class RequestDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //  获取请求消息体

        //  1、获取字节流
        BufferedReader br =  request.getReader();
        ServletInputStream sis = request.getInputStream();

        sis.isFinished();

        //  2、读取数据
        String line = null;
        while ((line = br.readLine())!=null){
            System.out.println(line);
        }

    }
}
