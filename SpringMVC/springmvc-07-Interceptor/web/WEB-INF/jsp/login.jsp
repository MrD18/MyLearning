<%--
  Created by IntelliJ IDEA.
  User: yss
  Date: 2020/12/29
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<h1>登录页面</h1>
<hr>

<body>
<form action="${pageContext.request.contextPath}/user/login">
    用户名：<input type="text" name="username">
    密码：<input type="password" name="pwd">
    <input type="submit" value="提交">
</form>
</body>
</html>