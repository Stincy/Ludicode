package BDD;
import java.sql.*;

//Creation table Leaderboard
public class Leaderboard {

	public static void main( String args[] )
	  {
	    Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      String sql = "CREATE TABLE Leaderboard " +
	                   "(Pseudo TEXT," +
	                   " Score  INT," + 
	                   " CONSTRAINT Pseudo_fk FOREIGN KEY(Pseudo) REFERENCES Utilisateur," +
	                   " CONSTRAINT Score_fk  FOREIGN KEY(Score) REFERENCES Historique," +
	                   " PRIMARY KEY (Pseudo, Score))"; 
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
