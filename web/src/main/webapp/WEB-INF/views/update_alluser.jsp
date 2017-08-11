<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 芋头
  Date: 2017/8/11
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>超级管理员修改用户</title>
</head>
<body>
<center>
    <form  action="${website}user/管理员修改/${userList.id}" method="post">
        <table border="1">
            <tr>
                <td>用户名:</td>
                <td>
                    <input type="text" name="username" value="${user.username}" readonly>
                </td>
            </tr>
            <tr>
                <td>密码:</td>
                <td>
                    <input type="text" name="password" value="${user.password}" readonly>
                </td>
            </tr>
            <tr>
                <td>用户身份：</td>
                <select name="status">
                <td>
                    <c:if test="${user.status == '0'}">
                    <option selected='selected' value="0"/>普通用户</option>
                    <option value="1">管理员</option>
                    </c:if>
                    <c:if test="${user.status == '1'}">
                        <option selected='selected' value="1"/>管理员</option>
                        <option value="0">普通用户</option>
                    </c:if>
                </td>
                </select>
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
