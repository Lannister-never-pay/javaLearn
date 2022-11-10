<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: lannisite
  Date: 2022/11/9
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%

        Cookie[] cookies = request.getCookies();
        String lastTime=null;
        if(cookies!=null && cookies.length > 0){
            for(Cookie c:cookies){

                if(c.getName().equals("lastTime")){
                    lastTime = c.getValue();
                }
            }
        }
        if(lastTime!=null){
            //URL 解码
            String decode = URLDecoder.decode(lastTime,"utf-8");
    %>
            <h1>欢迎回来 上次访问时间：<%=decode%><h1>
    <%
        }else{
    %>

        <h1>欢迎首次访问<h1>

    <%
        }
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String format = dateFormat.format(date);

        //  URL编码
        String encode = URLEncoder.encode(format, "utf-8");


        Cookie cookie =  new Cookie("lastTime",encode);
        cookie.setMaxAge(60*60*24*30);
        response.addCookie(cookie);
    %>

</body>
</html>
