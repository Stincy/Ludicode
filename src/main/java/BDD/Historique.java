package BDD;
import java.sql.*;

//Creation table Historique
public class Historique {

	public static void main( String args[] )
	  {
	    Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      String sql = "CREATE TABLE Historique " +
	                   "(NumHisto    INT NOT NULL," +
	                   " Score       INT NOT NULL," +
	                   " TypeHisto   TEXT NOT NULL," +
	                   " Pseudo      TEXT NOT NULL," +
	                   " NumProbleme INT NOT NULL," +
	                   " CONSTRAINT NumProbleme_fk FOREIGN KEY(NumProbleme) REFERENCES Probleme," +
	                   " CONSTRAINT Pseudo_fk FOREIGN KEY(Pseudo) REFERENCES Utilisateur" +
	                   " PRIMARY KEY (NumHisto, Score))";
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
