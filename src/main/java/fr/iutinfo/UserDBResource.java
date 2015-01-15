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
			dao.createUtilisateurTable();
		} catch (Exception e) {
			System.out.println("Table Utilisateur déjà là !");
		}
		try {
			dao.createHistoriqueTable();
		} catch (Exception e) {
			System.out.println("Table Historique déjà là !");
		}
		try {
			dao.createLeaderboardTable();
		} catch (Exception e) {
			System.out.println("Table Leaderboard déjà là !");
		}
		try {
			//dao.createProblemeTable();
		} catch (Exception e) {
			System.out.println("Table Probleme déjà là !");
		}
		//dao.insert("foo");
	}
	
	@POST
	public UserData createUtilisateur(UserData user){
		int id = dao.insertUserData(user.getPseudo(), user.getNom(), user.getPrenom(), user.getMdp(), user.getTypeUser());
		//user.setID(id);
		return user;
	}
	
	
}
