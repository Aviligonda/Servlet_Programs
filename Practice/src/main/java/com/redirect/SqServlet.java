package com.redirect;

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
 * Servlet implementation class SqServlet
 */
@WebServlet("/SqServlet3")
public class SqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter outPrintWriter = response.getWriter();
		// using cookies
		int k = 0;
		Cookie cookie[] = request.getCookies();
		for (Cookie ck : cookie) {
			if (ck.getName().equals("k")) {
				k = Integer.parseInt(ck.getValue());
			}
		}
		k = k * k;
		outPrintWriter.print("Result of squr is :" + k);
	}

}
