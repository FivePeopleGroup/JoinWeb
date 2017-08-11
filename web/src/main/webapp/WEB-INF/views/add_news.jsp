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
    <form action="/news/add" method="post">
    <table>
        <tr>
            <td>新闻标题:</td>
            <td><input type="text" name="title"></td>
        </tr>
        <tr>
            <td>新闻内容：</td>
            <td><textarea name="content" style="width: 400px;height: 300px"></textarea></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="确定添加"></td>
        </tr>
    </table>
    </form>
</div>
</body>
</html>
