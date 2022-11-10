package com.emnets.java1108.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");

        HttpSession session = request.getSession();
        String checkCode_session = (String)session.getAttribute("checkCode_session");
        session.removeAttribute("checkCode_session");


        if(checkCode_session!=null&&checkCode_session.equalsIgnoreCase(checkCode)){
            //  忽略大小写比较
            if("dyg".equals(username)&&"123456".equals(password)){

                session.setAttribute("user",username);

                response.sendRedirect(request.getContextPath()+"/success.jsp");
            }else{
                request.setAttribute("login_error","用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }

        }else {
            request.setAttribute("cc_error","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }


    }
}
