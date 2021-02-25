<!-- Adam Bender
Jim Nguyen
Milestone 5
11/15/2020
Login page -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<div align="center">
<h2>Login</h2>
	<form:form method="POST" modelAttribute="user" action="loginuser">
		<table>
			<tr>
				<td><form:label path="username">Username: </form:label></td>
				<td><form:input path="username" /><br><form:errors path="username" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password: </form:label></td>
				<td><form:input path="password" /><br><form:errors path="password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Login"/>
				</td>
			</tr>
		</table>
		<form:errors path="*" />
	</form:form>
</div>
</body>
	
</html>