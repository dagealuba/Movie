<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/7/2
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/Movie/register" method="post">
        <input name="name" value="wdnm">
        <input name="password"value='123'>
        <input name="email" value='2608379678@qq.com'>
        <input name="avatar" value="avatar">
            <input name="address" value="wuhan">
        <button type="submit">提交</button>
</form>
<form action="/Movie/updateInfo" method="post">
        <input name="id">
        <input name="name" value="wdnm">
        <input name="email" value='2608379678@qq.com'>
        <input name="address" value="wuhan">
        <button type="submit">提交</button>
</form>
    <img src="/upload/timg.jpg">
    <img src="/upload/2016210787.jpg">

<form method="post" action="/Movie/uploadFile" enctype="multipart/form-data">
    选择一个文件:
    <input type="file" name="file" />
    <input name ="userId" value="2016210787">
    <br/><br/>
    <input type="submit" value="上传" />
</form>
</body>
</html>
