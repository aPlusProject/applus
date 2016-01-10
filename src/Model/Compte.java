package Model;

public class Compte {
	
	private int id;
	private Client client;
	private int dateOuverture;
	private int solde;
	
	
	public Compte(int id, Client client, int dateOuverture, int solde) {
		this.id = id;
		this.client = client;
		this.dateOuverture = dateOuverture;
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



	public int getDateOuverture() {
		return dateOuverture;
	}



	public void setDateOuverture(int dateOuverture) {
		this.dateOuverture = dateOuverture;
	}



	public int getSolde() {
		return solde;
	}



	public void setSolde(int solde) {
		this.solde = solde;
	}



	public void virer(){
		
	}
	
}
