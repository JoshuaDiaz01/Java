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
    <title></title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/css/style.css"/>
    <title></title>
</head>
<body>
<%-- 	<div class="container d-flex justify-content-between align-items-center mb-3">
		<h1>Welcome Ninjas</h1>
		<H2>View Ninjas</H2>
		<a href="/dojos">Dashboard</a>	
	</div>
	<div class="container d-flex justify-content-between gap-3">
		<div class="col-6 border border-dark p-3">
			<h2>Add a Ninja:</h2>
			<table class="table table-striped">
				<thead class="table-dark">
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Age</th>
						<th>Dojo</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="oneNinja" items="${ allNinjas }">
						<tr>
							<td><c:out value="${ oneNinja.firstName }" /></td>
							<td><c:out value="${ oneNinja.lastName }" /></td>
							<td><c:out value="${ oneNinja.age }" /></td>
							<td><c:out value="${ oneNinja.dojo.name }" /></td>
							<td>

							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div> --%>
		<div class="col-6 border border-dark p-3">
			<h2>Add A Book to Your Shelf!</h2>
			<form:form action="/books/create" method="post" modelAttribute="newBook">
				<div class="form-group">
					<form:label path="title">Title:</form:label>
					<form:input path="title" />
					<form:errors path="title" />
				</div>
				<div class="form-group">
					<form:label path="author">Author:</form:label>
					<form:input path="author" />
					<form:errors path="author" />
				</div>
				<div class="form-group">
					<form:label path="comment">Comment:</form:label>
					<form:input path="comment"/>
					<form:errors path="comment"/>
				</div>
				
				<button class="btn btn-outline-success">Add Book</button>
			</form:form>
		</div>
	
	<a href="/welcome">Back to the shelves</a>
</body>
</html>