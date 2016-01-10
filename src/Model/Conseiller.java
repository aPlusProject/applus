package Model;

public class Conseiller implements People{
	private int id;
//	private Agence agence;
	private String nom;
	private String prenom;
	
	
	
	public Conseiller(int id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Conseiller() {
		
	}
	

	public void simuler() {
		// TODO Auto-generated method stub
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}



	public String getNom() {
		// TODO Auto-generated method stub
		return null;
	}



	public String getPrenom() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
