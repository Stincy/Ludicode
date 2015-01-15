package fr.iutinfo;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface UserDao {


	@SqlUpdate("CREATE TABLE History " +
	                   "(idhisto    INT PRIMARY KEY AUTOINCREMENT," +
	                   " score      INT NOT NULL," +
	                   " pseudo     TEXT NOT NULL," +
	                   " idlvl      INT NOT NULL," +
	                   " CONSTRAINT idlvl_fk FOREIGN KEY(idlvl) REFERENCES levels," +
	                   " CONSTRAINT iduser_fk FOREIGN KEY(iduser) REFERENCES UserData);")
	void createHistoryTable();
	
	
	@SqlUpdate("CREATE TABLE Play " +
            "(idplay INT AUTOINCREMENT," +
            " pseudo TEXT," +
            " idhisto INT,"+
            " score  INT," + 
            " CONSTRAINT iduser_fk FOREIGN KEY(iduser) REFERENCES UserData," +
            " CONSTRAINT score_fk  FOREIGN KEY(score) REFERENCES History," +
            " PRIMARY KEY (iduser, score));")
	void createPlayTable();


	@SqlUpdate("CREATE TABLE UserData (id integer primary key autoincrement, pseudo TEXT, nom TEXT, prenom TEXT, mdp TEXT, typeUser TEXT)") /*+
	                   "(iduser    INT AUTOINCREMENT," +
	                   " pseudo               TEXT    NOT NULL," +
	                   " nom                  TEXT    NOT NULL," + 
	                   " prenom               TEXT     NOT NULL," +
	                   " mdp                  TEXT    NOT NULL," +
	                   " typeUser             TEXT,"+
					   " CONSTRAINT userData_pk PRIMARY KEY(iduser));")*/
	void createUserDataTable();
	
	@SqlUpdate("CREATE TABLE Follow " +
            "(iduser1    INT," +
            " iduser2    INT," +
            " CONSTRAINT iduser1_fk FOREIGN KEY(iduser1) references UserData,"+
            " CONSTRAINT iduser2_fk FOREIGN KEY(iduser2) references UserData,"+
            " CONSTRAINT iduser_pk PRIMARY KEY(iduser1, iduser2));")
     void createFollowTable();
	
	@SqlUpdate("insert into UserData (pseudo, nom, prenom, mdp, typeUser) values (:pseudo, :nom, :prenom, :mdp, :typeUser)")
	@GetGeneratedKeys
	int insertUser(@Bind("pseudo") String pseudo, @Bind("nom") String nom, @Bind("prenom") String prenom, @Bind("mdp") String mdp, @Bind("typeUser") String typeUser);
	
	@SqlUpdate("insert into History (idlvl, score, pseudo) values (:idlvl, :score, :pseudo)")
	@GetGeneratedKeys
	int insertHistory(@Bind("idlvl") int idlvl, @Bind("score") int score, @Bind("pseudo") String pseudo);
	
	@SqlUpdate("insert into Play (score, idhisto, pseudo) values (:score, :idhisto, :pseudo)")
	@GetGeneratedKeys
	int insertPlay(@Bind("score") int score, @Bind("idhisto") int idhisto, @Bind("pseudo") String pseudo);
	
	@SqlQuery("select * from UserData where pseudo = :pseudo and mdp = :mdp")
	@RegisterMapperFactory(BeanMapperFactory.class)
	UserData verifUser(@Bind("pseudo") String pseudo, @Bind("mdp") String mdp);
	
	@SqlQuery("select sum(score) from levels as l, UserData as u where l.iduser = u.iduser;")
	@RegisterMapperFactory(BeanMapperFactory.class)
	int ScoreTotal(@Bind("score") int score);
	
	@SqlUpdate("drop table if exists UserData")
	void dropUserTable(); 
	
	void close();
}
