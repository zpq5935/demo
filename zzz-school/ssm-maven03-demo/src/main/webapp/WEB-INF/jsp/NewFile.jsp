<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script src="${APP_PATH}/static/js/jquery-1.12.4.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试Get与Post请求</title>
</head>
<body>
	<h1>测试get与post</h1>
	<input type="text" name="text1" id="text1"><button id="get_method">get发送</button>
	<font color="red" class="response_text1"></font>
	<br>
	<input type="text" name="text2" id="text2"><button id="post_method">post发送</button>
	<font color="red" class="response_text2"></font>
	<br>
	<input type="text" name="text3" id="text3"><button id="post_method_btn2">自行post发送</button>
	<font color="red" class="response_text3"></font>
	<br>
	<script>
	/* 按钮get_method添加单击事件，发送ajax请求 */
	$('#get_method').click(function() {
		var text1 = $('#text1').val();
		var resTxt1 = $('.response_text1')
		alert(text1)
		$.ajax({
			url : "http://112.21.191.39:8090/WeegWebApp/weeg/callbackIn"+"?msg="+text1,
			method : "GET",
			//data : "data="+text1,
			success : function(result) {
				console.log(result)
				resTxt1.text(result)
			}
		})
	})
	/* 按钮post_method添加单击事件，发送ajax请求 */
	$('#post_method').click(function() {
		var text2 = $('#text2').val();
		var resTxt2 = $('.response_text2');
		alert(text2)
		$.ajax({
			url : "http://112.21.191.39:8090/WeegWebApp/weeg/callbackIn",
			method : "POST",
			data : JSON.stringify({'name':'zpq','passwd':'123456'}),
			dataType:"json",
			contentType: "application/json;charset=utf-8",
			success : function(result) {
				console.log(result)
				resTxt2.text(result)
			}, 
			error: function(e){
				console.log(JSON.stringify(e));
	        }
		})
	})
	/* 按钮post_method_btn2添加单击事件，发送ajax请求 */
	$('#post_method_btn2').click(function() {
		var text3 = $('#text3').val();
		var resTxt3 = $('.response_text3');
		alert(text3)
		$.ajax({
			url : "${APP_PATH}/my_test_post/",
			method : "POST",
			//data: "data="+text3,
			//字符串格式
			data : JSON.stringify( {'name':'章朝佩','passwd':'123456'} ),
			//对象格式
			//data : {name:'zpq',method:'post'},
			//响应的数据类型
			dataType:"json",
			//请求的数据类型
			contentType: "application/json;charset=utf-8",
			success : function(result) {
				console.log(result)
				resTxt3.text(result)
			}, 
			error: function(e){
				console.log(JSON.stringify(e));
	           }
		})
	})
</script>
</body>
</html>