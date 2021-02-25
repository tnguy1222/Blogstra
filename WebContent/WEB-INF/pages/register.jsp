<!-- Adam Bender
Jim Nguyen
Milestone 8
12/20/2020
Register page -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
<div align="center">
	<h2>Register</h2>
	<form:form method="POST" modelAttribute="user" action="registeruser">
		<table>
			<tr>
				<td><form:label path="firstName">First Name: </form:label></td>
				<td><form:input path="firstName" /><br>
				<form:errors path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name: </form:label></td>
				<td><form:input path="lastName" /><br>
				<form:errors path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email: </form:label></td>
				<td><form:input path="email" /><br>
				<form:errors path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="phoneNumber">Phone Number: </form:label></td>
				<td><form:input path="phoneNumber" /><br>
				<form:errors path="phoneNumber" /></td>
			</tr>
			<tr>
				<td><form:label path="username">Username: </form:label></td>
				<td><form:input path="username" /><br>
				<form:errors path="username" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password: </form:label></td>
				<td><form:input path="password" /><br>
				<form:errors path="password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Register" /></td>
			</tr>
		</table>
		<form:errors path="*" />
	</form:form>
	<br>
	<br>
</div>
</body>
</html>