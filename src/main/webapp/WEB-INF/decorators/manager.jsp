<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- HEADER -->
	<%@ include file="/commons/manager/header.jsp" %>
	
	<!-- CONTENT -->
	<sitemesh:write property="body" />
	
	<!-- FOOTER -->
	<%@ include file="/commons/manager/footer.jsp" %>

</body>
</html>