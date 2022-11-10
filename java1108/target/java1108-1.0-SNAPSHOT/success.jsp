<%--
  Created by IntelliJ IDEA.
  User: lannisite
  Date: 2022/11/9
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h1><%=request.getSession().getAttribute("user")%>欢迎您！</h1>

</body>
</html>
