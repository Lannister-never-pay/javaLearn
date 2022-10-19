package com.emnets.java1014.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author lannisite
 * @program ServletDemo2
 * @description Servlet方法
 * @date 2022/10/14 15:54
 */

public class ServletDemo2 implements Servlet {

    /**
     *  初始化方法
     *  Servlet被创建时执行，只会执行一次
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init....");
    }

    /**
     * 获取ServletConfig对象
     * ServletConfig：Servlet的配置对象
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     *  提供服务的方法
     *  每一次Servlet被访问的时候执行
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service....");
    }

    /**
     * 获取Servlet的一些信息
     * 一般不会实现
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 服务正常关闭时执行一次，只执行一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
