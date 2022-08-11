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
   <!-- Inserting a for loop into your jsp -->
<%--     <% for(int i = 0; i < 5; i++) { %>
        <h1><%= i %></h1>
    <% } %>
    <p>The time is: <%= new Date() %></p>
      --%>
<%--     <h1>Two plus two is:</h1>
	<h2><c:out value="${2+2}"/></h2>
	
	<h1>Fruit of the Day</h1>
	<h2><c:out value="${fruit}"/></h2>
	${fruit} --%>
	
<h1>Costumer name:<c:out value="${name}"/></h1> 
<h2>Item Name:<c:out value="${itemName}"/></h2> 
<h2>Price: $<c:out value="${price}"/></h2> 
<h2>Description:<c:out value="${description}"/></h2> 
<h2>Vendor:<c:out value="${vendor}"/></h2> 
	
	
</body>
</html>