package fr.iutinfo;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import fr.iutinfo.App;

@Path("/userdb")
@Produces(MediaType.APPLICATION_JSON)
public class UserDBResource {

	private static UserDao dao = App.dbi.open(UserDao.class);
	
	public UserDBResource() {
		try {
			dao.createUserDataTable();
		} catch (Exception e) {
			System.out.println("Table Utilisateur déjà là !");
		}
		//dao.insertUserData("foo");
	}
	
	@POST
	public UserData createUser(UserData user){
		dao.insertUser(user.getPseudo(), user.getNom(), user.getPrenom(), user.getMdp(), user.getTypeUser());
		return user;
	}
	
	@GET
	@Path("/{pseudo}/{mdp}")
	public UserData verifUserData(@PathParam("pseudo") String pseudo, @PathParam("mdp") String mdp){
		UserData user = dao.verifUser(pseudo, mdp);
		return user;
//		if (user == null){
//			return false;
//		}
//		return true;
	}
}
