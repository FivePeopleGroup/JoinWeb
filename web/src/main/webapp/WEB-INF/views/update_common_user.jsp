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
    <form action="${website}user/doUpdate" method="post">

        <input type="hidden" name="id" value="${user.id}"/>
        <input type="hidden" name="status" value="${user.status}"/>
        <table border="1" style="margin-top: 200px">
            <%--<tr style="display: none">--%>
                <%--<td >--%>
                    <%--id--%>
                <%--</td>--%>
                <%--<td>--%>
                    <%--${user.id}"--%>
                <%--</td>--%>
            <%--</tr>--%>
            <tr>
                <td>用户名:</td>
                <td>
                    <input type="text" name="username" value="${user.username}" readonly>
                </td>
            </tr>
            <tr>
                <td>新密码:</td>
                <td>
                    <input type="password" name="password" value="">
                </td>
            </tr>
                <tr>
                    <td>
                        请输入新密码：
                    </td>
                    <td>
                        <input type="password" name="password2" value="">
                    </td>
                </tr>
            <tr align="center">
                <td  colspan="2">
                    <input type="submit" name="submit" value="提交">
                </td>
            </tr>
        </table>
        ${message}
    </form>
</center>
</body>
</html>
