<%--
  Created by IntelliJ IDEA.
  User: 侯淑婷
  Date: 2017/8/11
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新闻浏览页面</title>
</head>
<body>
<form action="/news/list" method="get">
    <div align="center">
        <table cellspacing="0" border="1" align="center">
            <caption><h1>${news.title}</h1></caption>
            <tr>
                <td>发布时间：</td>
                <td>${news.date}</td>
            </tr>
            <tr>
                <td>新闻内容：</td>
                <td>${news.content}</td>
            </tr>
            <c:if test="${userId=='0'}">
            <tr>
                <td colspan="2" align="center"><a href="/news/list">返回新闻首页</a></td>
            </tr>
            </c:if>
            <c:if test="${userId!='0'}">
            <tr>
                <td colspan="2" align="center"><a href="/user/qq/${userId}">返回新闻首页</a></td>
            </tr>
            </c:if>
        </table>
    </div>
</form>
</body>
</html>
