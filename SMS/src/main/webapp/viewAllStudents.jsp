<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
Statement statement = connection.createStatement();
ResultSet resultSet = statement.executeQuery("select * from sms");

while(resultSet.next()){
	out.print(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+"  "+resultSet.getString(4));
	
}

%>
</body>
</html>