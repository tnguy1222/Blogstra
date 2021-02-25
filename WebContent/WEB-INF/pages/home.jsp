<!-- Adam Bender
Jim Nguyen
Milestone 8
12/20/2020
Home page -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.gcu.model.User" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blogstra</title>
</head>
<body>
<div align="center">

<%
	if(session.getAttribute("user_session") != null)
	{
		User u1 = (User) session.getAttribute("user_session");
		String firstName = u1.getFirstName();
		pageContext.setAttribute("firstName", firstName);
		%>
		<h2 class="w3-text-red">Welcome ${firstName}.</h2>
	<%
	}else
	{
		%>
		<h2 class="w3-text-red">Please login or register</h2>
	<%
	}

%>
</div>
</body>
</html>