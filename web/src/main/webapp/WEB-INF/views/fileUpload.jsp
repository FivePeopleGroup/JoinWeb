<%--
  Created by IntelliJ IDEA.
  User: wangh
  Date: 2017/8/13
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>
<html>
<head>
    <title></title>
    <base href="<%=basePath%>">
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
</head>
<body>
<center>
    <form action="${website}image/image" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="submit" value="上传">
    </form>
    ${msg}
</center>
</body>
</html>
