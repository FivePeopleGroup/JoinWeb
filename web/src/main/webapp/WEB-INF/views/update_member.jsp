<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wangh
  Date: 2017/8/11
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改成员</title>
</head>
<body>
<center style="margin-top: 130px">
    <form action="${website}member/update/${userstatus}" method="post">
        <table>
            <input type="hidden" name="id" value="${member.id}"/>
            <tr bgcolor="#e0ffff">
                <td>姓名</td>
                <td><input type="text" name="memberName" value="${member.memberName}"/> </td>
            </tr>
            <tr bgcolor="#e0ffff">
                <td>性别</td>
                <td>
                    <c:if test="${member.sex eq '女'}"><input type="radio" name="sex" value="女" checked>女 <input type="radio" name="sex" value="男">男</c:if>
                    <c:if test="${member.sex eq '男'}"><input type="radio" name="sex" value="女">女 <input type="radio" name="sex" value="男" checked>男</c:if>
                </td>
            </tr>
            <tr bgcolor="#e0ffff">
                <td>所属部门</td>
                <td>
                    <select name="departmentId">
                    <c:forEach items="${list}" var="department" varStatus="status">
                        <c:if test="${department.id != member.departmentId}">
                            <option value="${department.id}">${department.departmentName}</option>
                        </c:if>
                        <c:if test="${department.id == member.departmentId}">
                            <option value="${department.id}" selected="selected">${department.departmentName}</option>
                        </c:if>
                    </c:forEach>
                    </select>
                </td>
            </tr>
            <tr bgcolor="#e0ffff">
                <td>简介</td>
                <td><textarea name="introduce">${member.introduce}</textarea></td>
            </tr>
        </table>
        <input type="submit" value="确定修改">
    </form>
</center>

</body>
</html>
