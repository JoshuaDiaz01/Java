<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!-- You will put the import in the first line of the jsp tag. Use the import attribute -->

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Counter JSP</title>
    </head>
<body>

<h1>You have visited <a href = "/"></a> <c:out value="${count}"/>time(s)</h1>
<p><a href = "/">Test Another visit</a></p>
<p><a href = "/reset-counter/">Reset Counter</a></p>


	
	
</body>
</html>