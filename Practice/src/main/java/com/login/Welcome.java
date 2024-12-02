package com.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String userString = (String) session.getAttribute("uname");
		// below set header use is we don't back to once logout it will redirect to login page with out this we can simply back its show welcome sevlet 
		response.setHeader("Cache-Control ", "no-cache , no-store, must-revalidate ");
		if (userString == null) {
			response.sendRedirect("login.html");
		}
		PrintWriter out = response.getWriter();
		out.print("Succssfully Login welcome  " + userString);
		out.println("<br><a href = 'videos.html'>Video</a> ");
		out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		out.print(" <a href = 'Logout'> LogOut</a>");
	}

}
