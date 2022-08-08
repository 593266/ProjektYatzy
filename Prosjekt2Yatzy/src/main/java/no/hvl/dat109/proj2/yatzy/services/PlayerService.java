package no.hvl.dat109.proj2.yatzy.services;

import java.util.Map;

import no.hvl.dat109.proj2.yatzy.entities.Lobby;
import no.hvl.dat109.proj2.yatzy.entities.Player;
import no.hvl.dat109.proj2.yatzy.entities.Sentral;
/**
 * 
 * @author jBach
 * PlayerService tar av seg handlingene som spilleren utf�rer
 */
public class PlayerService {

//	Map<String, Player> players;
	Player player;
	Map<Integer, Integer> scoreTable;
	Sentral sentral;
	Lobby lobby;
	LobbyService lobbyService;

//	public void movePiece(int squares, Player player) {
//		
//		player.setBoardPosition(player.getBoardPosition() + squares);
//	}
	
	public PlayerService(Player player) {
		this.player = player;
		this.scoreTable = player.getScoreTable();
	}
	
	public void joinLobby(Sentral sentral, Player player, int lobbyId) {
		lobby = sentral.getLobbyOverview().get(lobbyId);
		lobbyService = new LobbyService(lobby);
		lobbyService.addPlayerToGame(player);
		player.setLobbyId(lobbyId);
	}

//	public Map<String, Player> namePlayers() {
//
//		players = new HashMap<String, Player>();
//
//		for (int i = 1; i < 7; i++) {
//			Scanner myObj = new Scanner(System.in); // Create a Scanner object
//			System.out.println("Enter username");
//
//			String username = myObj.nextLine();
//			
//			Player p = new Player(username);
//			players.put(p.getUsername(), p);
//			
//			if (username.toLowerCase().equals("avslutt")) {
//				System.out.println("Avslutter programmet");
//				System.exit(0);
//			} else if (username.toLowerCase().equals("spill") ) {
//				i = 7;
//				players.remove(username);
//				System.out.println("Starter spill");
//			} 
			

			
			
			
//
////			Player p = new Player(Scan.sc.nextLine());
////			players.put(p.getUsername(), p);
////			if (players.get(userName).equals("avslutt")) {
////				System.out.println("Avslutter programmet");
////				System.exit(0);
////			} else if (players.get(userName).equals("spill")) {
////				i = 4;
////				players.remove(players.size() - 1);
////				System.out.println("Starter spill");
////			}
//		}
//		return players;
//
//	}

	

}
