<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers</title>
<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"	>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="container">
	<br/>
	<br/>
    <h2>Customer List</h2>
    <a href="<%=request.getContextPath()%>/CustomerServlet?action=customerform"   class="btn btn-success">CreateCustomer</a>    
 	<table class="table table-striped table-hover table-hover">
			<thead>
				<tr>
					<th>Customer Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>City</th>
					<th>Country</th>
					<th></th>
					
				</tr>
			</thead>
			<tbody>
			 <c:forEach var="customer" items="${customerList}">
			  <tr>
			    	<td><c:out value="${customer.cust_id}"></c:out></td>
					<td><c:out value="${customer.cust_first_name}"></c:out></td>
					<td><c:out value="${customer.cust_last_name}"></c:out></td>
					<td><c:out value="${customer.cust_email}"></c:out></td>
					<td><c:out value="${customer.cust_city}"></c:out></td>
					<td><c:out value="${customer.cust_country}"></c:out></td>
					<td>
					   <a href="<%=request.getContextPath() %>/CustomerServlet?action=editcustomerform&cust_id=<c:out value="${customer.cust_id}"/>" class="btn btn-secondary">Edit</a>
				       <a href="<%=request.getContextPath() %>/CustomerServlet?action=deletecustomer&cust_id=<c:out value="${customer.cust_id}"/>" class ="btn btn-danger">Delete</a>
				    </td>		
			  </tr>			 
			 </c:forEach> 
			
			</tbody>
	</table>
</div>	
 <!-- Contend End -->
 
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>