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
    <title>首页</title>
</head>
<body>
<center style="margin-top: 100px">
    <h2>卓音主页</h2>
    <table>
        <tr>
            <%--在用户登录成功之后的方法中，将当前登录的用户传到主页  “user”--%>

            <td><a href="${website}/department/部门介绍/${user.status}">部门介绍</a></td>
            <td><a href="${website}/member/list/${user.status}">成员介绍</a></td>
        </tr>
    </table>
                <%--新闻模糊查询--%>
                <p>${message}</p>
                <form action="${website}/news/search" method="post">
                    <input type="text" name="keyWord"/>
                    <input type="submit" name="submit" value="搜索新闻"/>
                </form>

    <%--遍历所有新闻  传参“newsList”--%>
    <table border="1">
        <tr bgcolor="#e6e6fa">
            <th>新闻编号</th>
            <th>新闻标题</th>
            <th>发布时间</th>
        </tr>
        <c:forEach items="${newsList}"  var="news" varStatus="status">
            <tr >
                <td>${status.index+1}</td>
                <td><a href="${website}news/select/${news.id}">${news.title}</a>
                </td>
                <td>${news.date}</td>
            </tr>
        </c:forEach>
    </table>
    <th><a href="${website}user/用户注册/">我要注册</a></th>
    <th><a href="${website}user/用户登录/">我要登录</a></th>
</center>
</body>
</html>
