package fr.iutinfo;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import BDD.Level;

public interface LevelDao {

	@SqlUpdate("create table levels (idlvl integer primary key autoincrement, nbCommands integer, difficulty integer, information TEXT, tiles TEXT, commands TEXT)")
	void createLevelTable();

	@SqlUpdate("insert into levels (difficulty, nbCommands, information, tiles, commands) values (:difficulty, :nbCommands, :information, :tiles, :commands)")
	@GetGeneratedKeys
	int insert(@Bind("difficulty") int difficulty, @Bind("nbCommands") int nbCommands, @Bind("information") String info, @Bind("tiles") String tiles, @Bind("commands") String commands);

	@SqlQuery("select * from levels where difficulty = :difficulty")
    @RegisterMapperFactory(BeanMapperFactory.class)
	Level findByDifficulty(@Bind("difficulty") int difficulty);
	
	@SqlQuery("select * from levels")
    @RegisterMapperFactory(BeanMapperFactory.class)
	List<Level> findAll();
	

	@SqlUpdate("drop table if exists levels")
	void dropLevelTable(); 
	
	void close();
}