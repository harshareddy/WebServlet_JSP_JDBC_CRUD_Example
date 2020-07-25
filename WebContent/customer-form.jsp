<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"	>
</head>
<body>
    <jsp:include page="head.jsp"></jsp:include>
      
      <div class="container">
			<br/>			
			<br/>
			<c:if test= "${customer != null}">	
			        <form action="<%=request.getContextPath()%>/CustomerServlet" method="get">		  
					<h2>Update  Existing Customer</h2>
				      <input type="hidden" name="action" value="updatecustomer">
					  <input type="hidden" class="form-control" name="cust_id" class="form-control" value="<c:out value="${customer.cust_id}"/>"  readonly  />
					
					<br/><br/>								
			</c:if>
			<c:if test= "${customer == null}">
			     <form action="<%=request.getContextPath() %>/CustomerServlet" method="get">
			        <input type="hidden" name="action" value="createcustomer">
			     <h2>Add New Customer</h2>	
			     <br/><br/>				
			</c:if>			    
				   <div class="form-group">
						<label for="cust_first_name">First Name</label> 
						<input type="text" class="form-control" name="cust_first_name" value="<c:out value="${customer.cust_first_name}"/>" />
					</div>
					<div class="form-group">
						<label for="name">Last Name</label> 
						<input type="text" class="form-control" name="cust_last_name" value="<c:out value="${customer.cust_last_name}"/>" />
					</div>
					<div class="form-group">
						<label for="email">Email</label> <input type="text"
							class="form-control" class="form-control" name="cust_email" value="<c:out value="${customer.cust_email}"/>">
					</div>
					<div class="form-group">
						<label for="email">City</label> <input type="text"
							class="form-control" class="form-control" name="cust_city" value="<c:out value="${customer.cust_city}"/>">
					</div>
					<div class="form-group">
						<label for="country">Country</label> <input type="text"
							class="form-control" class="form-control" name="cust_country" value="<c:out value="${customer.cust_country}"/>">
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>				
			</div>

</body>
</html>