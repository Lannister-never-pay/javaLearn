package com.emnets.java1101.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "ServletContextDemo5", value = "/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  ServletContext获取
        ServletContext context = request.getServletContext();

        //  获取文件的服务器路径
        //  比如读取一个配置文件
        String realPath = context.getRealPath("/b.txt");
        File file = new File(realPath);
        System.out.println(realPath);

        realPath = context.getRealPath("/WEB-INF/c.txt");
        System.out.println(realPath);

        realPath = context.getRealPath("/a.txt");
        System.out.println(realPath);
    }
}
