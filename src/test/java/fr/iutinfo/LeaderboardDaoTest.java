package fr.iutinfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import BDD.Level;

public class LeaderboardDaoTest {
LeaderboardDao dao = App.dbi.open(LeaderboardDao.class);

	@Test
	public void testCreateLeaderboard() {
	
	    dao.dropLeaderboardTable();
	  
	    dao.createLeaderboardTable();
	   
	    
	    dao.insertLeaderboard("jojo",500);
	    dao.insertLeaderboard("lulu",20);

	    System.out.println("Terminé historique etape 1");
	   }
	
	@Test
	public void testListingLeaderboard(){
		dao.dropLeaderboardTable();
	    dao.createLeaderboardTable();
	    dao.insertLeaderboard("jojo",500);
	    dao.insertLeaderboard("lulu",20);
	    Leaderboard l=dao.listingBoard();
	    l.afficher();
		System.out.println("Terminé historique etape 2");
	}
	
	@Test 
	public void testDropLeaderboard(){
		dao.dropLeaderboardTable();
		System.out.println("Terminé historique etape 3");
	}
	
}
