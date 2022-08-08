package no.hvl.dat109.proj2.yatzy.daos;

import java.util.List;

import entities.Player;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;	

@Stateless
public class PlayerDAO {
//	@PersistenceContext()
//	private EntityManager em; 
//	
//	@PersistenceUnit
//	private EntityManagerFactory emf;
	
	
	
//	@PersistenceContext(name = "yatzy")
//	private EntityManager em; 
//	private EntityManagerFactory emf;
	
	@PersistenceContext(name = "yatzy")
	private EntityManager em; 
	public PlayerDAO() {
		
	}

//	public PlayerDAO() {
//		emf = Persistence.createEntityManagerFactory("yatzy");
//
//	}
	Player player1 = null;
	
	public void addPlayer(Player player) {
		em.persist(player);
	}
	
	public List<Player> getAll(){
		return em.createQuery("select p from Player p", Player.class).getResultList();
	}
	
	public Player createPlayer(Player player) {
		
//		  EntityManager em = emf.createEntityManager();
	         EntityTransaction tx = em.getTransaction();
	         
//	         AnsattDAO ansattDAO = new AnsattDAO();
//	         Avdeling avdeling = null;
//	         Ansatt nySjef = null;
	         
//	         Player player1 = player;
	         try {
	             tx.begin();
	             
	             player1 = new Player();
	             player1.setEmail(player.getEmail());
	             player1.setLobbyId(0);
	             player1.setName(player.getName());
	             player1.setUsername(player.getUsername());
	             em.persist(player1);
	             
	             //Legg til ansatt i playerOverview
	                         
	             tx.commit();

	         } catch (Throwable e) {
	             e.printStackTrace();
	             if (tx.isActive()) {
	                 tx.rollback();
	             }
	         } finally {
	             em.close();
	         }
	         return player1;
	     }
	
	
	
//	public List<Player> getAll(){
//		return em.createQuery("select p from Player p", Player.class).getResultList();
//	}
	
	public List<Player> getAllSorted(){
		return em.createQuery("select p from Player p, sorted by brukernavn", Player.class).getResultList();
	}
	
	public void add(Player p) {
		em.persist(p);
	}
	
	public boolean playerExists(String username) {
		try {
			if(em.find(Player.class, username).equals(null))	{
				return false;
			}
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
//	public String password(String username) {
//		return em.find(Player.class, username).getPasswordhash();
//	
//	}


}
