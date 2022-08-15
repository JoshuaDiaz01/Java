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

<a href="/welcome">Back to the shelves!</a>

<h1><c:out value="${ book.title }" /></h1>

<h2><c:out value="${ book.user.userName }"/> read <c:out value="${ book.title }"/> by <c:out value="${ book.author }"/>.</h2>
<h2>Here are <c:out value="${ book.user.userName }"/>'s thoughts.</h2>
----------------------------------------------------
<div></div>
<c:out value="${ book.comment }"/>
<div></div>
----------------------------------------------------
	
	
</body>
</html>