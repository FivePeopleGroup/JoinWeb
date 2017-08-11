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
    <title>登录</title>
</head>
<body>
<center>
<form  action="${website}user/doLogin" method="post">
  <table border="1" style="margin-top: 200px">
     <tr align="center">
         <td colspan="2" >
             <h2>
                 登陆界面
             </h2>
         </td>
     </tr>
      <tr>
          <td>
           用户名
          </td>
          <td>
              <input type="text" value="" name="username">
          </td>
      </tr>
      <tr>
          <td>
              密码
          </td>
          <td>
              <input type="password" name="password" value="">
          </td>
      </tr>
      <tr align="center">
          <td colspan="2">
          <input type="submit" value="登录" name="login">
          <a href="${website}news/list"> <input type="button" value="取消登录" name="cancel"></a>
          </td>
      </tr>

  </table>
    ${message}
</form>



</center>
</body>
</html>
