package com.Servlet;

import java.io.IOException;
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

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("uemail");
		String password = request.getParameter("upassword");
		
		UserDetails us = new UserDetails();
		us.setEmail(email);
		us.setPassword(password);
		
		try {
			UserDAO dao = new UserDAO(DBConnection.getConn());
			UserDetails user = dao.loginUser(us);
			
			if(user != null)
			{
				HttpSession session = request.getSession();
				session.setAttribute("userD", user);
				response.sendRedirect("home.jsp"); 
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("login-failed", "Invalid UserName and Password");
				response.sendRedirect("login.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
