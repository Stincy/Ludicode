package fr.iutinfo;

public class HistoricData {
	private int id;
	private int numHistoric;
	private int numProblem;
	private String nomPartie;
	private String typePartie;
	private int score;
	private String pseudo;
	
	public HistoricData(int id, String nomPartie, String typePartie){
		this.nomPartie=nomPartie;
		this.typePartie=typePartie;
	}
	
	public HistoricData(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getNumH() {
		return numHistoric;
	}
	
	public void setNumH(int numH) {
		this.numHistoric = numH;
	}
	
	public int getNumProbleme() {
		return numProblem;
	}
	
	public void setNumProbleme(int numProbleme) {
		this.numProblem = numProbleme;
	}
	
	public String getNomPartie() {
		return nomPartie;
	}
	
	public void setNomPartie(String nomPartie) {
		this.nomPartie = nomPartie;
	}

	public String getTypePartie() {
		return typePartie;
	}
	
	public void setTypePartie(String typePartie) {
		this.typePartie = typePartie;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public boolean equals(Object h) {
		return numHistoric==(((HistoricData) h).numHistoric);
	}

	public String toString() {
		return numHistoric+ "-" +numProblem+ " -> "+nomPartie+" du type "+typePartie+" le joueur "+pseudo+" a fait "+score+" points";
	}
	
}

