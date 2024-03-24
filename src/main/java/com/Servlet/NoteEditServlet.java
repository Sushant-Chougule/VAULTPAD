package com.Servlet;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.PostDAO;
import com.db.DBConnection;

@WebServlet("/NoteEditServlet")
public class NoteEditServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Integer noteid = Integer.parseInt(request.getParameter("noteid"));
			String Title = request.getParameter("title");
			String Content = request.getParameter("content");
			
			PostDAO dao=new PostDAO(DBConnection.getConn());
			boolean f=dao.PostUpdate(noteid, Title, Content);
			System.out.println(f);
			if(f)
			{
				System.out.println("data updated successfully");
				HttpSession session=request.getSession();
				session.setAttribute("updateMsg", "Notes Update Successfully");
				response.sendRedirect("showNotes.jsp");
			}
			else {
				{
					System.out.println("data not updated");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
