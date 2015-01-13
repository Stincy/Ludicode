package BDD;
import java.sql.*;

//Creation Table Utilisateur
public class Utilisateur {

	public static void main( String args[] )
	  {
	    Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      String sql = "CREATE TABLE Utilisateur " +
	                   "(Pseudo1 TEXT PRIMARY KEY     NOT NULL," +
	                   " Nom                  TEXT    NOT NULL," + 
	                   " Prenom               INT     NOT NULL," +
	                   " Mdp                  TEXT    NOT NULL," +
	                   " TypeUser             TEXT    NOT NULL," +
	                   " Pseudo2              TEXT    NOT NULL," +
	                   " CONSTRAINT Pseudo2_fk FOREIGN KEY(Pseudo2) REFERENCES Probleme)";
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
