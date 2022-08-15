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
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Dashboard</title>
</head>
<body>

<h3>Welcome, <c:out value="${user.userName}"></c:out>!</h3>
<p>Books from everyone's shelf</p>
<p><a href="/logout">logout</a></p>
<p><a href="/books">+ Add a book to your shelf</a></p>

<h1>Books from everyones shelves</h1>

<table>
	<thead>
		<tr>
			<th>Id</th>
			<th>Title</th>
			<th>Author name</th>
			<th>Posted By</th>
		</tr>
	</thead>
	
	<tbody>
	

		<c:forEach var="book" items="${ allBooks }">
				<tr scope="row">
					<td><a href = "/books/${book.id}"><c:out value="${ book.id }"/></a></td>
					<td><c:out value="${ book.title }" /></td>
					<td><c:out value="${ book.author }" /></td>
					<td><c:out value="${ book.user.userName }" /></td>
				</tr>
		</c:forEach>
	
	</tbody>
	
</table>
   	
   	
   	
   	
<%--    	 <a href="/books" class="btn btn-primary">Dashboard</a>
	 <a href="/books/${ user.id }/edit" class="btn btn-warning">Update</a> --%>
	
	
<%-- 	 <form action="/books/${ book.edit }/delete" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete" class="btn btn-danger">
	</form> --%>
	
	
	
	<%-- <h2>Here are <c:out value="${ user.userName }" /> Books:</h2>
	<ul>
		<c:forEach var="book" items="${ user.books }">
			<li> <c:out value="${ book.title }" /> <c:out value="${ book.author }" /> <c:out value="${ book.comment }" /></li>
			
			
		</c:forEach>
	</ul> --%>

</body>
</html>