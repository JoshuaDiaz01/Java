<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- You will put the import in the first line of the jsp tag. Use the import attribute -->

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Demo JSP</title>
    </head>
<body>

<h1>Heres your Omikuji!</h1>

<p>In <c:out value = "${number}"></c:out>years, you will live in <c:out value = "${city}"></c:out> with <c:out value = "${name}"></c:out> as your roommate, selling <c:out value = "${hobby}"></c:out> for a living. The next time you see a <c:out value = "${animal}"></c:out>, you will have good luck. Also, <c:out value = "${comment}"></c:out></p>


<p><a href = "/">Go Home</a></p>

	
</body>
</html>