<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!-- You will put the import in the first line of the jsp tag. Use the import attribute -->

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Show</title>
    </head>
<body>

<a href="/welcome">Back to Course Dashboard!</a>

<h1><c:out value="${ course.name }"/> with <c:out value="${ course.user.firstName }" /></h1>

<h2>Day: <c:out value="${ course.day }"/></h2>
<div></div>
<h2>Price: $<c:out value="${ course.price }"/></h2>
<div></div>
<h2>Description: <c:out value="${ course.comment }"/></h2>


<c:if test = "${book.user.id == user.id}"> 
<a href = "/books/${bookId}/edit">Edit Book</a>
</c:if> 

</body>
</html>