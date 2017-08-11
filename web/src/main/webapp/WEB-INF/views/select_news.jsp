<%--
  Created by IntelliJ IDEA.
  User: 侯淑婷
  Date: 2017/8/11
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻浏览页面</title>
</head>
<body>
<form action="/news/list" method="post">
    <div>
        <table cellspacing="0" border="1">
            <caption><h1>${news.title}</h1></caption>
            <tr>
                <td>发布时间：</td>
                <td>${news.date}</td>
            </tr>
            <tr>
                <td>新闻内容：</td>
                <td>${news.content}</td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="返回新闻首页"></td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>
