package com.db;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class DatabaseCon
 */
@WebServlet("/DatabaseCon")
public class DatabaseCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb", "root", "123");

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from login");
			out.print("<table border='3' align='center' cellspacing='1' cellpadding='15'>");
			out.print("<tr><th>User Name</th><th>Password</th></tr>");
			while (resultSet.next()) {

				out.print("<tr>" + " <td>" + resultSet.getString(1) + "</td>" + "<td>" + resultSet.getString(2)	+ "</td>" + "</tr>");

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
