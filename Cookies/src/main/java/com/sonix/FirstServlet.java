package com.sonix;

import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String n = request.getParameter("userName");
			String o = request.getParameter("age");
			
			out.print("Welcome " + n+"\n and Age is " + o);

			Cookie ck = new Cookie("uname", n);
			Cookie ck1 = new Cookie("age", o);// creating cookie object
			response.addCookie(ck);
			response.addCookie(ck1);// adding cookie in the response
			out.print("<form action='SecondServlet'>");  
			out.print("<input type='submit' value='go'>");
			out.print("</form>");
			out.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
