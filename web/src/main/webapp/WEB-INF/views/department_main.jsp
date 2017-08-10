<%--
  Created by IntelliJ IDEA.
  User: 芋头
  Date: 2017/8/10
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>部门介绍</title>
</head>
<body>
<center style="margin-top: 100px">
    <h2>部门介绍</h2>

    <%--遍历所有部门  传参“departmentList”--%>
    <table border="1">
        <tr bgcolor="#e6e6fa">
            <th>部门编号</th>
            <th>部门名称</th>
            <th>部门简介</th>
            <c:if test="${userstatus == '2'}">
            <th colspan="2">操作</th>
            </c:if>
        </tr>
        <c:forEach items="${departmentList}"  var="department" varStatus="status">
                <tr bgcolor="#e0ffff">
                    <td>${status.index+1}</td>
                    <td><a href="${website}department/部门内容显示/">${department.departmentName}</a></td>
                    <td><textarea>${department.departmentDescription}</textarea></td>
                    <c:if test="${userstatus == '2'}">
                    <td><a href="${website}department/删除/${department.id}">删除</a>
                    <td><a href="${website}department/修改/${department.id}">修改</a>
                    </c:if>
                </tr>
        </c:forEach>
    </table>
    <%--<th><a href="${website}news/新闻首页">返回主页</a></th>--%>
</center>
</body>
</html>
