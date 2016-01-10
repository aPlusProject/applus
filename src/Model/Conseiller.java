package Model;

public class Conseiller implements People{
	private int ID_employe;
	private int ID_agence;
	private String Nom_Conseiller;
	private String Prenom_Conseiller;
	
	public Conseiller(int iD_employe, int iD_agence, String nom_Conseiller,
			String prenom_Conseiller) {
		super();
		ID_employe = iD_employe;
		ID_agence = iD_agence;
		Nom_Conseiller = nom_Conseiller;
		Prenom_Conseiller = prenom_Conseiller;
	}

	public int getID_agence() {
		return ID_agence;
	}

	public void setNom_Conseiller(String nom_Conseiller) {
		Nom_Conseiller = nom_Conseiller;
	}

	public void setPrenom_Conseiller(String prenom_Conseiller) {
		Prenom_Conseiller = prenom_Conseiller;
	}
	
	public int getID() {
		// TODO Auto-generated method stub
		return ID_employe;
	}

	public String getNom() {
		// TODO Auto-generated method stub
		return Nom_Conseiller;
	}

	public String getPrenom() {
		// TODO Auto-generated method stub
		return Prenom_Conseiller;
	}

	public void simuler() {
		// TODO Auto-generated method stub
		
	}
	
}
