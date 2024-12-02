package com.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("uname");
		String password = request.getParameter("pass");

		if (username.equals("abc") && password.equals("123456")) {
			HttpSession session = request.getSession();
			session.setAttribute("uname", username);
			response.sendRedirect("Welcome");
		}else {
			
		response.sendRedirect("login.html");
		}
	}

}
