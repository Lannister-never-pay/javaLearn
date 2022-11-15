package com.emnets.java1115.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 登录验证的过滤器
 */

//@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //  0.强制转换
        HttpServletRequest request = (HttpServletRequest)req;

        //  1.获取请求资源的请求路径
        String requestURI = request.getRequestURI();

        //  2.判断是否包含登录相关
        //  2.1 同时还要注意排除各种css/js/图片/验证码等资源
        if(requestURI.contains("/login.jsp")||requestURI.contains("/loginServlet")
                ||requestURI.contains("/css/*")||requestURI.contains("/js/*")||requestURI.contains("/checkCodeServlet")){
            //  放行登录
            chain.doFilter(req, resp);
        }else {
            //  3.session获取
            Object user = request.getSession().getAttribute("user");
            if(user!=null){
                //  已经登录了 ，放行
                chain.doFilter(req, resp);
            }else {
                //  跳转登录
                request.setAttribute("login_msg","您尚未登录");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }

    }
}
