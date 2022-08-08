package no.hvl.dat109.proj2.yatzy.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "lobby", schema = "yatzy")
public class Lobby {
	@Id
//	@SequenceGenerator(name = "LobbyId_seq", allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LobbyId_seq")
	int lobbyId;
	
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "lobby")
	List<Player> playerTable; //Username, Player
	
	@OneToOne
	private Sentral sentral;
	
	int playerId;
	
	
	


	public Lobby(int lobbyId, List<Player> playerTable, int playerId) {
		super();
		this.lobbyId = lobbyId;
		this.playerTable = playerTable;
		this.playerId = playerId;
	}

	public Lobby(int lobbyId) {
		this.lobbyId = lobbyId;
		this.playerTable = new ArrayList<>();
	}

	public int getLobbyId() {
		return lobbyId;
	}

	public void setLobbyId(int lobbyId) {
		this.lobbyId = lobbyId;
	}

	public List<Player> getPlayerTable() {
		return playerTable;
	}

	public void setPlayerTable(List<Player> playerTable) {
		this.playerTable = playerTable;
	}

	public Sentral getSentral() {
		return sentral;
	}

	public void setSentral(Sentral sentral) {
		this.sentral = sentral;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}


	
}
