package no.hvl.dat109.proj2.yatzy.daos;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import no.hvl.dat109.proj2.yatzy.entities.Lobby;
import no.hvl.dat109.proj2.yatzy.entities.Player;

@Stateless
public class SentralDAO {
	
	@PersistenceContext(name = "yatzy")
	private EntityManager em; 
	public SentralDAO() {
		
	}
	
	public List<Player> getPlayerOverview(){
		return em.createQuery("select p from playerOverview p", Player.class).getResultList();
	}

}
