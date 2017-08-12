<%--
  Created by IntelliJ IDEA.
  User: 侯淑婷
  Date: 2017/8/11
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新闻修改页面</title>
</head>
<body>
<form action="${website}news/edit/${news.id}/${userId}" method="POST">
<div>
    <table>
        <caption>${message}</caption>
        <tr>
            <td>新闻标题:</td>
            <td><input type="text" value="${news.title}" name="title"></td>
        </tr>
        <tr>
            <td>新闻内容：</td>
            <td><textarea name="content" style="width: 400px;height: 300px;" >${news.content}</textarea></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="确定修改"></td>
        </tr>
        <tr>
            <td colspan="2"><a href="${website}user/qq/${userId}"><input type="button" value="返回"></a></td>
        </tr>
    </table>
</div>
</form>
</body>
</html>
