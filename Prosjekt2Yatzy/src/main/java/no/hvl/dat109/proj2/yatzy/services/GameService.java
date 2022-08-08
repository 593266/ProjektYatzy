package no.hvl.dat109.proj2.yatzy.services;

import java.util.ArrayList;
import java.util.Map;

import no.hvl.dat109.proj2.yatzy.entities.Player;
import no.hvl.dat109.proj2.yatzy.entities.Sentral;

public class GameService {

	DiceService ds;
	PlayerService ps;
	Sentral sentral;

	public GameService() {
		ds = new DiceService();
		ps = new PlayerService();
	}
	
	public Map<String, Player> setup() {
		Map<String, Player> players = ps.namePlayers();
		sentral = new Sentral(players);
//		yatzy.setPlayers(players);
		
		sentral.getPlayers().entrySet().forEach(entry -> {
		    System.out.println("ID: " + entry.getKey() + " " + entry.getValue());
		});

		
		return players;
	}

	// PlayRound method for the first 6 combinations (first all ones, then all two's
	// etc...)
	public void playFirst6Rounds(Map<String, Player> players) {
		int combination = 1; //What number the player needs to roll
		players = sentral.getPlayers();		
//		players.forEach(playFirst6RoundsHelper(players, combination));
		int score = 0;
		int sum = 0;
		String username = "";
		while (combination < 7) {
			for (Map.Entry<String, Player> entry : players.entrySet()) {
				score = play(entry.getValue(), combination) * combination;
				username = entry.getKey();
				players.get(entry.getKey()).getScoreTable().put(combination, score);
				
				checkIfBonus(players, score, username, entry, combination);
				
				System.out.println("player " + username + " got a score of " + score + " on combination: " + combination);
				
			}
			combination++;

			
		}
		

	}
	
	public int play(Player player, int combination) {
		int numberOfDices = 5;
		int score = 0;
		String username = player.getUsername();
		ArrayList<Integer> list = new ArrayList<Integer>();
//		for (int i = 0; i < antallTerninger+1; i++) {
		for (int i = 0; i < 3; i++) {
			list = ds.rollDice(numberOfDices);
			for (int dice : list) {
				if (dice == combination) {
					score++;
					numberOfDices--;
				}
			}
			System.out.println(list);

			
		}
		return score;
	}
	
	//summarize the scores from field 1-6 into field 7(bonus), if it is above or equal to 63,
	//change field 7 to 50, if below 63, change to 0
	public void checkIfBonus(Map<String, Player> players, int score, String username, Map.Entry<String, Player> entry, int combination) {
		
		Integer currentScore = players.get(username).getScoreTable().get(7);
	    int newScore = (null == currentScore)
	            ? score
	            : currentScore + score;
		players.get(entry.getKey()).getScoreTable().put(7, newScore);
		
		if (combination == 6) {
			System.out.println(players.get(username) + " " + players.get(username).getScoreTable().get(7));
			if (players.get(username).getScoreTable().get(7) < 62) {
				players.get(username).getScoreTable().put(7 , 0);
			} else {
				players.get(username).getScoreTable().put(7 , 50);
			}
		}
	}
 	
	

	// All methods to play each iteration of the forced yatzy game

}
