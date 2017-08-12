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
            <th>部门名称</th>
            <th>部门简介</th>
        </tr>
            <tr>
                <td>${department.departmentName}</td>
                <td>${department.departmentDescription}</td>
            </tr>
    </table>
</center>
</body>
</html>