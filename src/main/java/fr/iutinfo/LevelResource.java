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
			dao.dropUserTable();
			dao.createLevelTable();
		} catch (Exception e) {}
		dao.insert(1, 10, "Déplacer le rond rouge jusqu'au carré jaune", "0,0,0,0|2,3,0,0|0,0,0,0|0,0,0,0", "0,1,0,0,0,0,0,0,0,0,0,0");
		dao.insert(2, 10, "Déplacer le rond rouge jusqu'au carré jaune", "0,0,0,0|2,0,0,3|0,0,0,0|0,0,0,0", "0,1,0,0,0,0,0,0,0,0,0,0");
		dao.insert(3, 10, "Déplacer le rond rouge jusqu'au carré jaune", "0,0,0,0|0,2,0,0|0,0,3,0|0,0,0,0", "1,1,1,1,0,0,0,0,0,0,0,0");
		dao.insert(4, 10, "Déplacer le rond rouge jusqu'au carré jaune et evité les murs en noir", "0,0,0,0|0,2,0,0|0,1,0,0|0,3,0,0", "1,1,1,1,0,0,0,0,0,0,0,0");
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