<%--
  Created by IntelliJ IDEA.
  User: 芋头
  Date: 2017/8/10
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>成员介绍</title>
</head>
<body>
<center style="margin-top: 100px">
    <h2>成员介绍</h2>

    <%--遍历所有成员  传参“memberList”--%>
    <table border="1">
        <tr bgcolor="#e6e6fa">
            <th>成员编号</th>
            <th>成员名称</th>
            <th>成员性别</th>
            <th>成员所属部门</th>
            <th>成员简介</th>
            <c:if test="${userstatus == '2'}">
                <th colspan="2">操作</th>
            </c:if>
        </tr>
        <c:forEach items="${memberList}"  var="member" varStatus="status">
            <tr bgcolor="#e0ffff">
                <td>${status.index+1}</td>
                <td>${member.memberName}</td>
                <td>${member.sex}</td>
                <td>联表查询</td>
                <td><textarea>${member.introduce}</textarea></td>
                <c:if test="${userstatus == '2'}">
                <td><a href="${website}member/删除/${member.id}">删除</a>
                <td><a href="${website}member/修改/${member.id}">修改</a>
                </c:if>
            </tr>
        </c:forEach>
    </table>
    <%--<th><a href="${website}news/新闻首页">返回主页</a></th>--%>
</center>
</body>
</html>
