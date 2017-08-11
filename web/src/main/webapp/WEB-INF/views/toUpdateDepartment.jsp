<%--
  Created by IntelliJ IDEA.
  User: Claus
  Date: 2017/8/11
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改部门页面</title>
</head>
<body>
<div class="department">
    <center>
        <form action="${website}/department/updateDepartment" method="post">
            部门名:<input type="text" name="departmentName" style="height:35px;width:300px;margin-top:200px;"><br>
            部门介绍：<input type="text" name="departmentDescription" style="height:35px;width:300px;margin-top:200px;">
            <input type="submit" value="提交" style="width:73px;height:22px;margin-top:25px;">
            <a href="${website}department/list/" style="font-size:20px" ><button>取消增加</button></a>
        </form>
    </center>
</div>
</body>
</html>
