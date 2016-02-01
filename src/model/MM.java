package model;

public class MM {
	
	private int id;
	private String nom;
	private String ville;
	private String codePostal;
	private String adresse;
	
	
	public MM(String nom, String ville, String codePostal, String adresse) {
		this.nom = nom;
		this.ville = ville;
		this.codePostal = codePostal;
		this.adresse = adresse;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	

}
