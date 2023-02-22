<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	<h3>登录页面</h3>
	<br>
	<form action="login" method="post">
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
				<td><label>生日：</label></td>
				<td><input type="text" id="birthday" name="birthday"></td>
			</tr>
			<tr>
				<td><input type="submit" value="登录" id="submit" /></td>
			</tr>
		</table>
	</form>
	<hr>
	<a href="/test01_springmvc/jsp/testDataBinding.jsp">数据绑定页面</a>
	<hr>
	<form action="login2" method="post">
		<label>数字：</label>
		<input type="text" id="str" name="str">
		<input type="submit" value="登录" id="submit" />
	</form>
	<hr>
	<form action="test_format" method="post">
		<table>
			<tr>
				<td><label>日期：</label></td>
				<td><input type="text" id="birthday" name="birthday"></td>
			</tr>
			<tr>
				<td><label>整数：</label></td>
				<td><input type="text" id="total" name="total"></td>
			</tr>
			<tr>
				<td><label>百分比：</label></td>
				<td><input type="text" id="discount" name="discount"></td>
			</tr>
			<tr>
				<td><label>货币：</label></td>
				<td><input type="text" id="money" name="money"></td>
			</tr>
			<tr>
				<td><input type="submit" value="登录" id="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>