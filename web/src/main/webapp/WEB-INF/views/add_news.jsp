<%--
  Created by IntelliJ IDEA.
  User: 侯淑婷
  Date: 2017/8/11
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新闻添加页面</title>
</head>
<body>
<div>
    <form action="/news/add/${userId}" method="post">
    <table cellspacing="0" border="1" align="center">
        <caption>${message}</caption>
        <tr align="center">
            <td>新闻标题:</td>
            <td><input type="text" name="title" value=""></td>
        </tr>
        <tr align="center">
            <td>新闻内容：</td>
            <td><textarea name="content" style="width: 400px;height: 300px"></textarea></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="确定添加"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><a href="${website}user/qq/${userId}">返回主页</a></td>
        </tr>
    </table>
    </form>
</div>
</body>
</html>
