<%--
  Created by IntelliJ IDEA.
  User: 蒙荣珍
  Date: 2019/7/3
  Time: 16:15
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
    <button type="submit">注册</button>
</form>

<form action="/Movie/deleteUserByName" method="post">
    <input name="name" value="dd">
    <button type="submit">通过名字删除</button>
</form>


</body>
</html>
