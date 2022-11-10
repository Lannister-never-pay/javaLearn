<%--
  Created by IntelliJ IDEA.
  User: lannisite
  Date: 2022/11/10
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>服务器正忙</h1>
    <%
        String message = exception.getMessage();
        out.print(message);
    %>
</body>
</html>
