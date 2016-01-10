package Model;

public class Simulation {
	private int id;
	private Client client;
	private Conseiller conseiller;
	private String typePret;
	private String sommeDemande;
	private String decision;
	
	
	
	public Simulation(int id, Client client, Conseiller conseiller, String typePret, String sommeDemande,
			String decision) {
		super();
		this.id = id;
		this.client = client;
		this.conseiller = conseiller;
		this.typePret = typePret;
		this.sommeDemande = sommeDemande;
		this.decision = decision;
	}
	
	public Simulation() {
		
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
	public Conseiller getConseiller() {
		return conseiller;
	}
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	public String getTypePret() {
		return typePret;
	}
	public void setTypePret(String typePret) {
		this.typePret = typePret;
	}
	public String getSommeDemande() {
		return sommeDemande;
	}
	public void setSommeDemande(String sommeDemande) {
		this.sommeDemande = sommeDemande;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
		
	
}
