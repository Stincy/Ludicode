package fr.iutinfo;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import BDD.Level;

public interface LeaderboardDao {

	@SqlUpdate("create table Leaderboard (pseudo text , score int, constraint pk_leaderboard primary key(pseudo, score), constraint fk_pseudo foreign key(pseudo) references UserData, constraint fk_score foreign key(score) references History)")
	void createLeaderboardTable();
	
	@SqlUpdate("insert into Leaderboard (pseudo, score) values (:pseudo, :score)")
	int insertLeaderboard(@Bind("pseudo") String pseudo, @Bind("score") int score);
	
	@SqlQuery("select * from Leaderboard order by score asc;")
	@RegisterMapperFactory(BeanMapperFactory.class)
	Leaderboard listingBoard();
	
	@SqlUpdate("drop table if exists Leaderboard")
	void dropLeaderboardTable();
	
	void close();
}
