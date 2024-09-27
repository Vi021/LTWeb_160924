<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/commons/taglib.jsp"%>

<c:url value="/" var="URL"></c:url>

<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<!-- BEGIN HEADER -->
	<%@ include file="/commons/user/header.jsp"%>
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
	<%@ include file="/commons/user/footer.jsp"%>
	<!-- END FOOTER -->

</body>
</html>