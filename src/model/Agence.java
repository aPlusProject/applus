package model;

public class Agence {
	
	private int id;
	private MM mm;
	private String nom;
	private String ville;
	private String codePostal;
	private String numTel;
	
	
	
	public Agence(MM mm, String nom, String ville, String codePostal, String numTel) {
		this.mm = mm;
		this.nom = nom;
		this.ville = ville;
		this.codePostal = codePostal;
		this.numTel = numTel;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MM getMm() {
		return mm;
	}
	public void setMm(MM mm) {
		this.mm = mm;
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
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	
	
	

}
