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


public class LevelTest extends JerseyTest {
	LevelDao dao = App.dbi.open(LevelDao.class);
	
	@Override
    protected Application configure() {
        return new App();
    }
	
	@Test
	public void testLevel() {
		 dao.dropUserTable();
		 dao.createLevelTable();
		 dao.insert(4242, 13, "info", "tiles", "commands");
		 Level lvl = dao.findByDifficulty(4242);
		 assertEquals(4242, lvl.getDifficulty());
		 assertEquals(13, lvl.getNbCommands());
		 assertEquals("info", lvl.getInformation());
		 assertEquals("tiles", lvl.getTiles());
		 assertEquals("commands", lvl.getCommands());
	}
	
	@Test
	public void testLevelCreation() {
		String json = target("/level/1").request().get(String.class);
		assertEquals("{\"commands\":\"0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0\",\"difficulty\":1,\"information\":\"Déplacer le rond rouge jusqu'au carré jaune\",\"nbCommands\":10,\"tiles\":\"0,0,0,0|2,3,0,0|0,0,0,0|0,0,0,0\"}", json);
	}
}