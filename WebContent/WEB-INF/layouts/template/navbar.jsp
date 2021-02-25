<!-- Adam Bender
Jim Nguyen
Milestone 8
12/20/2020
Navbar -->

<!-- Navbar -->
<nav class="navbar navbar-default navbar-fixed-top w3-red">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="/CST341-CLCProject/home" class="navbar-brand w3-text-white">Home</a>
        </div>
        <!-- Collection of nav links and other content for toggling -->
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
            
            	<%
				//if someone is logged in
				if(session.getAttribute("user_session") != null)
				{
					%>
						<li><a href="/CST341-CLCProject/blogs" class="w3-text-white">Blogs</a></li>
						<li><a href="/CST341-CLCProject/findUserBlogs" class="w3-text-white">My Blogs</a></li>
					
				<%
				}else
				{
					%>
						
				<%
				}
			%>
      
            </ul>
            <ul class="nav navbar-nav navbar-right">
            
                
				<%
				//if someone is logged in
				if(session.getAttribute("user_session") != null)
				{
					%>
						<li><a href="/CST341-CLCProject/logout" class="w3-text-white">Log Out</a></li>
				<%
				}else
				{
					%>
						<li><a href="/CST341-CLCProject/register" class="w3-text-white">Register</a></li>
						<li><a href="/CST341-CLCProject/login" class="w3-text-white">Login</a> </li>
				<%
				}
			
			%>
				
            </ul>
        </div>
    </div>
</nav>
