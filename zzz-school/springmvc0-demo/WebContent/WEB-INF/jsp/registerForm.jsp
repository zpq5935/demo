<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
	<h3>注册页面</h3>
	<br>
	<form action="register" method="post">
		<table>
			<tr>
				<td><label>登录名：</label></td>
				<td><input type="text" id="loginName" name="loginName"></td>
			</tr>
			<tr>
				<td><label>密码：</label></td>
				<td><input type="password" id="password" name="password"></td>
			</tr>
			<tr>
				<td><label>真实姓名：</label></td>
				<td><input type="text" id="userName" name="userName"></td>
			</tr>
			<tr>
				<td><input type="submit" value="注册" id="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>