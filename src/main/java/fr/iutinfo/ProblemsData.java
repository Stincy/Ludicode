package fr.iutinfo;

public class ProblemsData {
	private int numProbleme;
	private int numHistoric;
	private String enonce;
	private int difficulte;
	private int score;
	private String typePb;
	private User createur;
	
	public ProblemsData(String enonce, int difficulte, String typePb){
		this.enonce=enonce;
		this.difficulte=difficulte;
		this.typePb=typePb;
				
	}
	
	public ProblemsData(String enonce, int difficulte, String typePb, User createur){
		this.enonce=enonce;
		this.difficulte=difficulte;
		this.typePb=typePb;
		this.createur=createur;
	}
	
	
	public User getCreateur() {
		return createur;
	}
	
	public void setCreateur(User createur) {
		this.createur = createur;
	}
	
	public int getNumProbleme() {
		return numProbleme;
	}
	
	public void setNumProbleme(int numProbleme) {
		this.numProbleme = numProbleme;
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
}
