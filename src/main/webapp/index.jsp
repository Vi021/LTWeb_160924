<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%
    // Redirect to login.jsp
    response.sendRedirect("login");
%>

<html>
<head>
<!--  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
	<title>Java Web Demo</title>
	
</head>

<body>
	<%!String message = "Comming soon! LTWeb_150924 Webpage..";%>
	<p>
		<%=message%>
	</p>
	<a href="login" >Click here instead!</a>
</body>
</html>