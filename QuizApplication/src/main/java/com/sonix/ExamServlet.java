package com.sonix;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class ExamServlet
 */
@WebServlet("/ExamServlet")
public class ExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String[] answers = { "N", "A", "A", "O" };

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String ans = request.getParameter("answer");
		String id = request.getParameter("id");
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb","root","Sravani@6086");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from quiz where id=? and answer=?");
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, ans);
			ResultSet resultSet= preparedStatement.executeQuery();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
