package fr.iutinfo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserDaoTest {
	UserDao dao = App.dbi.open(UserDao.class);
	
	@Test
	public void testUserData() {
	
		UserData prof = new UserData();
	    prof.setPrenom("jojo");
	    prof.setNom("jiji");
	    prof.setPseudo("jijo");
	    prof.setMdp("mdpprof");
	    prof.setTypeUser("professeur");
	    dao.dropUserTable();
	    dao.createUserDataTable();
	    dao.insertUser(prof.getPseudo(), prof.getNom(), prof.getPrenom(), prof.getMdp(), prof.getTypeUser());
	    
	    
	    UserData u = new UserData();
	    u.setPrenom("toto");
	    u.setNom("titi");
	    u.setPseudo("tito");
	    u.setMdp("mdp");
	    u.setTypeUser("eleve");
	    dao.insertUser(u.getPseudo(), u.getNom(), u.getPrenom(), u.getMdp(), u.getTypeUser());
	    
	    //dao.createUserDataTable();

	    System.out.println("Terminé");
	   }
	
	@Test
	public void testVerif(){
		dao.dropUserTable();
	    dao.createUserDataTable();
	    
		UserData prof = new UserData();
	    prof.setPrenom("jojo");
	    prof.setNom("jiji");
	    prof.setPseudo("jijo");
	    prof.setMdp("mdpprof");
	    prof.setTypeUser("professeur");
	    dao.dropUserTable();
	    dao.createUserDataTable();
	    dao.insertUser(prof.getPseudo(), prof.getNom(), prof.getPrenom(), prof.getMdp(), prof.getTypeUser());
		
		dao.verifUser("jijo", "mdpprof");
		System.out.println("Terminé 2");
	}

}
