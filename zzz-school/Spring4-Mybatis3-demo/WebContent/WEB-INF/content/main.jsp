<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<style type="text/css">
</style>
</head>
<body>
	欢迎【${sessionScope.user.username }】访问
	<br>
	<table border="1">
		<tr>
			<th>封面</th><th>书名</th><th>作者</th><th>价格</th>
		</tr>
		<c:forEach items="${requestScope.book_list }" var="book">
			<tr>
				<td><img src="images/${book.image }" height="60" ></td>
				<%-- <td>images/${book.image }</td> --%>
				<td>${book.name }</td>
				<td>${book.author }</td>
				<td>${book.price }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>