<%@ page import="com.emnets.java1108.domain.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取数据</title>
</head>
<body>

    <%
        User user = new User();
        user.setName("章北海");
        user.setAge(33);
        user.setBirthday(new Date());

        request.setAttribute("u",user);

        List list = new ArrayList();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        request.setAttribute("list",list);


        Map map = new HashMap();
        map.put("name","章北海");
        map.put("age",23);
        map.put("user",user);

        request.setAttribute("map",map);

    %>
<h3>el获取对象中的值</h3>
${requestScope.u.name}
${requestScope.u.birStr}
    <h3>el获取List中的值</h3>
    ${list}<br>
    ${list[1]}<br>
    ${list[2]}<br>

    <h3>el获取Map中的值</h3>
    ${map.name} : ${map["age"]} <br>
    ${map.user.birStr}

    <h3>empty运算符</h3>
<%
    String str = "abc";
    request.setAttribute("str",str);

    List list1 = new ArrayList();
    request.setAttribute("list1",list1);
%>
    ${not empty list1}


</body>
</html>
