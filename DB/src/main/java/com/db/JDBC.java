package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {

	public boolean check(String userName, String passWord) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb", "root",
					"123");
			PreparedStatement pStatement = connection
					.prepareStatement("selcet * from logindb where uname=? and pass =?");
//			Statement statement = connection.createStatement();
//			ResultSet resultSet = statement.executeQuery("selcet * from logindb where uname="+ userName+" and pass ="+passWord);
			pStatement.setString(1, userName);
			pStatement.setString(2, passWord);
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("done");
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

	public static void main(String[] args) {
		JDBC dJdbc = new JDBC();
		System.out.println(dJdbc.check("anji", "123"));
	}
}
