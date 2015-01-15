package fr.iutinfo;

public class ProblemsData {
	private int numProblem;
	private int numHistoric;
	private String enonce;
	private int difficulte;
	private int score;
	private String typePb;
	private User createur;
	
	public ProblemsData(int numProblem, int numHistoric, String enonce, int difficulte, int score, String typePb){
		this.numProblem=numProblem;
		this.numHistoric=numHistoric;
		this.enonce=enonce;
		this.difficulte=difficulte;
		this.score=score;
		this.typePb=typePb;
				
	}
	
	public ProblemsData(){
		
	}	
	
	public int getNumProblem() {
		return numProblem;
	}
	
	public void setNumProblem(int numProblem) {
		this.numProblem = numProblem;
	}

	public String getEnonce() {
		return enonce;
	}

	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	public int getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(int difficulte) {
		this.difficulte = difficulte;
	}

	public int getNumH() {
		return numHistoric;
	}

	public void setNumH(int numH) {
		this.numHistoric = numH;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getTypePb() {
		return typePb;
	}

	public void setTypePb(String typePb) {
		this.typePb = typePb;
	}
	
	public User getCreateur() {
		return createur;
	}
	
	public void setCreateur(User createur) {
		this.createur = createur;
	}
	
	public boolean equals(Object p) {
		return numProblem==(((ProblemsData) p).numProblem);
	}

}