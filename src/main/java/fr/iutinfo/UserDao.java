package fr.iutinfo;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface UserDao {

	@SqlUpdate("CREATE TABLE HistoricData " +
	                   "(numHistoric    INT PRIMARY KEY NOT NULL," +
	                   " numProblem INT NOT NULL," +
	                   " typePartie   TEXT NOT NULL," +
	                   " score       INT NOT NULL," +
	                   " pseudo      TEXT NOT NULL," +
	                   " CONSTRAINT NumProbleme_fk FOREIGN KEY(numProblem) REFERENCES ProblemsData," +
	                   " CONSTRAINT Pseudo_fk FOREIGN KEY(pseudo) REFERENCES UserData);")
	void createHistoriqueTable();
	
	@SqlUpdate("CREATE TABLE Play " +
            "(id INT," +
            " pseudo TEXT," +
            " numProblem INT,"+
            " score  INT," + 
            " CONSTRAINT Pseudo_fk FOREIGN KEY(pseudo) REFERENCES UserData," +
            " CONSTRAINT Score_fk  FOREIGN KEY(score) REFERENCES HistoricData," +
            " PRIMARY KEY (id));")
	void createLeaderboardTable();
	
	@SqlUpdate("CREATE TABLE ProblemsData " +
	                   "(numProblem INT PRIMARY KEY  NOT NULL," +
	                   " numHistoric                INT  NOT NULL," +
	                   " enonce                  TEXT NOT NULL," +
	                   " difficulte              INT  NOT NULL," +
	                   " score                   INT  NOT NULL," +
	                   " typePb                  TEXT NOT NULL," +
	                   " taillePb                TEXT," +
	                   " pseudo                  TEXT," +
	                   " CONSTRAINT Pseudo_fk FOREIGN KEY(pseudo) REFERENCES UserData," +
	                   " CONSTRAINT NumHisto_fk FOREIGN KEY(numHistoric) REFERENCES Historic," +
	                   " CONSTRAINT Score_fk FOREIGN KEY(score) REFERENCES UserData)")
	void createProblemeTable();
	
	@SqlUpdate("CREATE TABLE UserData " +
	                   "(id    INT PRIMARY KEY" +
	                   " pseudo              TEXT    NOT NULL," +
	                   " nom                  TEXT    NOT NULL," + 
	                   " prenom               INT     NOT NULL," +
	                   " mdp                  TEXT    NOT NULL," +
	                   " typeUser             TEXT"+
	                   " superviseur          TEXT," +
	                   " CONSTRAINT Pseudo2_fk FOREIGN KEY(Pseudo2) REFERENCES ProblemsData)")
	void createUtilisateurTable();
	
	@SqlUpdate("insert into UserData (id, pseudo, nom, prenom, mdp, typeUser,superviseur) values (:id, :pseudo, :nom, :prenom, :mdp, :typeUser, :superviseur)")
	@GetGeneratedKeys
	int insert(@Bind("id, pseudo, nom, prenom, mdp, typeUser, superviseur") int id, String pseudo, String nom, String prenom, String mdp, String typeUser, String superviseur);
	
	@SqlUpdate("insert into ProblemsData (numProblem, numHistoric, enonce, difficulte, score, typePb, taillePb, pseudo) values (:numProblem, :numHistoric, :enonce, :difficulte, :score, :typePb, :NiveauDiff, :taillePb, :pseudo)")
	@GetGeneratedKeys
	int insert(@Bind("numProblem, numHistoric, enonce, difficulte, typePb, score, taillePb, pseudo") int numProblem, int numHistoric, String enonce, int difficulte, int score, String typePb, String taillePb, String pseudo);
	
	@SqlUpdate("insert into Historic (numHistoric, numProblem, typePartie, score, pseudo) values (:numHistoric, :numProblem, :typePartie, :score, :pseudo)")
	@GetGeneratedKeys
	int insert(@Bind("numHistoric, numProblem, typePartie, score, pseudo") int numHistoric, int numProblem, String typePartie, int score, String pseudo);
	
	@SqlUpdate("insert into Play (id, score, numProblem, pseudo) values (:id, :score, :numProblem, :pseudo)")
	int insert(@Bind("id ,score, numProblem, pseudo") int id, int score, int numProblem, String pseudo);

	int insertUserData(@Bind("Pseudo, Nom, Prenom, Mdp, TypeUser") String Pseudo, String Nom, String Prenom, String Mdp, String TypeUser);
	
	
	@SqlUpdate("insert into Leaderboard (Score, Pseudo) values (:Score, :Pseudo)")
	int insertLeaderboard(@Bind("Score, Pseudo") int Score, String Pseudo);
	
	@SqlUpdate("select * from Utilisateur where Pseudo = :Pseudo and Mdp = :Mdp")
	@RegisterMapperFactory(BeanMapperFactory.class)
	UserData verifUser(@Bind("Pseudo") String Pseudo, @Bind("Mdp") String Mdp);
	

	@SqlQuery("select sum(score) from ProblemsData as p, UserData as a where p.pseudo = a.pseudo;")
	@RegisterMapperFactory(BeanMapperFactory.class)
	int ScoreTotal(@Bind("score") int score);
	
	void close();
}