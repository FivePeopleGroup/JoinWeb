<%--
  Created by IntelliJ IDEA.
  User: 芋头
  Date: 2017/8/10
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
<center style="margin-top: 100px">
    <h2>用户管理</h2>

    <%--遍历所有用户  传参“userList”，接受主页传的参数，并将其返回到真个页面--%>
    <table border="1">
        <tr bgcolor="#e6e6fa">
            <th>用户编号</th>
            <th>用户名</th>
            <th>用户类型</th>
            <th colspan="2">操作</th>
        </tr>
        <c:forEach items="${userList}"  var="userList" varStatus="status">
            <c:if test="${userStatus == '1' && userList.status == '0'}">
            <tr bgcolor="#e0ffff">
                <td>${status.index+1}</td>
                <td>${userList.username}</td>
                <td>普通用户</td>
                <td colspan="2" align="center"><a href="${website}user/delete/${userList.id}/${userStatus}">删除</a>
            </tr>
            </c:if>


            <c:if test="${userStatus == '2'}">
            <tr bgcolor="#e0ffff">
                <td>${status.index+1}</td>
                <td>${userList.username}</td>
            <c:if test="${userList.status == '0'}">
                <td>普通用户</td>
                <td><a href="${website}user/delete/${userList.id}/${userStatus}/${userId}">删除</a>
                <td><a href="${website}user/update/${userList.id}/${userStatus}/${userId}">修改</a>
            </c:if>
            <c:if test="${userList.status == '1'}">
                <td>管理员</td>
                <td><a href="${website}user/delete/${userList.id}/${userStatus}/${userId}">删除</a>
                <td><a href="${website}user/update/${userList.id}/${userStatus}/${userId}">修改</a>
            </c:if>
                <c:if test="${userList.status == '2'}">
                <td colspan="3" align="center">超级管理员</td>
                </c:if>

            </tr>
            </c:if>
        </c:forEach>
    </table>
    <th><a href="${website}user/qq/${userId}">返回主页</a></th>
</body>
</html>
