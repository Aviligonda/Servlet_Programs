<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@ include file="footer.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration form</title>
</head>
<body>

	<form action="addStudent.jsp">
		ID: <br> 
		<input type="text" name="id"> <br> 
		Name: <br>
		<input type="text" name="name"> <br> 
		Branch: <br> 
		<input	type="text" name="branch"> <br>
	    Contact Number: <br>
		<input type="text" name="contact"> <br><br>
		<input	type="submit" value="Submit">
	</form>
	<br><br>
	<a href = "index.jsp">Go Back to Main Page</a>

</body>
</html>