package com.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.PostDAO;
import com.User.Post;
import com.db.DBConnection;

@WebServlet("/AddNotesServlet")
public class AddNotesServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		String title =request.getParameter("title");
		String content =request.getParameter("content");
		
		try {
			PostDAO dao= new PostDAO(DBConnection.getConn());
			boolean f = dao.AddNotes(title, content, uid);
			
			
			
			if(f)
			{
				System.out.println("Data inserted successfully");
				response.sendRedirect("showNotes.jsp");
			}
			else {
				System.out.println("Data not inserted");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
	}

}
