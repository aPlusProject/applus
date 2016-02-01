package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Client extends Personne{
	
	private int id;
	private Employe employe;
	private String nom;
	private String prenom;
	private String email;
	private String numTel;
	private String ville;
	private String adresse;
	private String codePostal;
	
	
	public Client(Employe employe, String nom, String prenom, String email, String numTel, String ville, String adresse,
			String codePostal) {
		this.employe = employe;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.numTel = numTel;
		this.ville = ville;
		this.adresse = adresse;
		this.codePostal = codePostal;
	}


	public Employe getEmploye() {
		return employe;
	}


	public void setEmploye(Employe employe) {
		this.employe = employe;
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
