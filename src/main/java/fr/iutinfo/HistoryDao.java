package fr.iutinfo;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface HistoryDao {

	@SqlUpdate("CREATE TABLE History (idhisto integer primary key autoincrement, idlvl integer foreign key references levels, pseudo TEXT foreign key references UserData, score integer)")
	void createHistoryTable();
	
	@SqlUpdate("insert into History (idlvl, pseudo, score) values (:idlvl, :pseudo, :score)")
	@GetGeneratedKeys
	int insertHistory(@Bind("idlvl") int idlvl, @Bind("pseudo") String pseudo, @Bind("score") int score);
	
	@SqlQuery("select * from History where  pseudo = :pseudo")
	@RegisterMapperFactory(BeanMapperFactory.class)
	HistoricData verifHistoric(@Bind("pseudo") String pseudo);
	
	@SqlQuery("select sum(score) from Historic where iduser = :iduser;")
	@RegisterMapperFactory(BeanMapperFactory.class)
	int ScoreTotalHisto(@Bind("iduser") int iduser);
	
	@SqlUpdate("drop table if exists History")
	void dropHistoryTable();
	
	void close();
}
