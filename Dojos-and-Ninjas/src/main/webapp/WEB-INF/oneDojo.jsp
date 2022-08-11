
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
   	 
   	 <h1>Here is: <c:out value="${ dojo.name }" />!</h1>
   	
   	 <a href="/dojos" class="btn btn-primary">Dashboard</a>
	 <a href="/dojos/${ dojo.id }/edit" class="btn btn-warning">Update</a>
	 <form action="/dojos/${ dojo.id }/delete" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete" class="btn btn-danger">
	</form>
	<h2>Here are <c:out value="${ dojo.name }" /> Ninja's:</h2>
	<ul>
		<c:forEach var="ninja" items="${ dojo.ninjas }">
			<li> <c:out value="${ ninja.firstName }" /> <c:out value="${ ninja.lastName }" /> <c:out value="${ ninja.age }" /></li>
			
			
		</c:forEach>
	</ul>
</body>
</html>