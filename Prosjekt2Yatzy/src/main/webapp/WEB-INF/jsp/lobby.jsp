<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 --%><!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lobby</title>
</head>
<body>


	<form action="Lobby" method="post">
		<fieldset>
				<%request.getAttribute("registerForm"); %>
			
				${registerForm.username}<br/>
				"${registerForm.name}"<br/>
				"${registerForm.email}"<br/>
			<p>
				<input type="submit" value="Refresh" />
			</p>
		</fieldset>
	</form>

	<p>
		<a href="Lobby">Ferdig</a>
	</p>

</body>
</html>