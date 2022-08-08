package no.hvl.dat109.proj2.yatzy.services;

import jakarta.servlet.http.HttpServletRequest;

public class RegisterForm {

	private String username;
	private String usernameMessage;
	
	private String password;
	private String passwordMessage;
	
	private String name;
	private String nameMessage;
	
	private String email;
	private String emailMessage;
	
	private String repeatedPassword;
	private String repeatedPasswordMessage;
	
	private boolean isAllInputGyldig;
	private String loginErrorMessage;
	
//	CONNECT MED PLAYERFORM? LAGRE VIDERE
	
	public RegisterForm(HttpServletRequest request) {
		this.username = request.getParameter("username");
		this.name = request.getParameter("name");
		this.password = request.getParameter("password");
		this.repeatedPassword = request.getParameter("repeatedPassword");
		this.email = request.getParameter("email");

	}
	
	public void generateUser() {
		
	}
	
	public boolean isAllInputGyldig() {
		return isUsernameValid() && isNameValid() && isPasswordValid() && isRepeatedPasswordValid() 
				&& isEmailValid();
	}

	public boolean isAllLogginnGyldig() {
		return isUsernameValid() && isPasswordValid();
	}
	
	private boolean isUsernameValid() {
		return username.equals("jBach");
	}
	
	private boolean isNameValid() {
		return name.equals("Jonas Bach");
	}
	
	private boolean isPasswordValid() {
		return password.equals("pass");
	}
	
	private boolean isRepeatedPasswordValid() {
		return repeatedPassword.equals(password);
	}
	
	private boolean isEmailValid() {
		return email.equals("jonasabach@gmail.com");
	}
	
		

	public void setupErrorMessage() {
		
		if (!isPasswordValid()) {
			clearPassord();
			passwordMessage = "Invalid password!";
		}
		if (!isRepeatedPasswordValid()) {
			clearPassord();
			repeatedPasswordMessage = "Passordene m� v�re like!";
		}
		if (!isNameValid()) {
			name = "";
			clearPassord();
			nameMessage = "Ugyldig fornavn!";
		}
		if (!isUsernameValid()) {
			username = "";
			clearPassord();
			usernameMessage = "Ugyldig etternavn!";
		}

		if (!isEmailValid()) {
			email = "";
			clearPassord();
			emailMessage = "ugyldig email";
		}

	}
	
	public void clearPassord() {
		repeatedPassword = "";
		password = "";
	}
	
	public void setupLoginMessages() {
		if (!isAllLogginnGyldig()) {
			password = "";
			loginErrorMessage = "Ugyldig brukernavn og/eller passord";
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsernameMessage() {
		return usernameMessage;
	}

	public void setUsernameMessage(String usernameMessage) {
		this.usernameMessage = usernameMessage;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordMessage() {
		return passwordMessage;
	}

	public void setPasswordMessage(String passwordMessage) {
		this.passwordMessage = passwordMessage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameMessage() {
		return nameMessage;
	}

	public void setNameMessage(String nameMessage) {
		this.nameMessage = nameMessage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailMessage() {
		return emailMessage;
	}

	public void setEmailMessage(String emailMessage) {
		this.emailMessage = emailMessage;
	}

	public String getRepeatedPassword() {
		return repeatedPassword;
	}

	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}

	public String getRepeatedPasswordMessage() {
		return repeatedPasswordMessage;
	}

	public void setRepeatedPasswordMessage(String repeatedPasswordMessage) {
		this.repeatedPasswordMessage = repeatedPasswordMessage;
	}

	public String getLoginErrorMessage() {
		return loginErrorMessage;
	}

	public void setLoginErrorMessage(String loginErrorMessage) {
		this.loginErrorMessage = loginErrorMessage;
	}

	public void setAllInputGyldig(boolean isAllInputGyldig) {
		this.isAllInputGyldig = isAllInputGyldig;
	}
	
	
}
