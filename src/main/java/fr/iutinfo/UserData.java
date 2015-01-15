package fr.iutinfo;

public class UserData {
	private int id = 0;
	private String nom;
	private String prenom;
	private String pseudo;
	private String mdp;
	private String typeUser;/* eleve ou professeur */
	private User superviseur;/* user professeur supervisant eleve ou null pour un professeur */
	

	public UserData(int id,String nom,String prenom, String pseudo, String mdp,String typeUser) {
		this.id=id;
		this.nom = nom;
		this.prenom=prenom;
		this.pseudo=pseudo;
		this.mdp=mdp;
		this.typeUser=typeUser;
				
	}
	
	public UserData(int id,String nom,String prenom, String pseudo, String mdp,String typeUser, User superviseur) {
		this.id=id;
		this.nom = nom;
		this.prenom=prenom;
		this.pseudo=pseudo;
		this.mdp=mdp;
		this.typeUser=typeUser;
		this.superviseur=superviseur;
	}

	public UserData() {
		
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id=id;
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
		return id==(((UserData) u).id);
	}

	public String toString() {
		return nom+ " " +prenom+ " alias "+pseudo+" mot de passe "+mdp;
	}
}