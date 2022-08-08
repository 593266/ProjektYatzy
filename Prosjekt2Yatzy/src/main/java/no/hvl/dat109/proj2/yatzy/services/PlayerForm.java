package no.hvl.dat109.proj2.yatzy.services;


import jakarta.servlet.http.HttpServletRequest;
import no.hvl.dat109.proj2.yatzy.daos.PlayerDAO;
import no.hvl.dat109.proj2.yatzy.entities.Player;
/**
 * 
 * @author jBach
 * PlayerForm har ansvar for � opprette Player basert p� informasjonen som blir tastet inn n�r spilleren registrerer seg
 */
public class PlayerForm {
	
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

	


	public Player createPlayerFromForm() {
//		String passwordhash = "fake verdi"; // passwordUtil.krypterpassword(password);
		return new Player(username, name, email);
	}

	public void populateFromRequestAndSetUpErrors(
	        HttpServletRequest request, PlayerDAO playerDao) {
		populateFromRequest(request);
		setUpErrorMessages(playerDao);
	}

//	public PlayerForm(HttpServletRequest request) {
//		username = request.getParameter("username");
//		password = request.getParameter("password");
//		name = request.getParameter("name");
//		email = request.getParameter("email");
//		repeatedPassword = request.getParameter("repeatedPassword");
//
//	}
	
	private void populateFromRequest(HttpServletRequest request) {
		username = request.getParameter("username");
		password = request.getParameter("password");
		name = request.getParameter("name");
		email = request.getParameter("email");
		repeatedPassword = request.getParameter("repeatedPassword");

	}

	public void setUpErrorMessages(PlayerDAO playerDao) {
		
		boolean usernameOk = MyValidator.isValidEmail(username);
		if (!usernameOk) {
			clearPassword();
			usernameMessage = "Invalid username";
		}

		
		boolean passwordOk = MyValidator.isValidPassword(password);
		if (!passwordOk) {
			clearPassword(); //Kanskje password burde vært blanket ut uansett?!
			passwordMessage = "Invalid password";
		}
		
		boolean passwordRepOk = passwordOk && password.equals(repeatedPassword);
		if (!passwordRepOk) {
			clearPassword(); //Kanskje password burde vært blanket ut uansett?!
			repeatedPassword = "passwordene m� v�re like!";
		}
		
		boolean nameOk = MyValidator.isValidName(name);
		if (!nameOk) {
			name = "";
			clearPassword();
			nameMessage = "Invalid fornavn";
		}

		boolean emailOk = MyValidator.isValidEmail(email);
		boolean signedUp = playerDao.playerExists(username);
		if (!emailOk) {
			email = "";
			clearPassword();
			emailMessage = "Invalid email";
		} else if (signedUp) {
			email = "";
			emailMessage = "Bruker allerede p�meldt";
		}
		

		isAllInputGyldig = usernameOk && nameOk&& emailOk && !signedUp 
				&& passwordOk && passwordRepOk;
	}
	
	
	
	public boolean isAllLogginnGyldig() {
		boolean usernameOk = MyValidator.isValidUsername(username);
		boolean passwordOk = MyValidator.isValidPassword(password);

		return passwordOk && usernameOk;
	}
	
	public void clearPassword() {
		repeatedPassword = "";
		password = "";
	}
	
	public void SetUpLoginErrorMessage() {
		if (!isAllLogginnGyldig()) {
			email = "";
			password = "";
			loginErrorMessage = "Invalid username and/or password";
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

	public boolean isAllInputGyldig() {
		return isAllInputGyldig;
	}

	public void setAllInputGyldig(boolean isAllInputGyldig) {
		this.isAllInputGyldig = isAllInputGyldig;
	}

	public String getLoginErrorMessage() {
		return loginErrorMessage;
	}

	public void setLoginErrorMessage(String loginErrorMessage) {
		this.loginErrorMessage = loginErrorMessage;
	}
	
	


	

}
