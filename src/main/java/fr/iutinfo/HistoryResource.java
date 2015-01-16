package fr.iutinfo;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import fr.iutinfo.App;

@Path("/historydb")
@Produces(MediaType.APPLICATION_JSON)
public class HistoryResource {

	private static HistoryDao dao = App.dbi.open(HistoryDao.class);
	
	public HistoryResource(){
		try {
			dao.createHistoryTable();
		} catch (Exception e) {
			System.out.println("Table History déjà là !");
		}
	}
	
	@POST
	public HistoricData createHistory(HistoricData histo){
		dao.insertHistory(histo.getIdlvl(), histo.getPseudo(), histo.getScore());
		return histo;
	}
	
	@GET
	@Path("/{pseudo}")
	public HistoricData verifHistoric(@PathParam("pseudo") String pseudo){
		return new HistoricData();
	}
	
}
