<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Say Hello jsp</title>
</head>
<body>

<form action="sayHello.jsp" method="post">
	<label>First name : </label>
	<input type="text" name="firstName">
	<label>Last name : </label>
	<input type="text" name="lastName">
	<input type="submit" value="Say Hello">
</form>

<h1>${firstName} ${lastName}</h1>

</body>
</html>