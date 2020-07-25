<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<div class="container">
   <br/>
   <br/>
   <h2>Edit User</h2>
	<form action="<%=request.getContextPath()%>/updateuser" method="get">
		
		<div class="form-group">
			<label for="id">User Name</label> 
			<input type="text" class="form-control" name="id" class="form-control" value="<c:out value="${user.id}"/>"  readonly  />
		</div>
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
</html>