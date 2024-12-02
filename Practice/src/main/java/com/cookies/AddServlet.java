package com.cookies;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet1")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int i = Integer.parseInt(request.getParameter("num1"));
		int j = Integer.parseInt(request.getParameter("num2"));
		int k = i+j;
		
	// using session 
//		HttpSession session = request.getSession();
//		session.setAttribute("k", k);
//		
//		response.sendRedirect("SqServlet1");
//		// using url rewring 
//		response.sendRedirect("SqServlet1?k="+k);

		
		// using cookies to transfer one servlet to another servlet
		Cookie ck = new Cookie("k", k+"");
		response.addCookie(ck);
		
		response.sendRedirect("SqServlet1");

		
		
	}

}
