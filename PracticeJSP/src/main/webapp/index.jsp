<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- <jsp:forward page="simple.jsp">
		<jsp:param name="name" value="google.com" />

	</jsp:forward> --%>

	<%
	//Class.forName("com.mysql.jdbc.Driver");
	//out.print("Connecting to data base");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb","root","Sravani@6086");
	out.println("Connection done");
	Statement statement =connection.createStatement();
	ResultSet resultSet=statement.executeQuery("select * from login");
	while(resultSet.next()){
		out.println(resultSet.getString(1)+" "+resultSet.getString(2));
	}

	%>
</body>
</html>