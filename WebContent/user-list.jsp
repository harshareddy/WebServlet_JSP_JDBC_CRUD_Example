<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"	>
</head>
<body>

  <jsp:include page="head.jsp"></jsp:include>

	<!-- Nav Bar End -->
	<!-- Content Begin -->
	<div class="container">
		<br /> <br />
           <a href="<%=request.getContextPath()%>/UserServlet?action=userform" class="btn btn-success">CreateUser</a>		
		<h3>Users List</h3>
		<table class="table table-striped table-hover table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Country</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${listUser}">
					<tr>
						<td><c:out value="${user.id}"></c:out></td>
						<td><c:out value="${user.name}"></c:out></td>
						<td><c:out value="${user.email}"></c:out></td>
						<td><c:out value="${user.country}"></c:out></td>
						
						<td>
						 <a href="<%=request.getContextPath()%>/UserServlet?action=edituser&id=<c:out value="${user.id}"/>" class="btn btn-secondary">Edit</a>
						 <a href="<%=request.getContextPath()%>/UserServlet?action=deleteuser&id=<c:out value="${user.id}"/>" class ="btn btn-danger">Delete</a>
						</td>
					</tr>
				</c:forEach>


			</tbody>
		</table>
	</div>
	<!-- Content End  -->

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>