<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Logg inn</title>
</head>
<body>
	<h2>Logg inn</h2>
	<p>Det er kun registrerte deltagere som får se deltagerlisten.</p>
	<p>
				
	</p>
	<form action="Logginn" method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="username">Username:</label> <input type="text"
					name="username" />
			</div>
			<div class="pure-control-group">
				<label for="password">Password:</label> <input type="password"
					name="password" />
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Logg
					inn</button>
			</div>
		</fieldset>
	</form>

</body>
</html>