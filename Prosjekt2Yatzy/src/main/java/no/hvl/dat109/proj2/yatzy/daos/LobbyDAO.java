package no.hvl.dat109.proj2.yatzy.daos;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import no.hvl.dat109.proj2.yatzy.entities.Lobby;

@Stateless
public class LobbyDAO {
	
	
	@PersistenceContext(name = "yatzy")
	private EntityManager em; 
	public LobbyDAO() {
		
	}
	
//	public void addPlayer(Player player) {
//		em.persist(player);
//	}
//	
	public List<Lobby> getAll(){
		return em.createQuery("select p from Lobby p", Lobby.class).getResultList();
	}

}
