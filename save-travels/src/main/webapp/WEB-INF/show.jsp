<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Insert title here</title>
</head>

<body style="margin: 10vw;">
<h1>Safe Travels</h1><a href="/expenses/">Go back</a>
<h1>Purchase: <c:out value = "${expense.name}"></c:out></h1>

<p><c:out value = "${expense.name}"></c:out></p>
<p><c:out value = "${expense.vendor}"></c:out></p>
<p><c:out value = "${expense.amount}"></c:out></p>
<p><c:out value = "${expense.description}"></c:out></p>



</div>
</body>
</html>