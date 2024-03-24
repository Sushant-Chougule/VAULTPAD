<%@page import="com.db.DBConnection"%>
<%@page import="com.DAO.PostDAO"%>
<%@ page import="java.util.List"%>
<%@ page import="com.User.Post"%>
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
<title>Edit Notes</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>

	<%
		int noteid = Integer.parseInt(request.getParameter("note_id"));
		PostDAO post = new PostDAO(DBConnection.getConn());
		Post p = post.getDataById(noteid);
	%>

	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid">

		<h1 class="text-center">Edit Your Notes</h1>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<form action="NoteEditServlet" method="post">
						<input type="hidden" value="<%=noteid%>" name="noteid">
						<div class="form-group">

							<label for="exampleInputEmail1">Enter Title : </label> <input
								type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="title" required="required" value="<%= p.getTitle() %>">
						</div>

						<div class="form-group">
							<label for="exampleInputEmail1">Enter Content : </label>
							<textarea rows="10" cols="" class="form-control" name="content"
								required="required"><%= p.getContent() %></textarea>
						</div>


						<div class="container text-center mt-3 py-3">
							<button type="submit" class="btn btn-primary">Add</button>
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>
	<%@include file="all_component/footer.jsp"%>
</body>
</html>