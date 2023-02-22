<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  --%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSR成功</title>
</head>
<body>
${requestScope.user.loginname }<br>
${requestScope.user.password }<br>
${requestScope.user.username }<br>
${requestScope.user.age }<br>
${requestScope.user.email}<br>

${requestScope.user.phone}<br>
</body>
</html>