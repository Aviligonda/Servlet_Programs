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
 * Servlet implementation class DBConncet
 */
@WebServlet("/DBConncet")
public class DBConncet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("done123");
		PrintWriter outPrintWriter= response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb","root","123");
			outPrintWriter.println("done");
			System.out.println("done455");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from login");
			while (resultSet.next()) {
				outPrintWriter.print(resultSet.getString(1)+" "+resultSet.getString(2));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// TODO Auto-generated method stub
	}

}
