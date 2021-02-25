<!-- Adam Bender
Jim Nguyen
Milestone 5
11/15/2020
Navbar -->

<!-- Navbar -->
<div class="w3-top">
	<div class="w3-bar w3-red w3-card w3-left-align w3-large">
		<a
			class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red"
			href="javascript:void(0);" onclick="myFunction()"
			title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a> 
			<a
			href="/CST341-CLCProject/home"
			class="w3-bar-item w3-button w3-padding-large w3-white">Home</a>
			
			<%
				//if someone is logged in
				if(session.getAttribute("user_session") != null)
				{
					%>
					<a href="/CST341-CLCProject/logout" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white w3-right">Log Out</a>
					<a href="/CST341-CLCProject/blogs" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Blogs</a>
				<%
				}else
				{
					%>
					<a href="/CST341-CLCProject/register" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white w3-right">Register</a>
					<a href="/CST341-CLCProject/login" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white w3-right">Login</a> 
				<%
				}
			
			%>
	</div>
</div>