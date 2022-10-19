package com.emnets.java1014.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author lannisite
 * @program ServletDemo1
 * @description Servlet快速入门
 * @date 2022/10/14 14:42
 */

public class ServletDemo1 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //  提供服务的方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello Servlet!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
