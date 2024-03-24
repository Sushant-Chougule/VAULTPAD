package com.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.PostDAO;
import com.db.DBConnection;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Integer noteid=Integer.parseInt(request.getParameter("note_id"));
			PostDAO dao;
			dao = new PostDAO(DBConnection.getConn());
			boolean f=dao.DeleteNote(noteid);
			HttpSession session =null;
			if(f)
			{
				System.out.println("Notes Delete Successfully...");
				session = request.getSession();
				session.setAttribute("deleteMsg", "Notes Delete Successfully...");
				response.sendRedirect("showNotes.jsp");
			}
			else
			{
				session = request.getSession();
				session.setAttribute("wrongMsg", "Something went wrong on server...");
				response.sendRedirect("showNotes.jsp");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}
