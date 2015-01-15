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

@Path("/level")
@Produces(MediaType.APPLICATION_JSON)
public class LevelResource {
	@GET
	public String getLevel() {
		return "test";
	}
	
	@GET
	@Path("/{levelid}")
	public List<UserData> getLevel(@PathParam("levelid") int id ) {
		
		return new ArrayList<UserData>();
	}
}