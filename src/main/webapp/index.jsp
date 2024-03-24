<%@page import="java.sql.Connection"%>
<%@page import="com.db.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.back-img {
background: url("img/1.jpg");
width: 100%;
height: 615px;
background-repeat: no-repeat;
background-size: cover;
}
</style>
<meta charset="UTF-8">
<title>Home Page</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>

	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid back-img">
	<div class="text-center ">
	<h1 ><i class="fa fa-fort-awesome mt-5" aria-hidden="true"></i> VAULTPAD : Save Your Notes</h1>
	<a href="login.jsp" class="btn btn-outline-primary mt-4 mr-4"><i class="fa fa-sign-in" aria-hidden="true"></i> Login</a>
	<a href="register.jsp" class="btn btn-outline-primary mt-4"><i class="fa fa-user-plus" aria-hidden="true"></i> Register</a>
	
	</div>
	<div class="text-center ">
	<img alt="" src="img/nooot.jpg" class="img-fluid mx-auto mt-5" style="max-width: 450px;">
	</div>
	
	</div>
	
	<%@include file="all_component/footer.jsp"%>
</body>
</html>