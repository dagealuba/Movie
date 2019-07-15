<%--
  Created by IntelliJ IDEA.
  User: 蒙荣珍
  Date: 2019/7/12
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Welcome<br/>
<div  id="message" style="color: blue">[状态]</div>
<br/>昵称：
<input id="username" value="01">
<br/>内容：
<input id="text" value="hahaha"/>
<br/>
<button onclick="send()">发送</button>
<button onclick="closeWebSocket()">关闭</button>

</body>

<script type="text/javascript">
    var websocket=null;
    if('WebSocket' in window){
        websocket=new WebSocket("ws://localhost:8080/Movie/websocket");
    }
    else{
        alter('当前浏览器 Not support websocket')
    }
    websocket.onerror=function () {
        setMessageInnerHTML("WebSocket连接发生错误");
    };
    websocket.onopen=function(){
        setMessageInnerHTML("WebSocket连接成功");
    };
    websocket.onmessage=function (event) {
        setMessageInnerHTML(event.data);
    };
    websocket.onclose=function () {
        setMessageInnerHTML("WebSocket连接关闭");
    };
    window.onbeforeunload=function (ev) {
        closeWebSockt();
    };
    function setMessageInnerHTML(innerHTML) {
        document.getElementById('message').innerHTML += innerHTML + '<br/>';
    }
    function closeWebSocket() {
        websocket.close();
    }
    function send() {
        var username=document.getElementById('username').value;
        var message = document.getElementById('text').value;
        var msg="["+username+"]:"+message;
        websocket.send(msg);
    }
</script>
</html>
