<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="db.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String branch = request.getParameter("branch");
	String number = request.getParameter("phoneNumber");
	PreparedStatement preparedStatement = connection.prepareStatement("insert into sms values(?,?,?,?)");

	preparedStatement.setString(1, id);
	preparedStatement.setString(2, name);
	preparedStatement.setString(3, branch);
	preparedStatement.setString(4, number);

	preparedStatement.execute();
	%>

</body>
</html>