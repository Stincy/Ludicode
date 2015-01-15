package fr.iutinfo;

public class UserData {
	private String nom;
	private String prenom;
	private String pseudo;
	private String mdp;
	private String typeUser;/* eleve ou professeur */
	

	public UserData(String nom,String prenom, String pseudo, String mdp,String typeUser) {
		//this.id=id;
		this.nom = nom;
		this.prenom=prenom;
		this.pseudo=pseudo;
		this.mdp=mdp;
		this.typeUser=typeUser;
				
	}

	public UserData() {
		
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	public String toString() {
		return nom+ " " +prenom+ " alias "+pseudo+" mot de passe "+mdp+" est un "+typeUser;
	}
}