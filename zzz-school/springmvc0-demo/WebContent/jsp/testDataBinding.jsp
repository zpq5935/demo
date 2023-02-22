<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>数据绑定测试</h2>
<a href="pathVariable/1">测试@PathVariable注解</a><br><br>
<a href="requestHeaderTest">测试@RequestHeader注解</a><br><br>
<a href="cookieValueTest">测试CookieValue注解</a><br><br>
<hr>
<a href="/pathVariable/1">测试@PathVariable注解</a><br><br>
<a href="/requestHeaderTest">测试@RequestHeader注解</a><br><br>
<a href="/cookieValueTest">测试CookieValue注解</a><br><br>
<hr>
<a href="user/register">注册页面</a><br>
<form action="user/register" method="get">
<input type="submit" value="注册" id="submit" />
</form>
</body>
</html>