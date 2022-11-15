package com.emnets.java1115.Filter;

import jdk.nashorn.internal.ir.RuntimeNode;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo2 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //  对request对象的请求消息增强
        System.out.println("filterDemo2...");

        //  放行
        chain.doFilter(request, response);
        //  对response对象的响应消息增强
        System.out.println("filterDemo2 executing!");
    }
}
