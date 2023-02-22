<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<% String serverName = request.getContextPath(); %>
<head>
    <title>Java后端WebSocket的Tomcat实现</title>
</head>
<body>
    Welcome<br/><input id="text" type="text"/>
    <button onclick="send()">发送消息</button>
    <hr/>
    <button id="btn1" onclick="closeOrNewWebSocket()">关闭WebSocket连接</button>
    <hr/>
    <div id="message"></div>
</body>

<script type="text/javascript">
    var websocket = null;
    var isConnect = false;
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://localhost:8080"+"<%=serverName%>"+"/websocket");
        isConnect = true;
        binding(websocket);
    }
    else {
        alert('当前浏览器 Not support websocket')
    }

    /* //连接发生错误的回调方法
    websocket.onerror = function () {
        setMessageInnerHTML("WebSocket连接发生错误");
    };

    //连接成功建立的回调方法
    websocket.onopen = function () {
        setMessageInnerHTML("WebSocket连接成功");
    }

    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        setMessageInnerHTML(event.data);
    }

    //连接关闭的回调方法
    websocket.onclose = function () {
        setMessageInnerHTML("WebSocket连接关闭");
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        closeWebSocket();
    } */

    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
        document.getElementById('message').innerHTML += innerHTML + '<br/>';
    }
    
  //按钮点击事件
    function closeOrNewWebSocket(){
    	if(isConnect){
    		closeWebSocket()
    	}
    	else{
    		newWebSocket()
    	}
    }
    
  	//新建WebSocket连接
    function newWebSocket() {
    	websocket = new WebSocket("ws://localhost:8080"+"<%=serverName%>"+"/websocket");
        isConnect = true;
        document.getElementById('btn1').innerHTML = "关闭WebSocket连接";
        binding(websocket);
    }
  	
    //关闭WebSocket连接
    function closeWebSocket() {
        websocket.close();
        isConnect = false;
        document.getElementById('btn1').innerHTML = "新建WebSocket连接";
    }

    //发送消息
    function send() {
        var message = document.getElementById('text').value;
        websocket.send(message);
    }
    /*****************************************/
    //绑定WebSocket对象的各回调函数
     function binding(ws){
    	ws.onerror = onerror;
    	ws.onopen = onopen;
    	ws.onmessage = onmessage; 
    	ws.onbeforeunload = onbeforeunload;
    	ws.onclose = onclose;
    }
    
  //连接发生错误的回调方法
    function onerror() {
        setMessageInnerHTML("WebSocket连接发生错误");
    };

    //连接成功建立的回调方法
    function onopen() {
        setMessageInnerHTML("WebSocket连接成功");
    }

    //接收到消息的回调方法
    function onmessage(event) {
        setMessageInnerHTML(event.data);
    }

    //连接关闭的回调方法
    function onclose() {
        setMessageInnerHTML("WebSocket连接关闭");
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    function onbeforeunload() {
        closeWebSocket();
    } 
</script>
</html>