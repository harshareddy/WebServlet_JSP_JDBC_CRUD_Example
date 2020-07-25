<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"	>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
	<div class="container">
			<br />			
			<br />
			<c:if test= "${user != null}">	
			<form action="<%=request.getContextPath()%>/UserServlet" method="get">		  
					<h2>Update  Existing User</h2>
					<input type="hidden" name="action" value="updateuser"/>
					<div class="form-group">
						<label for="id">User Id</label> 
						<input type="text" class="form-control" name="id" class="form-control" value="<c:out value="${user.id}"/>"  readonly  />
				   </div> 								
			</c:if>
			<c:if test= "${user == null}">
			  <form action="<%=request.getContextPath() %>/UserServlet" method="get">
			     <input type="hidden" name="action" value="newuser"/>					
			</c:if>
			    <h2>Add New User</h2>
				<div class="form-group">
						<label for="name">User Name</label> 
						<input type="text" class="form-control" name="name" class="form-control" value="<c:out value="${user.name}"/>" />
					</div>
					<div class="form-group">
						<label for="email">User Email</label> <input type="text"
							class="form-control" class="form-control" name="email" value="<c:out value="${user.email}"/>">
					</div>
					<div class="form-group">
						<label for="country">User Country</label> <input type="text"
							class="form-control" class="form-control" name="country" value="<c:out value="${user.country}"/>">
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>				
			</div>
</body>
</body>
</html>