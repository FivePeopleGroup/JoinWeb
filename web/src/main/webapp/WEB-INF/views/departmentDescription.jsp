<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Claus
  Date: 2017/8/11
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门介绍页面</title>
</head>
<body>
<center>
    <table border="1" style="text-align: center;font-size: 15px">
        <tr>
            <th>序号</th>
            <th>部门名称</th>
            <th>部门简介</th>
            <th>部门成员</th>
        </tr>
        <tr>
            <td>${Status.index+1}</td>
            <td>${department.departmentName}</td>
            <td>${department.departmentDescription}</td>
            <td>
                <c:forEach items="${memberList}" var="member" varStatus="Status">
                    ${member.memberName}
                </c:forEach>
            </td>
        </tr>
    <%--</table>--%>
    <%--<table border="1" style="text-align: center;font-size: 15px">--%>
        <%--<tr>部门成员</tr>--%>
        <%--<c:forEach items="${memberList}" var="member" varStatus="Status">--%>
            <%--<tr>--%>
                <%--<td>${member.memberName}</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
    <%--</table>--%>
</center>
</body>
</html>