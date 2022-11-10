package com.emnets.java1108.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie快速入门
 */


@WebServlet("/CookieDemo3")
public class CookieDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //
        Cookie c1 = new Cookie("msg","hello_cookie");
        response.addCookie(c1);


        Cookie c2 = new Cookie("msg2","good_bye!");
        response.addCookie(c2);
    }
}
