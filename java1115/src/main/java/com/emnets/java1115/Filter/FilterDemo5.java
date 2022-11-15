package com.emnets.java1115.Filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebFilter(value = "/*",dispatcherTypes = DispatcherType.REQUEST)
//@WebFilter(value = "/*",dispatcherTypes = DispatcherType.FORWARD)
//@WebFilter(value = "/*",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class FilterDemo5 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("forward is filtered");
        chain.doFilter(request, response);
    }
}
