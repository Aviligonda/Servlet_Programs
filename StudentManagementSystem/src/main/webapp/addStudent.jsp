<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="header.jsp" %>
	<%@ include file="db.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add</title>
</head>
<body>
	<%

	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String branch = request.getParameter("branch");
	String contactNumber = request.getParameter("contact");
	PreparedStatement pStatement=connection.prepareStatement("insert into sms values(?,?,?,?)");
	pStatement.setString(1, id);
	pStatement.setString(2, name);
	pStatement.setString(3, branch);
	pStatement.setString(4, contactNumber);
	pStatement.execute();
	out.println("Successfully add a new Student <br>");
	
	%>
	<a href = "index.jsp">Go Back to Main Page</a>
</body>
</html>