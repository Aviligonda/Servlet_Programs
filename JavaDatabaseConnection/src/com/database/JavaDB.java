package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaDB {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/book_service";
//	private static final String JDBC_USERNAME = "root";
//	private static final String JDBC_PASSWORD = "Sravani@6086";

	public static void main(String[] args) throws SQLException {
		try {
			Connection conn = DriverManager.getConnection(JDBC_URL, System.getenv("username"),
					System.getenv("password"));
			System.out.println("done connection");
			Statement sta = conn.createStatement();
			ResultSet resultSet = sta.executeQuery("select * from books");
			while (resultSet.next()) {
				System.out.println(
						resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString("bookPrice"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
