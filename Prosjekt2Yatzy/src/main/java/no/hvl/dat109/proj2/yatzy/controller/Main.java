package no.hvl.dat109.proj2.yatzy.controller;

import java.util.List;

import jakarta.ejb.EJB;
import no.hvl.dat109.proj2.yatzy.daos.LobbyDAO;
import no.hvl.dat109.proj2.yatzy.daos.PlayerDAO;
import no.hvl.dat109.proj2.yatzy.entities.Lobby;
import no.hvl.dat109.proj2.yatzy.entities.Sentral;

public class Main {
	static Sentral sentral;
	
	@EJB
	private static PlayerDAO pdao;
	private static LobbyDAO ldao;

	public static void main(String[] args) {
		
//		Oppretter sentral (Selve sentralen som har oversikt og styrer alle spill) og lager koblig til sentralService
//		sentral = new Sentral();
//		SentralService yaService = new SentralService(sentral);
		
		//Oppretter en lobby and adds it to gameOverview og lager en kobling til lobbyservice
//		yaService.createLobby();
//		Lobby lobby1 = sentral.getLobbyOverview().get(1);
//		LobbyService lobbyService = new LobbyService(lobby1);
		
		
		//Skriver ut alle lobbyene som eksisterer
//		sentral.getLobbyOverview().entrySet().forEach(entry -> {
//		    System.out.println("ID: " + entry.getKey() + " " + entry.getValue());
//		});
		
		//Oppretter spiller
//		Player player1 = new Player("jBach");
		
		//Skriver ut alle spillere i lobby1
//		lobby1.getPlayerTable().entrySet().forEach(entry -> {
//			System.out.println("ID: " + entry.getKey() + " " + entry.getValue());
//		});
		
		//Player1 joiner Lobby1
//		PlayerService playerService = new PlayerService(player1);
//		playerService.joinLobby(sentral, player1, 1);
//		
//		sentral.getLobbyOverview().entrySet().forEach(entry -> {
//		    System.out.println("ID: " + entry.getKey() + " " + entry.getValue());
//		});
		
		
		
		
		
		
		
		
		//Oppretter terning
//		DiceService ds = new DiceService();
//		ArrayList<Integer> list = ds.getList();

		//Tester terning
//		list = ds.rollDice(5);
//		System.out.println(ds.getList());
		
		//Utskrift metode for HashMap
//		list.entrySet().forEach(entry -> {
//	    System.out.println("ID: " + entry.getKey() + " " + entry.getValue());
//	});
	
		
		//Test av gameService play() metode
//		GameService gs = new GameService();
//		Player player = new Player("Jonas");
//		System.out.println(gs.play(player, 1));
		
		//Opprett spill, og legg til spillere
//		GameService gs = new GameService();
//		Map<String, Player> players = gs.setup();
//		players.entrySet().forEach(entry -> {
//		    System.out.println("ID: " + entry.getKey() + " " + entry.getValue());
//		});
		
		//Spiller de f�rste 6 rundene hvor man f�rst bare skal f� enere, s� toere osv..
//		gs.playFirst6Rounds(players);
//		System.out.println(players.get("jan").getScoreTable().get(7));
//		System.out.println(players.get("bob").getScoreTable().get(7));
//		System.out.println(players.get("frank").getScoreTable().get(7));

		//sjekk om summen av scoren p� de 6 f�rste rundene er st�rre/lik 63, f�r da bonus p� 50 poeng i scoreTable(16)
		
		

		//Populate a new player to the database
//		pdao = new PlayerDAO();
//		List<Player> players = pdao.getAll();
		
		ldao = new LobbyDAO();
		List<Lobby> lobby = ldao.getAll();
		
//		M� KJ�RE DAO MELLOM SERVLET OG S�NN SHIT, TRY IT OUT BROTHA
//		Player player = new Player("JonBac", 1, "Jonas Bach", "Jonasabach@gmail.com");
//		dao.addPlayer(player);
		
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("yatzy");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(player);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        entityManagerFactory.close();
		
		
		

	}
	
	public Sentral getSentral() {
		return sentral;
	}

}
