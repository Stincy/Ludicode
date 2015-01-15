package fr.iutinfo;

public class Play {
	private int id;
	private String pseudo;
	private int numProblem;
	private int score;
	
	public Play(int id, String pseudo, int numProbleme, int score){
		this.pseudo=pseudo;
		this.numProblem=numProbleme;
		this.score=score;
	}
	
	public Play(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public int getNumProbleme() {
		return numProblem;
	}
	public void setNumProbleme(int numProbleme) {
		this.numProblem = numProbleme;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public boolean equals(Object j) {
		return id==(((Play) j).id);
	}
	
	public String toString(){
		return pseudo+"(Niveau "+numProblem+") ......"+score;
	}

	

}
