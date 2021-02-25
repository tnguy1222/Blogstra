<!-- Adam Bender
Jim Nguyen
Milestone 8
12/20/2020
All blogs page -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.gcu.model.User"%>
<%@ page import="com.gcu.model.Blog"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blog Posts</title>

<style>
* {
	box-sizing: border-box;
}

/* Add a gray background color with some padding */
.blogarea {
	font-family: Arial;
	padding: 20px;
	background: #f1f1f1;
}

/* Create two unequal columns that floats next to each other */
/* Left column */
.leftcolumn {
	float: left;
	width: 75%;
}

/* Right column */
.rightcolumn {
	float: left;
	width: 25%;
	padding-left: 20px;
}

/* Add a card effect for articles */
.card {
	background-color: white;
	padding: 20px;
	margin-top: 20px;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 800px) {
	.leftcolumn, .rightcolumn {
		width: 100%;
		padding: 0;
	}
}
</style>

</head>
<body>

	<%
		User u1 = (User) session.getAttribute("user_session");
		pageContext.setAttribute("username", u1.getUsername());
		pageContext.setAttribute("firstName", u1.getFirstName());
		pageContext.setAttribute("lastName", u1.getLastName());
		pageContext.setAttribute("phone", u1.getPhoneNumber());
		pageContext.setAttribute("email", u1.getEmail());
		pageContext.setAttribute("id", u1.getId());
	%>

	<div class="blogarea">
		<a href="/CST341-CLCProject/addBlog">Create a Blog Post</a>


		<div class="row">
			<div class="leftcolumn">

				<c:forEach items="${blogs}" var="b">
				
					<div class="card">
						<h2>${b.title}</h2>
						
						<h5>By ${b.username}, ${b.date}</h5>
						<p>${b.body}</p>
						
						<c:if test="${id eq b.user_id}">
						
						<form:form method="GET" action="findBlog/${b.id}">

							<input type="submit" value="Update" />

						</form:form>
						
						<form:form method="GET" action="blogsConfirmDelete/${b.id}">

							<input type="submit" value="Delete" />

						</form:form>
						</c:if>
					</div>
				</c:forEach>
			
			</div>

			<div class="rightcolumn">
				<div class="card">
					<h2>About Me</h2>
					<p>
						Name: ${firstName} ${lastName}<br> Username: ${username}<br>
						Email: ${email}<br> Phone: ${phone}
					</p>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
</body>

</html>