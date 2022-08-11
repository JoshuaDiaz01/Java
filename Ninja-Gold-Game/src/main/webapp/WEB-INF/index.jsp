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
<h2>Your Gold: <c:out value="${gold}"/></h2>


<table>

	<tr>
	  <td>
	  	<h3>Farm</h3>
		<p>(earns 10-20 gold)</p>
		<form action="/gold" method="post"><input class="button" type="submit" name="farm" value="Find Gold!"/></form>
	  </td>
	  <td>
	  	<h3>Cave</h3>
		<p>(earns 5-10 gold)</p>
		<form action="/gold" method="post"><input class="button" type="submit" name="cave" value="Find Gold!"/></form>
	  </td>
	  <td>
	  	<h3>House</h3>
		<p>(earns 2-5 gold)</p>
		<form action="/gold" method="post"><input class="button" type="submit" name="house" value="Find Gold!"/></form>
	  </td>
	  <td>
	  	<h3>Quest</h3>
		<p>(earns/takes 0-50 gold)</p>
		<form action="/gold" method="post"><input class="button" type="submit" name="quest" value="Find Gold!"/></form>
	  </td>
	  <td>
	  	<h3>Spa</h3>
		<p>(takes 5-20 gold)</p>
		<form action="/gold" method="post"><input class="button" type="submit" name="spa" value="Visit Spa"/></form>
	  </td>
	</tr>

</table>
<form action="/reset" method="post"><input class="button" type="submit" value="Reset"/></form>

<br>
<h2>Activities:</h2>
<br>
<iframe src="/activities/" title="Activities Iframe"></iframe>
</body>
</html>