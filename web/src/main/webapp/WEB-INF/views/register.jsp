<%--
  Created by IntelliJ IDEA.
  User: TestUser
  Date: 2017/8/11
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册用户界面</title>
</head>
<body>
<center>
<form  action="${website}user/doRegister" method="post">
    <table border="1" style="margin-top: 200px">
        <tr align="center">
            <td colspan="2" >
                <h2>
                    注册界面
                </h2>
            </td>
        </tr>
        <tr>
            <td>
                用户名
            </td>
            <td>
                <input type="text" value="" name="username">
            </td>
        </tr>
        <tr>
            <td>
                密码
            </td>
            <td>
                <input type="password" name="password" value="">
            </td>
        </tr>
        <tr>
            <td>
                请再一次输入密码
            </td>
            <td>
                <input type="password" name="password2" value="">
            </td>
        </tr>
        <tr align="center">
            <td colspan="2">
                <input type="submit" value="注册" name="login">
                <a href="${website}/news/list"> <input type="button" value="取消注册" name="cancel"></a>
            </td>
        </tr>
    </table>
    ${message}
</form>
</center>
</body>
</html>
