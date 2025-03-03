package com.sonix;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");

		String password = request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter outPrintWriter=response.getWriter(); 
DatabaseConnection db =new DatabaseConnection();

		if (db.checklogin(username, password)) {

			HttpSession session = request.getSession();

			session.setAttribute("username", username); // Store username in session
			outPrintWriter.print("login successfully");
			response.sendRedirect("question1.html");
		
		} else {

			response.sendRedirect("login.html"); // Redirect back to login if authentication fails

 

		}
	}

}
