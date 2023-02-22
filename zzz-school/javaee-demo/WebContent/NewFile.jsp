<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	pageContext.setAttribute("APP_PATH", session.getServletContext() ); 
%>
</head>
<body>
	<%
		ArrayList<String> list1 = new ArrayList<>();
		list1.add("1123");
		list1.add("ada");
		list1.add("你是");
		list1.add("爱是当你");
		pageContext.setAttribute("list1", list1);
	%>
	<%=pageContext.getAttribute("APP_PATH") %>
	<br>
	${APP_PATH}
	<br>
	${pageContext.request.contextPath}<br>
	pageContext.request.queryString-->${pageContext.request.queryString}<br>
	pageContext.request.requestURL-->${pageContext.request.requestURL}	
	<hr>
	${111 }
	 ${111+12 }
	 <c:forEach items="${list1 }" var="str">
	 	<br>-->${str}
	 </c:forEach>
</body>
</html>