package com.sonix;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FormValidationServlet")
public class FormValidationServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String ageStr = request.getParameter("age");
		String contact = request.getParameter("contact");

		boolean isValid = true;
		PrintWriter out = response.getWriter();

		// Validate Name
		if (name == null || !name.matches("[a-zA-Z\\s]+")) {
			isValid = false;
			out.print("Invalid Name. Only alphabets allowed.<br>");
		}

		// Validate Email ID
		if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			isValid = false;
			out.print("Invalid Email ID.<br>");
		}

		// Validate Age
		int age = -1;
		try {
			age = Integer.parseInt(ageStr);
			if (age < 1 || age > 120) {
				isValid = false;
				out.print("Age must be between 1 and 120.<br>");
			}
		} catch (NumberFormatException e) {
			isValid = false;
			out.print("Age must be a number.<br>");
		}

		// Validate Contact Number
		if (contact == null || !contact.matches("\\d{10}")) {
			isValid = false;
			out.print("Contact Number must be exactly 10 digits.<br>");
		}

		response.setContentType("text/html");

		if (isValid) {
			// If valid, insert data into database;
			try {
				// Load JDBC driver (for MySQL)
				Class.forName("com.mysql.jdbc.Driver");

				// Establish a connection
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "123");
				// SQL query to insert data
				String sql = "INSERT INTO Students (name, email, age, contact) VALUES (?, ?, ?, ?)";
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, name);
				statement.setString(2, email);
				statement.setInt(3, age);
				statement.setString(4, contact);

				statement.execute();
				out.println("<h2>Form Submitted Successfully and Data Saved!</h2>");

				// Close resources
				statement.close();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// If invalid, show error messages
			out.println("<h2>Form Submission Failed!</h2>");

		}
	}
}