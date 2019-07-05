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
    <button type="submit">提交</button>
</form>

<form action="/Movie/deleteUserByName" method="post">
    <input name="username" value="wdnm">
    <button type="submit">删除</button>
</form>

<form action="/Movie/updateById" method="post">
    <input name="userid" value="2">
    <input name="name" value="333">
    <input name="password" value="333">
    <input name="email" value="333">
    <input name="avatar" value="333">
    <input name="address" value="333">
    <button type="submit">修改</button>
</form>

<form action="/Movie/findUserByName" method="get">
    <input name="username" value="22">
    <button type="submit">查找</button>
</form>

</body>
</html>
