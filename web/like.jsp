<%--
  Created by IntelliJ IDEA.
  User: 蒙荣珍
  Date: 2019/7/5
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>点赞测试页面</title>
</head>
<body>

<form action="/Movie/insertLike" method="post">
    <input name="comment" value="2">
    <input name="user" value="2">
    <button type="submit">点赞</button>
</form>

<form action="/Movie/countLike" method="get">
    <input name="comment" value="2">
    <button type="submit">点赞数</button>
</form>

<form action="/Movie/selectLikeByCommentId" method="get">
    <input name="comment" value="2">
    <button type="submit">查看点赞</button>
</form>

<form action="/Movie/deleteLikeByUserId" method="post">
    <input name="user" value="2">
    <button type="submit">通过用户id删除点赞</button>
</form>

<form action="/Movie/deleteLikeByCommentId" method="post">
    <input name="comment" value="2">
    <button type="submit">通过评论id删除点赞</button>
</form>


</body>
</html>
