<!-- Adam Bender
Jim Nguyen
Milestone 5
11/15/2020
Blog creation page -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Blog Post</title>
</head>
<body>
<div align="center">
<h2>Create Blog Post</h2>
	<form:form method="POST" modelAttribute="blog" action="createblog">
		<table>
			<tr>
				<td><form:textarea rows = "1" cols = "100" placeholder = "Title" path = "title" /> 
				<br><form:errors path="title" /></td>
			</tr>
			<tr>
				<td><form:textarea rows = "20" cols = "100" placeholder = "Body" path = "body" />
				<br><form:errors path="body" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Post"/>
				</td>
			</tr>
		</table>
		<form:errors path="*" />
	</form:form>
	<br>
	<br>
</div>
</body>
	
</html>