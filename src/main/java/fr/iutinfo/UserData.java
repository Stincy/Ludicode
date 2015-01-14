package fr.iutinfo;

public class UserData {
	private String nom;
	private String prenom;
	private String pseudo;
	private String mdp;
	private String typeUser;/* eleve ou professeur */
	private User superviseur;/* user professeur supervisant eleve ou null pour un professeur */
	

	public UserData(String nom,String prenom, String pseudo, String mdp, String typeUser, User superviseur) {
		this.nom = nom;
		this.prenom=prenom;
		this.pseudo=pseudo;
		this.mdp=mdp;
		this.typeUser=typeUser;
		this.superviseur=superviseur;		
	}
	
	public UserData(String nom,String prenom, String pseudo, String mdp, String typeUser) {
		this.nom = nom;
		this.prenom=prenom;
		this.pseudo=pseudo;
		this.mdp=mdp;
		this.typeUser=typeUser;
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

	public void setPTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}
	
	public User getSuperviseur() {
		return superviseur;
	}

	public void setSuperviseur(User superviseur) {
		if(this.typeUser.equals("eleve")){
			this.superviseur = superviseur;
		}else
			this.superviseur=null;
	}

	public boolean equals(Object u) {
		return pseudo.equals(((UserData) u).pseudo);
	}

	public String toString() {
		if(this.typeUser.equals("professeur"))
			return nom+ " " +prenom+ " alias "+pseudo+" mot de passe "+mdp+" est un "+typeUser;
		else
			return nom+ " " +prenom+ " alias "+pseudo+" mot de passe "+mdp+" est un "+typeUser+", supervise par "+superviseur;
	}

}
