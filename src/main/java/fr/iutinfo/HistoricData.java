package fr.iutinfo;

public class HistoricData {
	private int idhisto;
	private int idlvl;
	private int score;
	private String pseudo;
	
	public HistoricData(int idhisto, int idlvl, String pseudo, int score){
		this.idhisto=idhisto;
		this.idlvl=idlvl;
		this.score=score;
		this.pseudo=pseudo;
		this.score=score;
	}
	
	public HistoricData(){
		
	}
	
	public int getIdhisto() {
		return idhisto;
	}
	
	public void setIdhisto(int idhisto) {
		this.idhisto = idhisto;
	}
	
	public int getIdlvl() {
		return idlvl;
	}
	
	public void setIdlvl(int idlvl) {
		this.idlvl = idlvl;
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
		return idhisto==(((HistoricData) h).idhisto);
	}

	public String toString() {
		return idhisto+ "-" +idlvl+" le joueur "+ pseudo +" a fait "+score+" points";
	}
	
}
