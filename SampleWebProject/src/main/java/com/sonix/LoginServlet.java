package com.sonix;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("In LoginServlet");

		if ("user".equals(username) && "password".equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username); // Store username in session
			response.sendRedirect("dashboard"); // Redirect to dashboard
		} else {
			response.sendRedirect("Index.html"); // Redirect back to login if auth fails

		}
	}
}