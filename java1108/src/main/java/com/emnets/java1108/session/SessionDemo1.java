package com.emnets.java1108.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/SessionDemo1")
public class SessionDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        //  期望客户端关闭后，session也能相同
        Cookie cookie = new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);



        session.setAttribute("msg","hello session");

    }
}
