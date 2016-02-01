package model;

public class Employe extends Personne{
	
	private int id;
	private Agence agence;
	private String nom;
	private String prenom;
	private String email;
	private String numTel;
	
	

	public Employe(Agence agence, String nom, String prenom, String email, String numTel) {
		super();
		this.agence = agence;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.numTel = numTel;
	}
	
	

	public Agence getAgence() {
		return agence;
	}



	public void setAgence(Agence agence) {
		this.agence = agence;
	}



	@Override
	public int getID() {
		return this.id;
	}

	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public String getPrenom() {
		return this.prenom;
	}
	
	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public String getNumTel() {
		return this.numTel;
	}

	@Override
	public int simuler() {
		// TODO Auto-generated method stub
		return 0;
	}



	
	
	
	
}
