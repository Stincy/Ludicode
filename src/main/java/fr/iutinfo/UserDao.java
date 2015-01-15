package fr.iutinfo;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface UserDao {

	@SqlUpdate("CREATE TABLE Historique " +
	                   "(NumHisto    INT PRIMARY KEY AUTOINCREMENT," +
	                   " Score       INT NOT NULL," +
	                   " Pseudo      TEXT NOT NULL," +
	                   " Numlevel    INT NOT NULL," +
	                   " CONSTRAINT Numlevel_fk FOREIGN KEY(id) REFERENCES levels," +
	                   " CONSTRAINT NumUt_fk FOREIGN KEY(NumUt) REFERENCES Utilisateur);")
	void createHistoriqueTable();
	
	@SqlUpdate("CREATE TABLE Leaderboard " +
            "(NumUt  INT," +
            " Score  INT," + 
            " CONSTRAINT NumUt_fk FOREIGN KEY(NumUt) REFERENCES Utilisateur," +
            " CONSTRAINT Score_fk  FOREIGN KEY(Score) REFERENCES Historique," +
            " PRIMARY KEY (Pseudo, Score));")
	void createLeaderboardTable();
	
	
	@SqlUpdate("CREATE TABLE Utilisateur " +
	                   "(NumUt    INT PRIMARY KEY AUTOINCREMENT" +
	                   " Pseudo1              TEXT    NOT NULL," +
	                   " Nom                  TEXT    NOT NULL," + 
	                   " Prenom               INT     NOT NULL," +
	                   " Mdp                  TEXT    NOT NULL," +
	                   " TypeUser             TEXT    NOT NULL," +
	                   " Pseudo2              TEXT    NOT NULL," +
	                   " CONSTRAINT Pseudo2_fk FOREIGN KEY(Pseudo2) REFERENCES levels)")
	void createUtilisateurTable();
	
	@SqlUpdate("insert into Utilisateur (Pseudo, Nom, Prenom, Mdp, TypeUser) values (:Pseudo, :Nom, :Prenom, :Mdp, :TypeUser)")
	@GetGeneratedKeys
	int insertUserData(@Bind("Pseudo, Nom, Prenom, Mdp, TypeUser") String Pseudo, String Nom, String Prenom, String Mdp, String TypeUser);
	
	
	@SqlUpdate("insert into Leaderboard (Score, Pseudo) values (:Score, :Pseudo)")
	int insertLeaderboard(@Bind("Score, Pseudo") int Score, String Pseudo);
	
	@SqlUpdate("select * from Utilisateur where Pseudo = :Pseudo and Mdp = :Mdp")
	@RegisterMapperFactory(BeanMapperFactory.class)
	UserData verifUser(@Bind("Pseudo") String Pseudo, @Bind("Mdp") String Mdp);
	
	@SqlQuery("select sum(Score) from Historique as h, Utilisateur as a where h.NumUt = a.NumUt;")
	@RegisterMapperFactory(BeanMapperFactory.class)
	int ScoreTotal(@Bind("Score") int Score);
	
	void close();
}
