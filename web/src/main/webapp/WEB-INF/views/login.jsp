<%--
  Created by IntelliJ IDEA.
  User: TestUser
  Date: 2017/8/10
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
    <meta charset="utf-8" http-equiv="content" content="nav">
    <link rel="stylesheet" type="text/css" href="../css/common/管理平台.css">
    <link rel="stylesheet" type="text/css" href="../css/base/reset.css">
    <script src="../js/jquery.js"></script>
</head>
<body>
<div class="nav">
    <ul class="level-1">
        <li class="firstli">
            <a href="${website}/news/zhuoyin" class="firsta">主页</a>
        </li>
    </ul>
</div>

<div class="content">
    <div class="user"></div>
    <form  action="${website}user/doLogin" method="post">
    <div class='wrappub'>
        <label for="name">姓名：</label>
        <input type="text" name="username" id="name" class="public">
    </div>
    <div class="wrappub">
        <label for="password">密码：</label>
        <input type="password" name="password" id="password" class="public">
    </div>
    <div class="wrappub">
        <input type="submit" name="submit" value="登录" id="sub" class="log">
        <input type="reset" name="reset" value="重置" id="res" class="log">
        <a  href="${website}user/register" ><input type="button" style="margin-left: 25px;" class="log" value="注册"></a>
    </div>
        <p align="center">${message}</p>
    </form>
</div>
<script src="../js/管理平台.js"></script>


<%--<center>--%>
<%--<form  action="${website}user/doLogin" method="post">--%>
  <%--<table border="1" style="margin-top: 200px">--%>
     <%--<tr align="center">--%>
         <%--<td colspan="2" >--%>
             <%--<h2>--%>
                 <%--登陆界面--%>
             <%--</h2>--%>
         <%--</td>--%>
     <%--</tr>--%>
      <%--<tr>--%>
          <%--<td>--%>
           <%--用户名--%>
          <%--</td>--%>
          <%--<td>--%>
              <%--<input type="text" value="" name="username">--%>
          <%--</td>--%>
      <%--</tr>--%>
      <%--<tr>--%>
          <%--<td>--%>
              <%--密码--%>
          <%--</td>--%>
          <%--<td>--%>
              <%--<input type="password" name="password" value="">--%>
          <%--</td>--%>
      <%--</tr>--%>
      <%--<tr align="center">--%>
          <%--<td colspan="2">--%>
          <%--<input type="submit" value="登录" name="login">--%>
          <%--<a href="${website}news/list"> <input type="button" value="取消登录" name="cancel"></a>--%>
          <%--</td>--%>
      <%--</tr>--%>

  <%--</table>--%>
    <%--${message}--%>
<%--</form>--%>



<%--</center>--%>
</body>
</html>
