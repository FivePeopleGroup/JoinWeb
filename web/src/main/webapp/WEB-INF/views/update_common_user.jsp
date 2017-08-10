<%--
  Created by IntelliJ IDEA.
  User: 芋头
  Date: 2017/8/10
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>普通用户修改信息</title>
</head>
<body>
<table border="1">
    <tr>
    <td>用户名:</td>
    <td>
        <input type="text" name="username" value="${user.username}">
    </td>
    </tr>
    <tr>
        <td>密码:</td>
        <td>
            <input type="text" name="password" value="${user.password}">
        </td>
    </tr>

    <tr>
        <td colspan="2" align="center"><a href="${website}user/修改/${userList.id}">提交</a>
    </tr>
</body>
</html>
