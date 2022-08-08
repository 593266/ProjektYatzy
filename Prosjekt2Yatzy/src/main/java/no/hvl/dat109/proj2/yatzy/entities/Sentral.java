package no.hvl.dat109.proj2.yatzy.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
/**
 * 
 * @author jBach
 *	A class that keeps a hashmap over all the games that are active. Each game will have an unique Integer ID, 
 *	with the Lobby as value. The lobby/lobbyService class contains players
 */
@Entity
@Table(name = "sentral", schema = "yatzy")
public class Sentral {
//	List<Player> players;
	@Id
	@SequenceGenerator(name = "SentralId_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SentralId_seq")
	private int sentralId;
	
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "sentral")
	List<Lobby> lobbyOverview;
	List<Player> playerOverview;
//	Map<Integer, Lobby> lobbyOverview;
//	Map<String, Player> playerOverview;
	
	public Sentral(int sentralId, List<Lobby> lobbyOverview, List<Player> playerOverview) {
		this.sentralId = sentralId;
		this.lobbyOverview = lobbyOverview;
		this.playerOverview = playerOverview;
	}

	public int getSentralId() {
		return sentralId;
	}

	public void setSentralId(int sentralId) {
		this.sentralId = sentralId;
	}

	public List<Lobby> getLobbyOverview() {
		return lobbyOverview;
	}

	public void setLobbyOverview(List<Lobby> lobbyOverview) {
		this.lobbyOverview = lobbyOverview;
	}

	public List<Player> getPlayerOverview() {
		return playerOverview;
	}

	public void setPlayerOverview(List<Player> playerOverview) {
		this.playerOverview = playerOverview;
	}
	
	
	

	
	




	
	
	

}
