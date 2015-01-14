package BDD;
import java.sql.*;

//Creation table Probleme
public class Probleme {

	public static void main( String args[] )
	  {
	    Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      String sql = "CREATE TABLE Probleme " +
	                   "(NumProbleme INT PRIMARY KEY  NOT NULL," +
	                   " TypePb                  TEXT NOT NULL," + 
	                   " NiveauDiff              INT  NOT NULL," +
	                   " TaillePb                TEXT NOT NULL," +
	                   " Enonce                  TEXT NOT NULL," +
	                   " Score                   INT  NOT NULL," +
	                   " NumHisto                INT  NOT NULL," +
	                   " Pseudo                  TEXT NOT NULL," +
	                   " CONSTRAINT Pseudo_fk FOREIGN KEY(Pseudo) REFERENCES Utilisateur," +
	                   " CONSTRAINT NumHisto_fk FOREIGN KEY(NumHisto) REFERENCES Historique," +
	                   " CONSTRAINT Score_fk FOREIGN KEY(Score) REFERENCES Utilisateur)";
	      stmt.executeUpdate(sql);
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Table created successfully");
	  }
	
}
