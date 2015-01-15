package BDD;

import java.io.File;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.sqlite.SQLiteConfig;

public class Database {

	private static Connection db;
	private static final String file = "database.db";


	public static Connection getConnection() throws Exception {
		try {
			if (db == null || db.isClosed()) {
				File dir = new File(file);
				boolean freshlyCreated = !dir.exists();
				
				Class.forName("org.sqlite.JDBC");
				SQLiteConfig config = new SQLiteConfig();
				config.enforceForeignKeys(true);
				db = DriverManager.getConnection("jdbc:sqlite:data/blender.db", config.toProperties());
				if (freshlyCreated) initDb();
			}
		} catch (ClassNotFoundException e) {
			throw new Exception("Le driver de base de donnees est introuvable");
		} catch (SQLException e) {
			throw new Exception("La connexion a la base de donnees a echoue");
		}

		return db;
	}

	public static void closeConnection() {
		try {
			db.close();
		} catch (SQLException e) {}
	}


	/*public static void initDb() throws Exception {
		Connection c = getConnection();
	    Statement stmt = null;
	    try {

	      stmt = c.createStatement();
	      String sql = "CREATE TABLE Historique " +
	                   "(NumHisto    INT PRIMARY KEY NOT NULL," +
	                   " Score       INT NOT NULL," +
	                   " TypeHisto   TEXT NOT NULL," +
	                   " Pseudo      TEXT NOT NULL," +
	                   " NumProbleme INT NOT NULL," +
	                   " CONSTRAINT NumProbleme_fk FOREIGN KEY(NumProbleme) REFERENCES Probleme," +
	                   " CONSTRAINT Pseudo_fk FOREIGN KEY(Pseudo) REFERENCES Utilisateur)";
	      stmt.executeUpdate(sql);
	      
	      stmt = c.createStatement();
	      sql = "CREATE TABLE Leaderboard " +
	                   "(Pseudo TEXT," +
	                   " Score  INT," + 
	                   " CONSTRAINT Pseudo_fk FOREIGN KEY(Pseudo) REFERENCES Utilisateur," +
	                   " CONSTRAINT Score_fk  FOREIGN KEY(Score) REFERENCES Historique," +
	                   " PRIMARY KEY (Pseudo, Score))"; 
	      stmt.executeUpdate(sql);
	      
	      stmt = c.createStatement();
	      sql = "CREATE TABLE Probleme " +
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
	      
	      stmt = c.createStatement();
	      sql = "CREATE TABLE Utilisateur " +
	                   "(NumUt    INT PRIMARY KEY" +
	                   " Pseudo1              TEXT    NOT NULL," +
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
	    }
	}*/
}