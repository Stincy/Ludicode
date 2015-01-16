package fr.iutinfo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HistoryDaoTest {
HistoryDao dao = App.dbi.open(HistoryDao.class);
	
	@Test
	public void testCreateHistoric() {
	
	    dao.dropHistoryTable();
	    
	    dao.createHistoryTable();
	    
	    dao.insertHistory(12, "roro", 250);
	    
	    dao.insertHistory(2,"riri",500);
	    
	    dao.insertHistory(13, "roro", 100);

	    System.out.println("Terminé historique etape 1");
	   }
	
	@Test
	public void testVerifHistoric(){
		dao.dropHistoryTable();
	    dao.createHistoryTable();
	    dao.insertHistory(12, "roro", 250);
		dao.verifHistoric("roro");
		System.out.println("Terminé historique etape 2");
	}
	
	@Test
	public void testSommeHistoric(){
		dao.dropHistoryTable();
	    dao.createHistoryTable();
	    dao.insertHistory(12, "roro", 250);
	    dao.insertHistory(13, "roro", 100);
		Score a=dao.ScoreTotalHisto("roro");
		assertEquals(a.getValue(),350);
		System.out.println("Terminé historique etape 3");
	}
	
	@Test
	public void testDropHistoric(){
		dao.dropHistoryTable();
		System.out.println("Terminé historique etape 4");
	}
}
