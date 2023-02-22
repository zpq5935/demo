<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>			
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试文件上传</title>
</head>
<body>
	<form action="${ctx}/mvc/testFileUpload/request" name="" method="post" enctype="multipart/form-data">
		<input type="file" name="file" value="请选择要提交的文件">
		<input type="submit" value="提交">
	</form>
	<form action="${ctx}/mvc/testFileUpload/multipartFile" name="" method="post" enctype="multipart/form-data">
		<input type="file" name="file" value="请选择要提交的文件">
		<input type="submit" value="提交">
	</form>
	<form action="${ctx}/mvc/testFileUpload/part" name="" method="post" enctype="multipart/form-data">
		<input type="file" name="file" value="请选择要提交的文件">
		<input type="submit" value="提交">
	</form>
</body>
</html>