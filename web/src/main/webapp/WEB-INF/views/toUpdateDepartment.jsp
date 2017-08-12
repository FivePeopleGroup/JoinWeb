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
        <form action="${website}/department/updateDepartment/${department.id}/${userstatus}/${userId}" method="post">
            部门名:<input type="text" name="departmentName"  value="${department.departmentName}" style="height:35px;width:300px;margin-top:200px;"><br>
            部门介绍：<input  value="${department.departmentDescription}" type="text" name="departmentDescription" style="height:35px;width:300px;margin-top:20px;"><br>
            <input type="submit" value="提交" style="font-size:20px;margin-top:25px;"><br>
        </form>
        <a href="${website}/department/list/${userstatus}/${userId}" style="font-size:20px" ><button style="font-size:20px;margin-top:20px;">取消修改</button></a>
        ${msg}
    </center>
</div>
</body>
</html>
