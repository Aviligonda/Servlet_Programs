<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple Jsp</title>
</head>
<body>
	<!-- using Scriptlet tag is <%%> -->
	<%
	String name = request.getParameter("name");
	out.println("Welcome " + name);
	%>

	<!-- Using Expression Tag -->

	<%="Welocme " + request.getParameter("name")%>

	<!-- Declaration tag  -->

	<%!int i = 6;%>
	<%="Number is :" + i%>
	<%!int cube(int n) {
	return n * n * n;
}%>
	<%="Cube of 3 is " + cube(3)%>
	<%
	
	out.print(LocalDate.now());
	%>


</body>
</html>