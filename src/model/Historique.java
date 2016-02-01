package model;

import java.util.Calendar;
import java.util.Date;

public class Historique {

	private int id;
	private Pret pret;
	private Date date;  //pas sûr de l'import
	
	
	public Historique(Pret pret) {
		this.pret = pret;
		Calendar c = Calendar.getInstance();
		this.date = c.getTime();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Pret getPret() {
		return pret;
	}


	public void setPret(Pret pret) {
		this.pret = pret;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}
