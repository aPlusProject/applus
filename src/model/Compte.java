package model;

import java.util.Calendar;
import java.util.Date;

public class Compte {
	
	private int id;
	private Client client;
	private Date dateOuverture;  //pas sûr de limport
	private int solde;
	
	
	public Compte(Client client, int solde) {
		this.client = client;
		Calendar c = Calendar.getInstance();
		this.dateOuverture = c.getTime();
		this.solde = solde;
	}
	
	public Compte() {
		
	}
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public Date getDateOuverture() {
		return this.dateOuverture;
	}



	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}



	public int getSolde() {
		return solde;
	}



	public void setSolde(int solde) {
		this.solde = solde;
	}



	public void virer(int numCompte){
		//TODO: trouver un moyen de virer un compte et sauvegarder les comptes
	}
	
}
