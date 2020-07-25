<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- nav bar Begin  -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="<%=request.getContextPath()%>/welcome.jsp">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/about.jsp" >About</a></li>			
			<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/UserServlet?action=listuser">Manage User</a></li>
			<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/CustomerServlet?action=listcustomer">Manage Customer</a></li>
			<li class="nav-item"><a class="btn btn-success" href="<%=request.getContextPath()%>/LogoutServlet">LogOut</a></li>
		</ul>		
	</div>
</nav>