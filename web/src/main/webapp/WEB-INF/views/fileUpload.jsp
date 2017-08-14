<%--
  Created by IntelliJ IDEA.
  User:陈芳
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
    <form action="${website}file/file" method="post" enctype="multipart/form-data">
        <input type='text'  name='textfield' id='textfield' class='txt' />
        <input type="file" name="file" class="file" id="fileField" size="28" onchange="document.getElementById('textfield').value=this.value" />
        <input type="submit"  name="submit" class="btn" value="上传" />
        <a href="${website}file/list" >查看图片</a>
        <a href="${website}/news/zhuoyin">返回首页</a>
    </form>
    ${msg}
</center>
</body>
</html>
