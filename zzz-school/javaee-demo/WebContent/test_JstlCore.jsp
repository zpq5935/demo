<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL-Core</title>
</head>
<body>
	<%
		request.setAttribute("book", "<<Java>>");
	%>
	
	book:${requestScope.book }
	<br>
	book:<c:out value="${requestScope.book }"></c:out>
	<br>
	book:<c:out value="${requestScope.booktitle }" default="booktile"></c:out>
	
	<hr>
	<c:set var="person01" value="request001" scope="request"></c:set>
	<c:set var="person01" value="session001" scope="session"></c:set>
	person01:${requestScope.person01 }
	
	<hr>
	<c:remove var="person01" />
	person01:${sessionScope.person01 }
	<hr>
	
	<c:set var="score" value="59" scope="request"></c:set>
	<c:if test="${requestScope.score > 60 }">合格了</c:if>
	<c:if test="${param.age>18 }" var="isAdult" scope="request"></c:if>
	isAdult:<c:out value="${requestScope.isAdult }" ></c:out>
	
	<hr>
	年龄：${param.age },
	<c:choose>
		<c:when test="${param.age>60 }">老年</c:when>
		<c:when test="${param.age>30 }">中年</c:when>
		<c:when test="${param.age>18 }">成年</c:when>
		<c:otherwise>未成年</c:otherwise>
	</c:choose>
	
	<h4>c:forTokens标签</h4>
	<c:forTokens items="1.23a.dca.sd" delims="." var="str">
		${str }<br>
	</c:forTokens>
	
	<hr>
	<h4>c:import标签</h4>
	<%-- <c:import url="http://www.baidu.com"></c:import> --%>
	
	<h4>c:redirect</h4>
	<%-- <c:redirect url="http://www.baidu.com"></c:redirect> --%>
	
	<h4>c:url</h4>
	<c:url value="/test_JstlCore.jsp" var="testUrl" scope="page">
		<c:param name="age" value="55"></c:param>
	</c:url>
	url:${ pageScope.testUrl} <br>
	<a href="${pageScope.testUrl }">测试</a>
</body>

</html>