package fr.iutinfo;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import BDD.Level;

public interface LevelDao {
	@SqlUpdate("create table levels (id integer primary key autoincrement, difficulty integer, name TEXT, information TEXT, tiles TEXT)")
	void createLevelTable();

	@SqlUpdate("insert into levels (name, difficulty, information, tiles) values (:name, :difficulty, :information, :tiles)")
	@GetGeneratedKeys
	int insert(@Bind("name") String name, @Bind("difficulty") int difficulty, @Bind("information") String info, @Bind("tiles") String tiles);

	@SqlQuery("select * from levels where difficulty = :difficulty")
    @RegisterMapperFactory(BeanMapperFactory.class)
	Level findByDifficulty(@Bind("difficulty") int difficulty);

	@SqlUpdate("drop table if exists levels")
	void dropUserTable(); 
	
	void close();
}