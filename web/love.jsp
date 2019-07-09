<%--
  Created by IntelliJ IDEA.
  User: 蒙荣珍
  Date: 2019/7/6
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/Movie/insertLove" method="post">
    <input name="name" value="我喜欢的">
    <input name="user" value="1">
    <input name="movies" value="电影id">
    <button type="submit">新建收藏夹</button>
</form>

<form action="/Movie/insertLoveMovie" method="post">
    <input name="loveid" value="3">
    <input name="movie" value="5eb98255-570e-47f7-bf42-de6cc2a2f5c4">
    <button type="submit">添加电影收藏</button>
</form>

<form action="/Movie/deleteLoveById" method="post">
    <input name="loveid" value="1">
    <button type="submit">通过loveid删除收藏夹</button>
</form>

<form action="/Movie/deleteLoveByUserId" method="post">
    <input name="user" value="1">
    <button type="submit">通过用户id删除收藏夹</button>
</form>

<form action="/Movie/deleteLoveMovie" method="post">
    <input name="loveid" value="3">
    <input name="movie" value="01">
    <button type="submit">取消收藏</button>
</form>

<form action="/Movie/selectByName" method="get">
    <input name="name" value="我很喜欢的">
    <input name="user" value="1">
    <button type="submit">通过名字查询收藏夹</button>
</form>

<form action="/Movie/selectByUserId" method="get">
    <input name="user" value="1">
    <button type="submit">通过用户id查询收藏夹</button>
</form>

<form action="/Movie/selectById" method="get">
    <input name="loveid" value="3">
    <button type="submit">通过loveid查询收藏夹</button>
</form>

<form action="/Movie/countMovieByLoveId" method="get">
    <input name="loveid" value="3">
    <button type="submit">收藏夹中电影数</button>
</form>

<form action="/Movie/selectMovieByLoveId" method="get">
    <input name="loveid" value="3">
    <button type="submit">收藏夹id查看收藏电影</button>
</form>

</body>
</html>
