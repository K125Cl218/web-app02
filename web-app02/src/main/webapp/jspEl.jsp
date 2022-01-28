<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EL : Expression language</title>
</head>
<body>
<jsp:useBean id="emp" class="fr.formation.inti.entity.Employee"></jsp:useBean>

<jsp:setProperty property="firstName" name="emp" value="Nicolas"/>
<jsp:setProperty property="lastName" name="emp" value="Chanussot"/>

<h1>Hello ${emp.firstName} ${emp.lastName}</h1>

<!-- Fonctionnement avec la Servlet EmployeeServlet 
	et avec les paramètres dans l'url -->
<%= request.getParameter("firstName") %>
<h1>Hello ${firstName} ${lastName}</h1>
</body>
</html>