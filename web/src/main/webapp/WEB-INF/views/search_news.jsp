<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 侯淑婷
  Date: 2017/8/11
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>搜索结果</title>
</head>
<body>
<table border="1" cellspacing="0" align="center">
    <tr align="center">
        <th>新闻编号</th>
        <th>新闻标题</th>
        <th>发布时间</th>
    </tr>
    <c:forEach items="${newsList}"  var="news" varStatus="status">
        <tr align="center">
            <td>${status.index+1}</td>
            <td><a href="${website}news/select/${news.id}/${userId}">${news.title}</a></td>
            <td>${news.date}</td>
        </tr>
    </c:forEach>
    <c:if test="${userId == '0'}">
    <tr align="center">
        <td colspan="3" align="center"><a href="${website}news/list">返回首页</a></td>
    </tr>
    </c:if>
    <c:if test="${userId != '0'}">
    <tr align="center">
        <td colspan="3" align="center"><a href="${website}user/qq/${userId}">返回首页</a></td>
    </tr>
    </c:if>
</table>
</body>
</html>
