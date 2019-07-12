<%--
  Created by IntelliJ IDEA.
  User: AS
  Date: 2019/7/11
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>space</title>
</head>
<body>
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

加入群，不需要群主同意
<form action="/Movie/joinspace" method="post">
    <input name="spaceid" value="2">
    <input name="userid" value="2016210777">
    <button type="submit" >加入群</button>
</form>

群主添加电影
<form action="/Movie/addmovies" method="post">
    <input name="spaceid" value="2">
    <input name="owner" value="2016210666">
    <input name="movies" value="8">
    <button type="submit">添加</button>
</form>
//群主删除电影
<form action="/Movie/deletemovies" method="get">
    <input name="spaceid" value="2">
    <input name="owner" value="2016210666">
    <input name="movies" value="8">
    <button type="submit">删除</button>
</form>
</body>
</html>