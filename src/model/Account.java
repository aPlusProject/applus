package model;

import java.util.Calendar;
import java.util.Date;

public class Account {
	
	private int id;
	private Client client;
	private Date openDate;  //pas sûr de limport
	private int balance;
	
	
	public Account(Client client, int balance) {
		this.client = client;
		Calendar c = Calendar.getInstance();
		this.openDate = c.getTime();
		this.balance = balance;
	}
	
	public Account() {
		
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



	public Date getOpenDate() {
		return this.openDate;
	}



	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}



	public int getBalance() {
		return balance;
	}



	public void setBalance(int balance) {
		this.balance = balance;
	}



	public void fire(int accountNum){
		//TODO: trouver un moyen de virer un compte et sauvegarder les comptes
	}
	
}
