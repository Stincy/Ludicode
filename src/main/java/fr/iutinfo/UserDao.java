package fr.iutinfo;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface UserDao {

	@SqlUpdate("CREATE TABLE Historique " +
	                   "(NumHisto    INT PRIMARY KEY NOT NULL," +
	                   " Score       INT NOT NULL," +
	                   " TypeHisto   TEXT NOT NULL," +
	                   " Pseudo      TEXT NOT NULL," +
	                   " NumProbleme INT NOT NULL," +
	                   " CONSTRAINT NumProbleme_fk FOREIGN KEY(NumProbleme) REFERENCES Probleme," +
	                   " CONSTRAINT Pseudo_fk FOREIGN KEY(Pseudo) REFERENCES Utilisateur);")
	void createHistoriqueTable();
	
	@SqlUpdate("CREATE TABLE Leaderboard " +
            "(Pseudo TEXT," +
            " Score  INT," + 
            " CONSTRAINT Pseudo_fk FOREIGN KEY(Pseudo) REFERENCES Utilisateur," +
            " CONSTRAINT Score_fk  FOREIGN KEY(Score) REFERENCES Historique," +
            " PRIMARY KEY (Pseudo, Score));")
	void createLeaderboardTable();
	
	@SqlUpdate("CREATE TABLE Probleme " +
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
	                   " CONSTRAINT Score_fk FOREIGN KEY(Score) REFERENCES Utilisateur)")
	void createProblemeTable();
	
	@SqlUpdate("CREATE TABLE Utilisateur " +
	                   "(NumUt    INT PRIMARY KEY" +
	                   " Pseudo1              TEXT    NOT NULL," +
	                   " Nom                  TEXT    NOT NULL," + 
	                   " Prenom               INT     NOT NULL," +
	                   " Mdp                  TEXT    NOT NULL," +
	                   " TypeUser             TEXT    NOT NULL," +
	                   " Pseudo2              TEXT    NOT NULL," +
	                   " CONSTRAINT Pseudo2_fk FOREIGN KEY(Pseudo2) REFERENCES Probleme)")
	void createUtilisateurTable();
	
	@SqlUpdate("insert into Utilisateur (Pseudo, Nom, Prenom, Mdp, TypeUser) values (:Pseudo, :Nom, :Prenom, :Mdp, :TypeUser)")
	@GetGeneratedKeys
	int insert(@Bind("Pseudo, Nom, Prenom, Mdp, TypeUser") String Pseudo, String Nom, String Prenom, String Mdp, String TypeUser);
	
	@SqlUpdate("insert into Probleme (TypePb, NiveauDiff, TaillePb, Enonce, Score, NumHisto, Pseudo) values (:TypePb, :NiveauDiff, :TaillePb, :Enonce, :Score, :NumHisto, :Pseudo)")
	@GetGeneratedKeys
	int insert(@Bind("TypePb, NiveauDiff, TaillePb, Enonce, Score, NumHisto, Pseudo") String TypePb, String NiveauDiff, String TaillePb, String Enonce, int Score, int NumHisto, String Pseudo);
	
	@SqlUpdate("insert into Historique (Score, TypeHisto, Pseudo, NumProbleme) values (:Score, :TypeHisto, :Pseudo, :NumProbleme)")
	@GetGeneratedKeys
	int insert(@Bind("Score, TypeHisto, Pseudo, NumProbleme") int Score, String TypeHisto, String Pseudo, int NumProbleme);
	
	@SqlUpdate("insert into Leaderboard (Score, Pseudo) values (:Score, :Pseudo)")
	int insert(@Bind("Score, Pseudo") int Score, String Pseudo);
	
	@SqlQuery("select sum(Score) from Probleme as p, Utilisateur as a where p.Pseudo = a.Pseudo;")
	@RegisterMapperFactory(BeanMapperFactory.class)
	int ScoreTotal(@Bind("Score") int Score);
	
	void close();
}
