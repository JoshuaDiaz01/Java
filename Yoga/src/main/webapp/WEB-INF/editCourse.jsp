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
		<div class="col-6 border border-dark p-3">
			<h2>Edit <c:out value = "${course.name}"/></h2>
			<form:form action="/courses/${course.id}/update" method="post" modelAttribute="course">
				<input type = "hidden" name ="_method" value = "put"/>
				<%-- <input type = "hidden" name ="user" value = "${book.user.id}"/> --%>
				<div class="form-group">
					<form:label path="name">Name: </form:label>
					<form:input path="name" />
					<form:errors path="name" />
				</div>
				<div class="form-group">
					<form:label path="day">WeekDay: </form:label>
					<form:input path="day" />
					<form:errors path="day" />
				</div>
				<div class="form-group">
					<form:label path="price">Price: </form:label>
					<form:input path="price"/>
					<form:errors path="price"/>
				</div>
				<div class="form-group">
					<form:label path="comment">Description: </form:label>
					<form:input path="comment"/>
					<form:errors path="comment"/>
				</div>
				
				<button class="btn btn-outline-success">Update Course</button>
			</form:form>
		</div>
		<form action="/course/${course.id}/delete" method="post">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete" class="btn btn-danger">
		</form>
		<a href="/welcome">Back to the Course Dashboard!</a>
		
	

</body>
</html>