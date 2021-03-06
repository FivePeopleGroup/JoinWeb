<%--
  Created by IntelliJ IDEA.
  User: 芋头
  Date: 2017/8/10
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录页面</title>
    <meta charset="utf-8" http-equiv="content" content="nav">
    <link rel="stylesheet" type="text/css" href="../css/common/管理平台.css">
    <link rel="stylesheet" type="text/css" href="../css/base/reset.css">
    <script src="../js/jquery.js"></script>
</head>
<body>
<div class="nav">
    <ul class="level-1">
        <li class="firstli">
            <a href="${website}user/login" class="firsta">登录</a>
        </li>
        <li class="firstli">
            <a href="${website}user/register" class="firsta">注册</a>
        </li>
        <li class="firstli">
            <a href="#" class="firsta">关于我们</a>
            <ul class="level-2">
                <li><a href="${website}/department/list/0/0">部门介绍</a></li>
                <li><a href="${website}/member/list/0/0">成员介绍</a></li>
            </ul>
        </li>
    </ul>
</div>
<div class="content">
    <p align="center">${message}</p>
    <form action="${website}/news/searchHome/0" method="post">
    <div>
        <input type="text" name="keyWord" placeholder="搜索新闻" class="search" id="searc">
        <input type="submit" name="submit" value="搜索新闻" class="new" id="sear">
    </div>
    </form>
    <table class="box" border="1">
        <tr>
            <th>新闻条目</th>
            <th>新闻标题</th>
            <th>发布时间</th>
            <th>新闻内容</th>
        </tr>
        <c:forEach items="${newsList}"  var="news" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td><a href="${website}news/select/${news.id}/0">${news.title}</a>
                </td>
                <td>${news.date}</td>
                <td><textarea name="content">${news.content}</textarea></td>
            </tr>
        </c:forEach>
    </table>
</div>
<script src="../js/管理平台.js"></script>

</body>
</html>
