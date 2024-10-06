<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form action="${pageContext.request.contextPath}/admin/category/insert"
	method="post">
	<div>
		<label for="catename">Category Name</label><br>
		<input type="text" id="catename" name="catename">
		<br><br>
		<label for="cateimg">Image</label><br>
		<input type="file" id="cateimg" name="img">
		<br><br>
		<label for="status">Status</label><br>
		<input type="text" id="status" name="status">
		<br><br>
		<input type="submit" value="Submit">
	</div>
</form>
