package edu.aplus.model;

import java.util.Calendar;
import java.util.Date;

import edu.aplus.model.Loan;

public class History {

	private int id;
	private Loan loan;
	private Date date;  //pas s�r de l'import
	
	
	public History(Loan loan) {
		this.loan = loan;
		Calendar c = Calendar.getInstance();
		this.date = c.getTime();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Loan getLoan() {
		return loan;
	}


	public void setLoan(Loan loan) {
		this.loan = loan;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}
