package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.User.UserDetails;
import com.db.DBConnection;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String name = request.getParameter("fname");
		String email = request.getParameter("uemail");
		String password = request.getParameter("upassword");
		
		UserDetails us = new UserDetails();
		us.setName(name);
		us.setEmail(email);
		us.setPassword(password);
		
		try {
			UserDAO dao = new UserDAO(DBConnection.getConn());
			boolean  f = dao.addUser(us);
			PrintWriter out = response.getWriter();
			HttpSession session;
			
			if(f) {
				session = request.getSession();
				session.setAttribute("reg-success", "Rgisteration Successfully...");
				response.sendRedirect("register.jsp");
			}
			else {
				session = request.getSession();
				session.setAttribute("failed-msg", "Something went wrong on server");
				response.sendRedirect("register.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
