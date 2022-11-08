package com.emnets.java1101.servletcontext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletContextDemo1", value = "/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  ServletContext获取
        ServletContext context1 = request.getServletContext();
        ServletContext context2 = this.getServletContext();

        System.out.println(context1==context2) ;    //  true

        //  3.定义文件名称
        String filename = "a.jpg";
        String mimeType = context1.getMimeType(filename);
        System.out.println(mimeType);


    }
}
