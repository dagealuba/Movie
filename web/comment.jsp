<%--
  Created by IntelliJ IDEA.
  User: 蒙荣珍
  Date: 2019/7/4
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/Movie/insertComment" method="post">
    <input name="content" value="我喜欢的">
    <input name="movie" value="01">
    <input name="tocomment" value="">
    <input name="user" value="2">
    <button type="submit">评论</button>
</form>

<form action="/Movie/countComment" method="get">
    <input name="movie" value="01">
    <button type="submit">电影评论数</button>
</form>

<form action="/Movie/countCommentByToComment" method="get">
    <input name="tocomment" value="1">
    <button type="submit">评论的回复数</button>
</form>

<form action="/Movie/deleteCommentById" method="post">
    <input name="commentId" value="1">
    <button type="submit">通过评论id删除评论</button>
</form>

<form action="/Movie/deleteCommentByMovieId" method="post">
    <input name="movie" value="02">
    <button type="submit">通过电影id删除评论</button>
</form>

<form action="/Movie/selectCommentByMovieId" method="get">
    <input name="movie" value="01">
    <button type="submit">通过电影id查看评论</button>
</form>

<form action="/Movie/selectCommentByToCommentId" method="get">
    <input name="tocomment" value="2">
    <button type="submit">查看评论的回复</button>
</form>

<form action="/Movie/selectCommentById" method="get">
    <input name="commentid" value="2">
    <button type="submit">通过评论id查看评论</button>
</form>




</body>
</html>
