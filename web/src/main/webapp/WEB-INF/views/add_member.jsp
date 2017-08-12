<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wangh
  Date: 2017/8/11
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加成员</title>
</head>
<body>
<div class="main">
    <center style="margin-top: 130px">
        <form action="${website}member/add/${userstatus}/${userId}" method="post">
            <table>
                <tr bgcolor="#e0ffff">
                    <td>姓名</td>
                    <td><input type="text" name="memberName"/> </td>
                </tr>
                <tr bgcolor="#e0ffff">
                    <td>性别</td>
                    <td>
                        <input type="radio" name="sex" value="女">女
                        <input type="radio" name="sex" value="男">男
                    </td>
                </tr>
                <tr bgcolor="#e0ffff">
                    <td>所属部门</td>

                        <td>
                            <select name="departmentId">
                            <c:forEach items="${list}" var="department" varStatus="status">
                                <option value="${department.id}">${department.departmentName}</option>
                            </c:forEach>
                            </select>
                        </td>

                </tr>
                <tr bgcolor="#e0ffff">
                    <td>简介</td>
                    <td><textarea name="introduce"></textarea></td>
                </tr>
            </table>
            <input type="submit" value="提交">
            <a href="${website}member/list/${userstatus}/${userId}">取消</a>
        </form>

        ${msg}
    </center>
</div>
</body>
</html>
