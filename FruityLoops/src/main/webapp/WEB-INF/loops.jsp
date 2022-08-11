<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!-- You will put the import in the first line of the jsp tag. Use the import attribute -->

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Demo JSP</title>
    </head>
<body>


<c:forEach var="fruits" items="fruits">
<h1>Fruit:<c:out value="${fruits.name}"/></h1> 
<h2>Price: $<c:out value="${fruits.price}"/></h2> 
</c:forEach>

	
	
</body>
</html>