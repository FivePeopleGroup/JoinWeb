<%--
  Created by IntelliJ IDEA.
  User: Claus
  Date: 2017/8/11
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加部门页面</title>
</head>
<body>
<div class="department">
    <center>
        <form action="${website}/department/addDepartment/${userstatus}" method="post">
            部门名:<input type="text" name="departmentName" style="height:35px;width:300px;margin-top:200px;"><br>
            部门介绍：<input type="text" name="departmentDescription" style="height:35px;width:300px;margin-top:20px;"><br>
            <input type="submit" value="提交" style="width:73px;height:22px;margin-top:25px;"><br>
        </form>
        <a href="${website}/department/list/${userstatus}" style="font-size:20px;"><button style="margin-top:20px;">取消增加</button></a>
        ${msg}
    </center>
</div>
</body>
</html>
