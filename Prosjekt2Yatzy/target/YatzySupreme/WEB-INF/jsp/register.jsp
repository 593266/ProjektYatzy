<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Register</title>
</head>
<body>

	<h2>P�melding</h2>
	<form action="RegisterForm" method="post">
		<fieldset>
		
			
				<label for="username">Username:</label> 
				<input type="text" 
					name="username" 
					class="input"
					value="${registerForm.username}" 
					placeholder="Fill in requested Username" 
					title="inneholde 2-20 tegn, inkludert (���, bindestrek og mellomrom)"/> 
                <%-- OVER:  Kan starte og slutte med s� mange whitespaces du vil (\s*)
                			S�, stor forbokstav fra A-�([A-Z���])
                			S�, valgfri bokstav fra a-�, inkludert bindestrek og mellomrom som er fra 
                			1 til 19 karakterer ([a-z���\-\ ]{1,19} 
                			
                --%>
				<font color="red">${registerForm.usernameMessage}</font> <br />
			
			
			
				<label for="name">Name:</label> 
				<input type="text" 
				name="name" 
				value="${registerForm.name}" 
				placeholder="Fill in name" 
				title="Fornavn skal starte med stor bokstav og inneholde 2-20 tegn, inkludert (��� og bindestrek)."/>  
				<font color="red">${registerForm.nameMessage}</font> <br />
			
			
			
				<label for="email">Email:</label> 
				<input type="text" 
				name="email" 
				value="${registerForm.email}" 
				placeholder="Fill in email" 
				title="email kan starte med stor og liten bokstav og inneholde 2-30 tegn, inkludert (��� og bindestrek)"/>  
				<font color="red">${registerForm.emailMessage}</font> <br />
			
			
			<%--FIKS PASSORD!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! --%>
			
				<label for="password">Password:</label> 
				<input type="password"
				data-demo="svaktPassord"
				name="password" 
				id="passwordId"
				value="${registerForm.password}" 
				placeholder="Fill in password"
				title="et sterkt passord skal best� av minimum 8 tegn, hvorav minst ett tall, 
				ett spesialtegn og en stor bokstav. ������ kan og brukes"/> 
				<font color="red">${registerForm.passwordMessage}</font> <br />
			
			
			
				<label for="repeatedPassword">Passord repetert:</label> 
				<input type="password" 
				name="repeatedPassword"
				id="repeatedPasswordId" 
				value="${registerForm.repeatedPassword}" 
				placeholder="Repeat the password"
				title="et sterkt passord skal best� av minimum 8 tegn, hvorav minst ett tall, 
				ett spesialtegn og en stor bokstav. ������ kan og brukes"/> 
				<font color="red">${registerForm.repeatedPasswordMessage}</font> <br />
			
			
			
				
				<button type="submit" >Meld meg p�</button>
			
			
		</fieldset>
	</form>
</body>
</html>