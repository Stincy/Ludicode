package fr.iutinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import BDD.Level;

@Path("/level")
@Produces(MediaType.APPLICATION_JSON)
public class LevelResource {
	private static LevelDao dao = App.dbi.open(LevelDao.class);
	
	public LevelResource() {
		try {
			dao.createLevelTable();
		} catch (Exception e) {
			System.out.println("Table déjà là !");
		}
		dao.insert("Test level", 1, "Rejoindre le carré jaune en deplacant le rond rouge", "dsfds");
	}
	
	@GET
	public String getLevel() {
		return "test";
	}
	
	@GET
	@Path("/{levelid}")
	public Level getLevel(@PathParam("levelid") int id ) {
		Level lvl = dao.findByDifficulty(id);
		if (lvl == null) {
			throw new WebApplicationException(404);
		}
		return lvl;
	}
}