package no.hvl.dat109.proj2.yatzy.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.servlet.http.HttpServletRequest;

@Entity
@Table(name = "player", schema = "yatzy")
public class Player {
	
	@Id
	private int playerId;
	private String username;
	private String password; //hash
	private String name;
	private String email;
	private int lobbyId;
	private int warnings;
	List<Integer> scoreCard; //Combination Id, score for given combination
	
	@ManyToOne
	private Lobby lobby;
	
	public Player() {}
	
	
	
	
	public Player(int playerId, String username, String password, String name, String email, int lobbyId,
			int warnings, List<Integer> scoreCard) {
		this.playerId = playerId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.lobbyId = 0;
		this.warnings = 0;
		this.scoreCard = new ArrayList<>();
	}




//	//Midlertidig for testing
//	public Player(String username) {
//		this.username = username;
//		this.scoreCard = new ArrayList<Integer>();
//		scoreCard.add(1, 0); //Enere
//		scoreCard.add(2, 0); //Toere
//		scoreCard.add(3, 0); //Treere
//		scoreCard.add(4, 0); //Firere
//		scoreCard.add(5, 0); //Femere
//		scoreCard.add(6, 0); //Seksere
//		scoreCard.add(7, 0); //Bonus
//		scoreCard.add(8, 0); //Ett par
//		scoreCard.add(9, 0); //To par
//		scoreCard.add(10, 0); //Tre like
//		scoreCard.add(11, 0); //Fire like
//		scoreCard.add(12, 0); //liten straight
//		scoreCard.add(13, 0); //stor straight
//		scoreCard.add(14, 0); //hus
//		scoreCard.add(15, 0); //sjanse
//		scoreCard.add(16, 0); //yatzy
//			}
	
	
	public Player(HttpServletRequest request) {
		this.username = request.getParameter("username");
//		this.passwordhash = PasswordUtil.hashWithSalt(password, PasswordUtil.generateRandomSalt());
		this.password = request.getParameter("password");
		this.name = request.getParameter("name");
		this.email = request.getParameter("email");
		
//		this.scoreCard = new ArrayList<>();
//		scoreCard.add(1, 0); //Enere
//		scoreCard.add(2, 0); //Toere
//		scoreCard.add(3, 0); //Treere
//		scoreCard.add(4, 0); //Firere
//		scoreCard.add(5, 0); //Femere
//		scoreCard.add(6, 0); //Seksere
//		scoreCard.add(7, 0); //Bonus
//		scoreCard.add(8, 0); //Ett par
//		scoreCard.add(9, 0); //To par
//		scoreCard.add(10, 0); //Tre like
//		scoreCard.add(11, 0); //Fire like
//		scoreCard.add(12, 0); //liten straight
//		scoreCard.add(13, 0); //stor straight
//		scoreCard.add(14, 0); //hus
//		scoreCard.add(15, 0); //sjanse
//		scoreCard.add(16, 0); //yatzy
		

		
	}



	public int getPlayerId() {
		return playerId;
	}



	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getLobbyId() {
		return lobbyId;
	}



	public void setLobbyId(int lobbyId) {
		this.lobbyId = lobbyId;
	}



	public int getWarnings() {
		return warnings;
	}



	public void setWarnings(int warnings) {
		this.warnings = warnings;
	}



	public List<Integer> getScoreCard() {
		return scoreCard;
	}



	public void setScoreCard(List<Integer> scoreCard) {
		this.scoreCard = scoreCard;
	}



	public Lobby getLobby() {
		return lobby;
	}



	public void setLobby(Lobby lobby) {
		this.lobby = lobby;
	}
	
	



	
	
	
	
	
	
	

}
