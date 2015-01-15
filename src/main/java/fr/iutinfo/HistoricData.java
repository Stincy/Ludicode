package fr.iutinfo;

public class HistoricData {
	private int numHistoric;
	private int numProblem;
	private String typePartie;
	private int score;
	private String pseudo;
	
	public HistoricData(int numHistoric, int numProblem, String typePartie, int score, String pseudo){
		this.numHistoric=numHistoric;
		this.numProblem=numProblem;
		this.typePartie=typePartie;
		this.score=score;
		this.pseudo=pseudo;
	}
	
	public HistoricData(){
		
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
		return numHistoric+ "-" +numProblem+ " du type "+typePartie+" le joueur "+pseudo+" a fait "+score+" points";
	}
	
}
