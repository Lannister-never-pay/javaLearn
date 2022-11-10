<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取域中数据</title>
</head>
<body>


        <%
            request.setCharacterEncoding("utf-8");
            request.setAttribute("name","章北海");
            session.setAttribute("age",33);
            session.setAttribute("name","叶文洁");

        %>
    <h3>el获取值</h3>
    姓名：${requestScope.name}   年龄：${sessionScope.age}
    姓名
</body>
</html>
