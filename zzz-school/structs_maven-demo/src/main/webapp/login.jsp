<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	${ APP_PATH}
	<form action="${ APP_PATH}/login.action" method="post">
		账号：<input type="text" name="username"><br>
		密码：<input type="password" name="password"><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>