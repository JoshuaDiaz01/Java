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

<h1>Send an Omikuji!</h1>


<form action = "/submit" method = "post">
<p>
Pick a number from 5-25
<input type="text" name = "number"/>
</p>

<p>
Enter the name of any city
<input type="text" name = "city"/>
</p>

<p>
Enter the name of any real person
<input type="text" name = "name"/>
</p>

<p>
Enter professional endeavor or hobby
<input type="text" name = "hobby"/>
</p>

<p>
Enter any type of living thing
<input type="text" name = "animal"/>
</p>

<p>
Say something nice to someone
<input type="text" name = "comment"/>
</p>


<button>Submit</button>
</form>
	
</body>
</html>