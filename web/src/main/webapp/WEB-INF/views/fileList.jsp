<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈芳
  Date: 2017/8/13
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片</title>
</head>
<body>


<c:forEach items="${fileList}" begin="${fn:length(fileList)-5}" var="fileList" varStatus="status">

    <img src="${fileList.name}" />

</c:forEach>
</body>
</html>
