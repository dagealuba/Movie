<%--
  Created by IntelliJ IDEA.
  User: AS
  Date: 2019/7/8
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Invition</title>
</head>
<body>
inviter邀请invitee进入电影群
<form action="/Movie/invition" method="post">
    <input name="inviter" value="inviter">
    <input name="invitee" value="invitee">
    <input name="spaceid" value="spaceid">
    <button type="submit" >邀请</button>
</form>


invitee是否接受邀请
<form action="/Movie/ifaccept" method="post">
    <input name="inviter" value="邀请人inviter">
    <input name="invitee" value="invitee">
    <input name="spaceid" value="空间spaceid">
    <input name="status" value="同意否1/-1">
    <button type="submit" >邀请回应</button>
</form>


退出群
<form action="/Movie/exitspace"  method="post">
    <input name="userid" value="2016210777">
    <input name="spaceid" value="2">
    <button type="submit" >退出</button>
</form>


搜索群
<form action="/Movie/findspace" method="get">
    <input name="spaceid"  value="2">
    <button type="submit">搜索</button>
</form>

加入群，群主同意否
<form action="/Movie/join" method="post">
    <input name="spaceid" value="2">
    <input name="useid" value="2016210777">
    <button type="submit" >加入群</button>
</form>

群主添加电影
<form action="/Movie/andmovie" method="get">
    <input name="spaceid" value="2">
    <input name="owner" value="2016210666">
    <input name="movies" value="8">
    <button type="submit">添加</button>
</form>
//群主删除电影
<form action="/Movie/deletemovie" method="get">
    <input name="spaceid" value="2">
    <input name="owner" value="2016210666">
    <input name="movies" value="8">
    <button type="submit">删除</button>
</form>


</body>
</html>
