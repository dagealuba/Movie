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
    <input name="status" value="同意否0/1">
    <button type="submit" >邀请回应</button>
</form>
</body>
</html>
