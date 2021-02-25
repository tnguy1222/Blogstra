<!-- Adam Bender
Jim Nguyen
Milestone 8
12/20/2020
User blogs page -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Blogs</title>

	<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/css/jquery.dataTables.css">
	<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/css/jquery.dataTables_themeroller.css">
</head>
<body>

	<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/jquery.dataTables.min.js"></script>

	<table id="table_id" class="display">
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Body</th>
				<th>Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${blogs}" var="b">
				<tr>
					<td>${b.id}</td>
					<td>${b.title}</td>
					<td>${b.body}</td>
					<td>${b.date}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<script>
		$(document).ready(function() {
			$('#table_id').DataTable();
		});
	</script>

</body>
</html>