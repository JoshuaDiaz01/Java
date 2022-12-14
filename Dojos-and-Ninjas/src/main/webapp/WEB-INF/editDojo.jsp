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
   
   	<h1>Edit <c:out value="${ dojo.name }" /></h1>
   	<form:form action="/dojos/${ dojo.id }/update" method="post" modelAttribute="dojo" class="form">
   		<input type="hidden" name="_method" value="put">
   		<p>
   			<form:label path="name">Name:</form:label>
   			<form:input path="name" />
   			<form:errors path="name" />
   		</p>

   		<button class="btn btn-outline-success">Edit this dojo!</button>
   	</form:form>
   	
   	<a href="/dojos">Cancel</a>
</body>
</html>