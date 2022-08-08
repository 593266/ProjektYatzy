package no.hvl.dat109.proj2.yatzy.services;

import java.util.List;

import no.hvl.dat109.proj2.yatzy.entities.Lobby;
import no.hvl.dat109.proj2.yatzy.entities.Player;
import no.hvl.dat109.proj2.yatzy.entities.Sentral;

public class SentralService {
	List<Lobby> lobbyOverview;
	List<Player> playerOverview;
	Sentral sentral;
	private static int idCount = 0;
	
	public SentralService(Sentral sentral) {
		this.sentral = sentral;
		lobbyOverview = sentral.getLobbyOverview();
		playerOverview = sentral.getPlayerOverview();
		
	}
	
	public void createLobby() {
		int lobbyId = ++idCount;
		Lobby lobby = new Lobby(lobbyId);
		addLobbyToGamesOverview(lobby);
	}
	
	private void addLobbyToGamesOverview(Lobby lobby) {
		lobbyOverview.add(lobby);
	}
	
	public void addPlayerToPlayerOverview(Player player) {
		playerOverview.add(player);
	}

	

}
