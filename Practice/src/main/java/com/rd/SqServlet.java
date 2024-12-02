package com.rd;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SqServlet
 */
@WebServlet("/SqServlet")
public class SqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter outPrintWriter = response.getWriter();
		
		// send servlet 1 to servlet 2 to a attribute that attribute we can acces through below 
		// we can perform further operations to that attribute 
		int k = (int) request.getAttribute("result");
		

		int sq = k * k;

		outPrintWriter.print("Result of squer is :" + sq);
	}

}
