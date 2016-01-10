package Model;

public class Simulation {
	private int ID_Simul;
	private int ID_Client;
	private int ID_Conseiller;
	private String Type_pret;
	private String Somme_demande;
	private String Decision;
	
	public Simulation(int iD_Simul, int iD_Client, int iD_Conseiller,
			String type_pret, String somme_demande, String decision) {
		super();
		ID_Simul = iD_Simul;
		ID_Client = iD_Client;
		ID_Conseiller = iD_Conseiller;
		Type_pret = type_pret;
		Somme_demande = somme_demande;
		Decision = decision;
	}

	public int getID_Simul() {
		return ID_Simul;
	}

	public int getID_Client() {
		return ID_Client;
	}

	public int getID_Conseiller() {
		return ID_Conseiller;
	}

	public String getType_pret() {
		return Type_pret;
	}

	public void setType_pret(String type_pret) {
		Type_pret = type_pret;
	}

	public String getSomme_demande() {
		return Somme_demande;
	}

	public void setSomme_demande(String somme_demande) {
		Somme_demande = somme_demande;
	}

	public String getDecision() {
		return Decision;
	}

	public void setDecision(String decision) {
		Decision = decision;
	}
	
	
}
