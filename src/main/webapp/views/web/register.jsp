<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>

	<link rel="stylesheet" type="text/css" href="css/login.css">

</head>
<body>

	<form action="/ltweb_150924/register" method="post">

		<c:if test="${alert !=null}">
			<h3 class="alert alert danger">${alert}</h3>
		</c:if>

		<div class="imgcontainer">
			<img src="images/img_avatar2.png" alt="Avatar" class="avatar">
		</div>

		<div class="container">
			<label for="uname"><b>Username</b></label> <input type="text"
				id="uname" placeholder="Enter Username" name="username" required>
			
			<label for="email"><b>Email</b></label> <input type="text"
				id="email" placeholder="Enter Email" name="email" required>
				
			<label for="psw"><b>Password</b></label> <input type="password"
				id="psw" placeholder="Enter Password" name="password" required>
			<input type="password"
				id="retypepsw" placeholder="Retype Password" name="retypePassword" required>

			<button type="submit">Register</button> 
		</div>
	</form>
	
</body>
</html>