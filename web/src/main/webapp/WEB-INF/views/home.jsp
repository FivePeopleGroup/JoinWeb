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
            <c:if test="${user.status == '1' || user.status == '2'}">
            <td><a href="${website}/user/用户管理/${user.status}"></a>用户管理</td>
            </c:if>
            <td><a href="${website}/department/部门介绍/${user.status}"></a>部门介绍</td>
            <td><a href="${website}/member/list/${user.status}"></a>成员介绍</td>
        </tr>
    </table>
                <%--新闻模糊查询--%>
                <form action="${website}/news/??" method="post">
                    <input type="text" name="keyword"/>
                    <input type="submit" name="submit" value="搜索新闻"/>
                </form>

    <%--遍历所有新闻  传参“newsList”--%>
    <table border="1">
        <tr bgcolor="#e6e6fa">
            <th>新闻编号</th>
            <th>新闻标题</th>
            <th>发布时间</th>
            <c:if test="${user.status == '1'|| user.status == '2'}">
            <th colspan="2">操作</th>
            </c:if>
        </tr>
        <c:forEach items="${newsList}"  var="news" varStatus="status">
            <tr bgcolor="#e0ffff">
                <td>${status.index+1}</td>
                <td><a href="${website}news/内容显示/${news.id}">${news.title}</a>
                </td>
                <td>${news.date}</td>
                <c:if test="${user.status == '1'|| user.status == '2'}">
                <td><a href="${website}news/删除/${news.id}">删除</a>
                </td>
                <td><a href="${website}news/修改/${news.id}">修改</a>
                </td>
                </c:if>
            </tr>
        </c:forEach>
        <c:if test="${user.status == '1'||user.status == '2'}">
        <tr bgcolor="#e0ffff">
            <td colspan="5" align="right"><a href="${website}news/增加">添加</a></td>
        </tr>
        </c:if>
    </table>
    <th><a href="${website}user/用户注册/">我要注册</a></th>
    <th><a href="${website}user/用户登录/">我要登录</a></th>
    <th><a href="${website}user/修改个人信息/${user.id}">修改个人信息</a></th>
</center>
</body>
</html>
