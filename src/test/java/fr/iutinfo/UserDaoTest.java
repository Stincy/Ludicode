package fr.iutinfo;

import org.junit.Test;

public class UserDaoTest {
	@Test
	public void testCreate() {
		UserDao dao = App.dbi.open(UserDao.class);
	
		UserData prof = new UserData();
	    prof.setId(1);
	    prof.setPrenom("jojo");
	    prof.setNom("jiji");
	    prof.setPseudo("jijo");
	    prof.setMdp("mdpprof");
	    prof.setTypeUser("professeur");
	    //prof.setSuperviseur(null);
	    //dao.createUserDataTable();
	    dao.insertUser(prof.getPseudo(), prof.getNom(), prof.getPrenom(), prof.getMdp(), prof.getTypeUser());
	    
	    
	    UserData u = new UserData();
	    u.setId(1);
	    u.setPrenom("toto");
	    u.setNom("titi");
	    u.setPseudo("tito");
	    u.setMdp("mdp");
	    u.setTypeUser("eleve");
	    
	    //dao.insertUser(prof.getPseudo(), prof.getNom(), prof.getPrenom(), prof.getMdp(), prof.getTypeUser());
	    //dao.verifUser("jijo", "mdpprof");
	    //dao.createUserDataTable();

	    System.out.println("Terminé");
	   }

}
