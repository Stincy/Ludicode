package fr.iutinfo;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface UserDao {

	@SqlUpdate("insert into Utilisateur (Pseudo, Nom, Prenom, Mdp, TypeUser) values (:Pseudo, :Nom, :Prenom, :Mdp, :TypeUser)")
	@GetGeneratedKeys
	int insert(@Bind("Pseudo, Nom, Prenom, Mdp, TypeUser") String Pseudo, String Nom, String Prenom, String Mdp, String TypeUser);
	
	@SqlUpdate("insert into Probleme (TypePb, NiveauDiff, TaillePb, Enonce, Score, NumHisto, Pseudo) values (:TypePb, :NiveauDiff, :TaillePb, :Enonce, :Score, :NumHisto, :Pseudo)")
	@GetGeneratedKeys
	int insert(@Bind("TypePb, NiveauDiff, TaillePb, Enonce, Score, NumHisto, Pseudo") String TypePb, String NiveauDiff, String TaillePb, String Enonce, int Score, int NumHisto, String Pseudo);
	
	@SqlUpdate("insert into Historique (Score, TypeHisto, Pseudo, NumProbleme) values (:Score, :TypeHisto, :Pseudo, :NumProbleme)")
	@GetGeneratedKeys
	int insert(@Bind("Score, TypeHisto, Pseudo, NumProbleme") int Score, String TypeHisto, String Pseudo, int NumProbleme);
	
	//@SqlQuery("select sum(Score) from Probleme ")
}
