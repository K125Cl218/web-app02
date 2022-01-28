<%@page import="java.io.PrintWriter" isErrorPage="true"%>
<%@page import="java.io.StringWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
<h2>Some error in page</h2>
Massage : <%= exception.getMessage() %>

<h3>StackTrace :</h3>
<%
	StringWriter sw = new StringWriter();
	PrintWriter pw = new PrintWriter(sw);
	
	exception.printStackTrace(pw);
	out.println("<pre>");
	out.println(sw);
	out.println("</pre>");
	pw.close();
	sw.close();
%>


</body>
</html>