package Model;

public class Compte {
	
	private int ID_Compte;
	private int ID_Client;
	private int Date_ouverture;
	private int Solde;
	
	public Compte(int iD_Compte, int iD_Client, int date_ouverture, int solde) {
		super();
		ID_Compte = iD_Compte;
		ID_Client = iD_Client;
		Date_ouverture = date_ouverture;
		Solde = solde;
	}

	public int getID_Compte() {
		return ID_Compte;
	}

	public int getID_Client() {
		return ID_Client;
	}

	public int getDate_ouverture() {
		return Date_ouverture;
	}

	public void setDate_ouverture(int date_ouverture) {
		Date_ouverture = date_ouverture;
	}

	public int getSolde() {
		return Solde;
	}

	public void setSolde(int solde) {
		Solde = solde;
	}
	
	public void virer(){
		
	}
	
}
