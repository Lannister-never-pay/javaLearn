<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

    <%
        //  这些代码会打印到控制台
        System.out.println("hello Jsp!");
        String contextPath = request.getContextPath();

    %>

    <%!
        int i = 3;

    %>

    <%="hello world"

    %>

    <%--  这些代码会显示在页面  --%>
    <h1>hi jsp！</h1>
</body>
</html>