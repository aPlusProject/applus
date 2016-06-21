package edu.aplus.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import javax.swing.JComboBox;

import edu.aplus.db.DBConnector;
import edu.aplus.db.ConnectionPool;




public class Rate {
	
	private int id;
	private double value;
	private String name;
	private String loanName;
	private int duration;
	private double rateValue, rateAgency;
	private ConnectionPool pool;
	
	
	
	public int getId() {
		return id;
	}
	
	
	public double getValue() {
		return value;
	}
	
	/*
	 * return the value of the n rate
	 */
	public double getValue(String n) {
		return 0;
	}
	
	
	/*
	 * get the name of the rate
	 */
	public String getName() {
		return this.name;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public static double getRateValue(Connection co ,String n) throws SQLException {
		
		ResultSet rs = null;
		double rateValue = 0;
		String req = "SELECT rate_value FROM RATE WHERE rate_first_name = '"+n+"'";
		Statement stmt = co.createStatement();
		System.out.println("createstmt");
		rs = stmt.executeQuery(req);
		if(rs.next()) {
			System.out.println("read");
			rs.getDouble("rate_value");
			rateValue = rs.getDouble(1);
		}
		return rateValue;
	}
		
	
	public int getDuration(){
		return this.duration;
	}
	public double getRateValue(){
		return this.rateValue;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setRateValue(double rateValue) {
		this.rateValue = rateValue;
	}

	

	public void setPool(ConnectionPool pool) {
		this.pool = pool;
	}

	public String getLoanName() {
		return this.loanName;
	}

	public double getRateAgency(Connection co) throws SQLException{
		ResultSet rs = null;
		double rateAgency = 0;
		String req = "SELECT RATE_AGENCY FROM RATE WHERE RATE_DURATION = "+getDuration()+" AND RATE_TYPE = '"+getLoanName()+"' ";
		Statement stmt = co.createStatement();
		System.out.println("createstmt");
		rs = stmt.executeQuery(req);
		if(rs.next()) {
			System.out.println("read");
			rs.getDouble("rate_agency");
			rateAgency = rs.getDouble(1);
		}
		return rateAgency;
	}
	public void setRateAgency(double rateAgency) {
		this.rateAgency = rateAgency;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setRate(String name){
		this.name = name;
	}
	public ConnectionPool getPool() {
		return this.pool;
	}

	@Override
	public String toString() {
		return "Rate [id=" + id + ", value=" + value + ", name=" + name + ", loanName=" + loanName + ", duration="
				+ duration + ", rateValue=" + rateValue + ", rateAgency=" + rateAgency + ", pool=" + pool + "]";
	}

	public static Rate rate()
	{
	    return (new Rate());
	}
	
	
	
}

