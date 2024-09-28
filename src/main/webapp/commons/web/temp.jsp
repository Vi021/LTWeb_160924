<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- web.jsp -->
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<!-- BEGIN HEADER -->
<%-- 	<%@ include file="/commons/web/header.jsp"%> --%>
	<!-- END HEADER -->

	<!-- BEGIN SLIDER -->
<%-- 	<%@ include file="/commons/web/slider.jsp" %> --%>
	<!-- END SLIDER -->

	<!-- BEGIN HEADER -->
<%-- 	<%@ include file="/commons/web/header.jsp"%> --%>
	<!-- END HEADER -->

	<div class="main">
		<div class="container">

			<sitemesh:write property="body" />

		</div>
	</div>

	<!-- BEGIN BRANDS -->
<%-- 	<%@ include file="/commons/web/brands.jsp"%> --%>
	<!-- END BRANDS -->

	<!-- BEGIN STEP -->
<%-- 	<%@ include file="/commons/web/step.jsp"%> --%>
	<!-- END STEP -->

	<!-- BEGIN FOOTER -->
<%-- 	<%@ include file="/commons/web/footer.jsp"%> --%>
	<!-- END FOOTER -->

</body>
</html>

<!-- login.jsp -->
<!-- <!DOCTYPE html> -->
<html>
<head>

<meta charset="UTF-8">
<title>Login</title>

<!-- 	<link rel="stylesheet" type="text/css" href="css/login.css"> -->

</head>

<body>

	<form action="/ltweb_150924/login" method="post">

		<c:if test="${alert !=null}">
			<h3 class="alert alert danger">${alert}</h3>
		</c:if>
	
		<div class="imgcontainer">
			<img src="#" alt="Avatar" class="avatar">
		</div>

		<div class="container">
			<label for="uname"><b>Username</b></label> <input type="text"
				id="uname" placeholder="Enter Username" name="username" required>
			<label for="psw"><b>Password</b></label> <input type="password"
				id="psw" placeholder="Enter Password" name="password" required>

			<button type="submit">Login</button>

			<label for="rmbr"
				style="display: flex; justify-content: space-between; align-items: center;">
				<span style="display: flex; align-items: center;"> <input
					type="checkbox" id="rmbr" checked="checked" name="remember">
					<span style="margin-left: 5px;">Remember me</span>
			</span> <a href="/ltweb_150924/forgotpswd">Forgot password?</a>
			</label>

		</div>

		<div class="container" style="background-color: #f1f1f1">
			<!-- <button type="button" class="cancelbtn">Cancel</button> -->
			 <span style="display: flex; justify-content: center;"> 
			 Or <a href="/ltweb_150924/register" style="padding: 0 5px;">SIGN UP</a>a new account! 
			 </span>
			 
		</div>
	</form>

</body>
</html>