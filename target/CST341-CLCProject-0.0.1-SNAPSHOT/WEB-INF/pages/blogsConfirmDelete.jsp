<!-- Adam Bender
Jim Nguyen
Milestone 5
11/15/2020
Blog confirm deletion -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Deletion</title>
</head>
<body>
	<div align="center">
		<h2>Are you sure you want to delete this blog?</h2>

		<table>
			<tr>
				<td colspan="2" align="center">
					<form:form method="POST" modelAttribute="blog" action="http://localhost:8080/CST341-CLCProject/deleteBlog">
						<form:hidden path="id" value="${blog.id}" />
						<input type="submit" value="Yes" />
					</form:form></td>
				<td colspan="2" align="center">
					<form:form method="GET" action="http://localhost:8080/CST341-CLCProject/blogs">
						<input type="submit" value="No" />
					</form:form></td>
			</tr>
		</table>

		<br> <br>
	</div>
</body>

</html>