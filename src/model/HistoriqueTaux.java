package model;

import java.util.Calendar;
import java.util.Date;

public class HistoriqueTaux {
	
	private int id;
	private Taux taux;
	private int valeur;
	private Date date;
	
	
	public HistoriqueTaux(Taux taux, int valeur) {
		this.taux = taux;
		this.valeur = valeur;
		Calendar c = Calendar.getInstance();
		this.date = c.getTime();
	}


	public int getId() {
		return id;
	}


	public Taux getTaux() {
		return taux;
	}


	public int getValeur() {
		return valeur;
	}


	public Date getDate() {
		return date;
	}
	
	
	
	

}
