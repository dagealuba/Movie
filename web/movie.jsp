<%--
  Created by IntelliJ IDEA.
  User: AS
  Date: 2019/7/4
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movie</title>
</head>
<body>
添加新电影</br>
<form action="/Movie/addmovie" method="post">
    <input name="name" value="name">
    <input name="leadingCreator" value="leading_creator">
    <input name="cover" value="cover">
    <input name="stills" value="stills">
    <input name="releaseDate" value="releaseDate">
    <input name="time" value ="time">
    <input name="grade" value="grade">
    <input name="gradenum" value="gradenum">
    <button  type="submit">提交</button>
</form>
</br>

通过电影name查找电影</br>
<form action="/Movie/findmovie" method="post">
    <input name="name" value="name">
    <button type="submit">查找</button>
</form>
</br>

通过电影name删除电影</br>
<form action="/Movie/deletemovie" method="post">
    <input name="name" value="name">
    <button type="submit">删除</button>
</form>
</br>

通过电影id删除电影</br>
<form action="/Movie/deletemoviebyid" method="post">
    <input name="movieid" value="id">
    <button type="submit">删除</button>
</form>
</br>

通过电影name更新电影信息</br>
<form action="/Movie/updatemovie" method="post">
    <input name="name"  value="name">
    <input name="leadingCreator" value="leading_creator">
    <input name="cover" value="cover">
    <input name="stills" value="stills">
    <input name="releaseDate" value="releaseDate">
    <input name="time" value ="time">
    <input name="grade" value="grade">
    <input name="gradenum" value="gradenum">

    <button type="submit">修改</button>
</form>
</br>

</br>通过id查找电影</br>
<form action="/Movie/findbyid" method="post">
    <input name="movieid" value="id">
    <button type="submit" >查找</button>

</form>
</br>

通过电影id更新电影信息</br>
<form action="/Movie/updatemoviebyid" method="post">
    <input name="movieid" value="id">
    <input name="name"  value="name">
    <input name="leadingCreator" value="leading_creator">
    <input name="cover" value="cover">
    <input name="stills" value="stills">
    <input name="releaseDate" value="releaseDate">
    <input name="time" value ="time">
    <input name="grade" value="grade">
    <input name="gradenum" value="gradenum">

    <button type="submit">修改</button>
</form>
</br>

查询所有电影
<form action="/Movie/showallmovie" method="post">
    <button type="submit">查询所有电影</button>
</form>

评分排名前五的电影
<form action="/Movie/highgrademovie" method="post">
    <button type="submit" >热映电影</button>
</form>

最新上映电影
<form action="/Movie/latelymovie" method="post">
    <button type="submit" >最近上映电影</button>
</form>

评分
<form action="/Movie/scoremovie" method="post">
    <input name="name" value="大海的女儿2">
    <input name="grade" vlaue="grade">
    <button type="submit" >提交评分</button>
</form>
</body>
</html>
