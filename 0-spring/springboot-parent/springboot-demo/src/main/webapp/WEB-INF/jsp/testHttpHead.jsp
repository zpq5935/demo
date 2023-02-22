<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试Http头发送消息</title>
<script>
	$.post({
		url : './getCustomer',
		headers : {
			id : '5935'
		},
		success : function(data) {
			console.log(data);
		}
	});
</script>
</head>
<body>

</body>
</html>