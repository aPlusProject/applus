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
	private String loanName;
	private int duration;
	private float rateValue, rateAgency;
	private ConnectionPool pool;

	/*Getters and setters*/

	public int getId() {
		return id;
	}

	public int getDuration(){
		return this.duration;
	}
	public float getRateValue(){
		return this.rateValue;
	}

	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setRateValue(float rateValue) {
		this.rateValue = rateValue;
	}
	public float getRateAgency() {
		return this.rateAgency;
	}
	public void setRateAgency(float rateAgency) {
		this.rateAgency = rateAgency;
	}

	public void setPool(ConnectionPool pool) {
		this.pool = pool;
	}

	public String getLoanName() {
		return this.loanName;
	}

	public void setId(int id){
		this.id = id;
	}

	public ConnectionPool getPool() {
		return this.pool;
	}

	@Override
	public String toString() {
		return "Rate [loanName=" + loanName + ", duration="
				+ duration + ", rateValue=" + rateValue + ", rateAgency=" + rateAgency + "]";
	}
	/* For instance */
	public static Rate rate()
	{
		return (new Rate());
	}



}

