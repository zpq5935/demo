<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>登录界面</h2>
	<form action="hello.jsp" method="post">
		username:<input type="text" name="username" value="${ requestScope.username}"><font color="red">${requestScope.errorMsg }</font><br>
		password<input type="password" name="password">
		<input type="submit" value="提交">
	</form>
</body>
</html>