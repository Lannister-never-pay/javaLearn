package com.emnets.java1115.Filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebFilter(filterName = "/*")
//@WebFilter(value = "/*",dispatcherTypes = DispatcherType.REQUEST)
public class FilterDemo3 implements Filter {

    /**
     * 服务器启动后会创建Filter对象，然后调用init方法，服务器自动完成
     * @param config config
     * @throws ServletException ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init...");
    }

    public void destroy() {
        System.out.println("destroy...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("request is filtered");
        chain.doFilter(request, response);
    }
}
