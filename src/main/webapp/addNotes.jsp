<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
UserDetails user1 = (UserDetails) session.getAttribute("userD");

if (user1 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("Login-error", "Please Login...");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Notes</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid">

		<h1 class="text-center">Add Your Notes</h1>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<form action="AddNotesServlet" method="post">
						<div class="form-group">
							<%
							UserDetails us = (UserDetails) session.getAttribute("userD");
							if (us != null) {
							%>
							<input type="hidden" value=<%=us.getId()%> name="uid">
							<%
							}
							%>

							<label for="exampleInputEmail1">Enter Title : </label> <input
								type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="title" required="required">
						</div>

						<div class="form-group">
							<label for="exampleInputEmail1">Enter Content : </label>
							<textarea rows="10" cols="" class="form-control" name="content"
								required="required"></textarea>
						</div>


						<div class="container text-center mt-3 py-3">
							<button type="submit" class="btn btn-primary">Add</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	
	</div>
	
	<footer class="page-footer font-small blue mt-5" >
		
		<div class="footer-copyright text-center py-3"><hr>
			© 2024 Copyright: <a
				href="https://sushantchouguleportfolio.netlify.app/">
				SushantChougule.com</a>
		</div>

	</footer>
</body>
</html>