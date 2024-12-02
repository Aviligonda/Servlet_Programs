package com.sonix;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class FormValidationServlet
 */
@WebServlet("/FormValidationServlet")
public class FormValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		String contactNumebr = request.getParameter("contactnumebr");
		
//		if (name.matches("[A-Z][a-z]{2,}")&&email.matches("[a-z\\d]{3,}@[a-z]{5}.[a-z]{2,}")
//				&& age.matches("[0-9]{2}") && contactNumebr.matches("[6789][0-9]{9}")) {
//			out.println("Form Submitted Successfully! ");
//		} else {
//			out.println("Form Submitted Failed");
//		}

		boolean isValid = true;
		

		// Validate Name
		if (name == null || !name.matches("[A-Z][a-zA-Z\\s]+")) {
			isValid = false;
			out.print("Invalid Name. Only alphabets allowed.<br>");
		}

		// Validate Email ID
		if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			isValid = false;
			out.print("Invalid Email ID.<br>");
		}

		// Validate Age
		int ages = -1;
		try {
			ages = Integer.parseInt(age);
			if (ages < 1 || ages > 50) {
				isValid = false;
				out.print("Age must be between 1 and 50.<br>");
			}
		} catch (NumberFormatException e) {
			isValid = false;
			out.print("Age must be a number.<br>");
		}

		// Validate Contact Number
		if (contactNumebr == null || !contactNumebr.matches("\\d{10}")) {
			isValid = false;
			out.print("Contact Number must be exactly 10 digits.<br>");
		}
		
		if(isValid) {
			out.print("Form Submitted Successfully ");
		}else {
			out.print("Form Submitted failed ");
		}
	}

}
