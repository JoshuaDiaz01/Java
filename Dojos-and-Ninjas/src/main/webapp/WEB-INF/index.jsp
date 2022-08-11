<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) --> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Functions --> 
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dojos and Ninjas</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
   <!--  <link rel="stylesheet" href="/css/main.css"> change to match your file/naming structure -->
<!--     <script src="/webjars/jquery/jquery.min.js"></script> -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>Welcome to Dojos and Ninjas</h1>
	
	<h2>These are the Dojos:</h2>
	<table class="table table-striped">
		<thead class="table-dark">
			<tr scope="row">
				<th>Id</th>
				<th>Name</th>
				<th>Created At</th>
				<th>Update At</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dojo" items="${ dojos }">
				<tr scope="row">
					<td><c:out value="${ dojo.id }" /></td>
					<td><c:out value="${ dojo.name }" /></td>
					<td><fmt:formatDate type="date"  value="${ dojo.createdAt }" /></td>
					<td>
						<c:choose>
							<c:when test="${ dojo.updatedAt != null }">
								<fmt:formatDate type="date"  value="${ dojo.updatedAt }" />
							</c:when>
							<c:otherwise>
								Dojo has not been updated
							</c:otherwise>
						</c:choose>
					</td>
					<td>
						 <a href="/dojos/${ dojo.id }" class="btn btn-primary">View</a>
						 <a href="/dojos/${ dojo.id }/edit" class="btn btn-warning">Update</a>
						 <form action="/dojos/${ dojo.id }/delete" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete" class="btn btn-danger">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/dojos/new" class="btn btn-success">Create a new Dojo!</a>
	<a href="/ninjas" class="btn btn-outline-primary">Go To the Ninjas Page</a>
</body>
</html>

