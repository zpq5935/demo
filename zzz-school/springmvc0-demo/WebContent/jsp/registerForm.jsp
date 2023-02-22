<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register</title>
</head>
<body>
	<form:form modelAttribute="user" method="post" action="register">
		<table>
			<tr>
				<td>姓名：</td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><form:input path="sex" /></td>
			</tr>
			<tr>
				<td>年龄：</td>
				<td><form:input path="age" /></td>
			</tr>
		</table>
		<hr>
		<form:textarea path="" cols="5" rows="3" />
		<hr>
		选择课程：<form:checkboxes items="${courseList }" path="courses" />
		<hr>
		<form:radiobutton path="sex" value="男" />男&nbsp;
		<form:radiobutton path="sex" value="女" />女&nbsp;
		<hr>
		<h3>方式一</h3>
		部门：<form:select path="deptId">
			<form:option value="1">财务部</form:option>
			<form:option value="2">开发部</form:option>
			<form:option value="3">销售部</form:option>
		</form:select>
		<hr>
		<h3>方式二</h3>
		部门：<form:select path="deptId" items="${deptMap }"></form:select>
	</form:form>
	<form:form modelAttribute="userFSelect" method="post" action="register">
		<hr>
		<h3>方式三</h3>
		部门：<form:select path="deptId">
			<form:options items="${deptMap }" />
		</form:select>
	</form:form>

</body>
</html>