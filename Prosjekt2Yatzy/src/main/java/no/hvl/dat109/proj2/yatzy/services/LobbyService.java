package no.hvl.dat109.proj2.yatzy.services;

import java.util.Map;

import no.hvl.dat109.proj2.yatzy.entities.Lobby;
import no.hvl.dat109.proj2.yatzy.entities.Player;

public class LobbyService {
	Map<String, Player> playerTable; //Username, Player
	Lobby lobby;

	public LobbyService(Lobby lobby) {
		this.lobby = lobby;
		this.playerTable = lobby.getPlayerTable();
	}
	
	public void startGame() {
		
	}
	
	//Bruker av PlayerService
	public void addPlayerToGame(Player player) {
		playerTable.put(player.getUsername(), player);
	}
	
//	public void createPlayerAndAddToGame(HttpServletRequest request) {
//		Player player = new Player(request);
//		playerTable.put(player.getUsername(), player);
//		
//		
//	}

}
