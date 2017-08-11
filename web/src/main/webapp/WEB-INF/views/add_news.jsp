<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 侯淑婷
  Date: 2017/8/11
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻添加页面</title>
</head>
<body>
<div>
    <h3 align="center">${message}</h3>
    <form action="/news/add" method="post">
    <table cellspacing="0" border="1" align="center">
        <tr align="center">
            <td>新闻标题:</td>
            <td><input type="text" name="title"></td>
        </tr>
        <tr align="center">
            <td>新闻内容：</td>
            <td><textarea name="content" style="width: 400px;height: 300px"></textarea></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="确定添加"></td>
        </tr>
    </table>
    </form>
</div>
</body>
</html>
