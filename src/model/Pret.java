package model;

import java.sql.Date;

public class Pret {
	
	private int id;
	private Client client;
	private Employe conseiller;
	private TypePret typePret;
	private Historique historique;
	private int sommeDemande;
	private Date dateDemande;    //peut etre le mauvaise importe
	private int decision;  //documenter les valeurs  que peuvt prend decision
	
	
	
	public Pret(Client client, Employe conseiller, TypePret typePret, Historique historique, int sommeDemande,
			Date dateDemande, int decision) {
		super();
		this.client = client;
		this.conseiller = conseiller;
		this.typePret = typePret;
		this.historique = historique;
		this.sommeDemande = sommeDemande;
		this.dateDemande = dateDemande;
		this.decision = decision;
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



	public Employe getConseiller() {
		return conseiller;
	}



	public void setConseiller(Employe conseiller) {
		this.conseiller = conseiller;
	}



	public TypePret getTypePret() {
		return typePret;
	}



	public void setTypePret(TypePret typePret) {
		this.typePret = typePret;
	}



	public Historique getHistorique() {
		return historique;
	}



	public void setHistorique(Historique historique) {
		this.historique = historique;
	}



	public int getSommeDemande() {
		return sommeDemande;
	}



	public void setSommeDemande(int sommeDemande) {
		this.sommeDemande = sommeDemande;
	}



	public Date getDateDemande() {
		return dateDemande;
	}



	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}



	public int getDecision() {
		return decision;
	}



	public void setDecision(int decision) {
		this.decision = decision;
	}
	
	public int getFraisDossier() {
		//TODO: algo pour determiner le frais de dossier en fonction du pret
		return 0;
	}
	
	
	
		
	
}
