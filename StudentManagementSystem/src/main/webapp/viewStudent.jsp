<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="header.jsp" %>
	<%@ include file="footer.jsp" %>
	<%@ include file="db.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Students</title>
</head>
<body>
	<%
	Statement statement = connection.createStatement();
	ResultSet resultSet = statement.executeQuery("select * from sms");
	out.print("<table border='3' align='center' cellspacing='1' cellpadding='15'>");
	out.print("<tr><th>Id</th><th>Name</th><th>Branch</th><th>Contact number</th></tr>");
	while(resultSet.next()){
		out.println("<tr><td>"+resultSet.getString(1)+"</td><td> "+resultSet.getString(2)+"</td><td> "+resultSet.getString(3)+"</td><td> "+resultSet.getString(4)+"</td></tr>");
		
	}

	%>
		<a href = "index.jsp">Go Back to Main Page</a>
</body>
</html>