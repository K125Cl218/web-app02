<%@page import="java.util.Random" errorPage="error.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Example</title>
</head>
<body>
<%!
	public int sum(int a, int b) {
		return a+b;
	}
%>

<%! int count = 0; %>

<%
	Random random = new Random();
	int randomInt = random.nextInt(3);
	if(randomInt == 0) {
		%>
		<h1>Random value = <%=randomInt %></h1>
<%
	} else if (randomInt == 1) {
		%>
		<h1>Random value = <%=randomInt %></h1>
<%
	} else {
		%>
		<h1>Random value = <%=randomInt %></h1>
<%
	}
%>
<h3><%=randomInt %> + 1 = <%=sum(randomInt, 1) %></h3>
<a href="<%= request.getRequestURI() %>">click</a>
<h3><%= count++ %></h3>

</body>
</html>