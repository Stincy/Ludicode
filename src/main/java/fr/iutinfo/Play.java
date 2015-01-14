package fr.iutinfo;

public class Play {
	private String pseudo;
	private int numProblem;
	private int score;
	
	public Play(String pseudo, int numProbleme, int score){
		this.pseudo=pseudo;
		this.numProblem=numProbleme;
		this.score=score;
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
		return numProblem==(((Play) j).numProblem) && score==(((Play) j).score) && pseudo.equals(((Play) j).pseudo);
	}
	
	public String toString(){
		return pseudo+"(Niveau "+numProblem+") ......"+score;
	}

}

