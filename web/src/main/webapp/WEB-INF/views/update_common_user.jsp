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
<center>
    <form  action="${website}user/修改/${userList.id}">
<table border="1">
    <tr>
    <td>用户名:</td>
    <td>
        <input type="text" name="username" value="${user.username}">
    </td>
    </tr>
    <tr>
        <td>原密码:</td>
        <td>${user.password}</td>
    </tr>
    <tr>
        <td>新密码:</td>
        <td>
            <input type="password" name="password">
        </td>
    </tr>

    <tr>
        <td colspan="2" align="center">
            <input type="submit" name="submit" value="提交">
        </td>
    </tr>
    </table>
    </form>
</center>
</body>
</html>
