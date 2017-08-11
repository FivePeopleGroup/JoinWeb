<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 侯淑婷
  Date: 2017/8/11
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索结果</title>
</head>
<body>
<form action="/news/list" method="get">
    <table cellspacing="0" border="1">
        <tr>
            <td>新闻条目：</td>
            <td>新闻标题：</td>
            <td>发布时间：</td>
            <td>修改</td>
            <td>删除</td>
        </tr>
        <c:forEach items="newsList" var="news" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td><a href="/news/select/${news.id}">${news.title}</a></td>
                <td>${news.date}</td>
                <td><a href="/news/to_edit/${news.id}">修改</a></td>
                <td><a href="/news/delete/${news.id}">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="2"><input type="submit" value="返回新闻首页"></td>
        </tr>
    </table>
</form>
</body>
</html>
