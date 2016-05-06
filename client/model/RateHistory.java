package model;

import java.util.Calendar;
import java.util.Date;

public class RateHistory {
	
	private int id;
	private Rate rate;
	private int value;
	private Date date;
	
	
	public RateHistory(Rate rate, int value) {
		this.rate = rate;
		this.value = value;
		Calendar c = Calendar.getInstance();
		this.date = c.getTime();
	}


	public int getId() {
		return id;
	}


	public Rate getRate() {
		return rate;
	}


	public int getValue() {
		return value;
	}


	public Date getDate() {
		return date;
	}
	

}
