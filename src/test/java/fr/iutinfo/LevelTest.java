package fr.iutinfo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

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
	public void testLevelDB() {
		 dao.dropLevelTable();
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
	public void testLevelDBMultiple() {
		/*
		 dao.dropLevelTable();
		 dao.createLevelTable();
		 createLevel(4242, 13, "info", "tiles", "commands");
		 createLevel(4242, 13, "info", "tiles", "commands");
		 List<Level> lvls = dao.findAll();
		 assertEquals(2, lvls.size());*/
	}
	
	@Test
	public void testLevelGetter() {
		String json = target("/level/1").request().get(String.class);
		assertEquals("{\"commands\":\"0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0\",\"difficulty\":1,\"information\":\"Déplacer le rond rouge jusqu'au carré jaune\",\"nbCommands\":10,\"tiles\":\"0,0,0,0|2,3,0,0|0,0,0,0|0,0,0,0\"}", json);
	}
	
	private Level createLevel(int difficulty, int nbCommands, String info, String tiles, String commands) {
		Level level = new Level();
		level.setDifficulty(difficulty);
		level.setNbCommands(nbCommands);
		level.setInformation(info);
		level.setTiles(tiles);
		level.setCommands(commands);
	    Entity<Level> userEntity = Entity.entity(level, MediaType.APPLICATION_JSON);
		Level savedLevel = target("/level").request().post(userEntity).readEntity(Level.class);
		return savedLevel;
	}
}