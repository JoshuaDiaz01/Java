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



<h1>${book.title}</h1>

<p>${book.description}</p>
<p>${book.language}</p>
<p>${book.numberOfPages}</p>



	
	
</body>
</html>