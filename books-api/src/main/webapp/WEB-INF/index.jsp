<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!-- You will put the import in the first line of the jsp tag. Use the import attribute -->

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Books assignment</title>
    </head>
<body>

<h1>All Books</h1>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Language</th>
            <th>Number of Pages</th>
        </tr>
    </thead>
    <tbody>
         <!-- loop over all the books to show the details as in the wireframe! -->
         <c:forEach var = "book" items = "${books}">
         	<tr>
         		<td><c:out value="${book.id}"></c:out></td>
         		<!-- sending the link to my controller to render the show page -->
         		<td><a href= "/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
         		<td><c:out value="${book.language}"></c:out></td>
         		<td><c:out value="${book.numberOfPages}"></c:out></td>
         		
       		</tr>
         </c:forEach>
    </tbody>
</table>
	
</body>
</html>