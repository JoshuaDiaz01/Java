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
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Dashboard</title>
</head>
<body>

<h3>Namaste, <c:out value="${user.firstName}"></c:out>!</h3>
<h1>Course Dashboard</h1>
<p><a href="/logout">logout</a></p>



<table>
	<thead>
		<tr>
			<th>Class Name</th>
			<th>Instructor</th>
			<th>Weekday</th>
			<th>Price</th>
		</tr>
	</thead>
	
	<tbody>
	

		<c:forEach var="course" items="${ allCourses }">
				<tr scope="row">
					
					<td>
						<a href = "/courses/${course.id}"><c:out value="${ course.name }"/></a>
						<c:if test = "${course.user.id == user.id}"> 
							<a href = "/courses/${course.id}/edit">Edit Course</a>
						</c:if> 
					</td>
					<td><c:out value="${ course.user.firstName }" /></td>
					<td><c:out value="${ course.day }" /></td>
					<td><c:out value="${ course.price }" /></td>
				</tr>
		</c:forEach>
	
	</tbody>
	
</table>
<p><a href="/courses">+ new course</a></p>
   	
   	
   	
   	
<%--    	 <a href="/books" class="btn btn-primary">Dashboard</a>
	 <a href="/books/${ user.id }/edit" class="btn btn-warning">Update</a> --%>
	
	
<%-- 	 <form action="/books/${ book.edit }/delete" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete" class="btn btn-danger">
	</form> --%>
	
	
	
	<%-- <h2>Here are <c:out value="${ user.userName }" /> Books:</h2>
	<ul>
		<c:forEach var="book" items="${ user.books }">
			<li> <c:out value="${ book.title }" /> <c:out value="${ book.author }" /> <c:out value="${ book.comment }" /></li>
			
			
		</c:forEach>
	</ul> --%>

</body>
</html>