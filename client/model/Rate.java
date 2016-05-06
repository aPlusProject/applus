package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

//import applus.DBConnector;

public class Rate {
	
	private int id;
	private int value;
	private String name;
	
	
	
	public int getId() {
		return id;
	}
	
	/*
	 * get the value (in euro*100)
	 */
	public int getValue() {
		return value;
	}
	
	/*
	 * return the value of the n rate
	 */
	public int getValue(String n) {
		return 0;
	}
	
	
	/*
	 * get the name of the rate
	 */
	public String getName() {
		return name;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public static int getRateValue(Connection co ,String n) throws SQLException {
		
		ResultSet rs = null;
		int rateValue = 0;
		String req = "SELECT rate_value FROM RATE WHERE rate_first_name = '"+n+"'";
		Statement stmt = co.createStatement();
		System.out.println("createstmt");
		rs = stmt.executeQuery(req);
		if(rs.next()) {
			System.out.println("read");
			rs.getInt("rate_value");
			rateValue = rs.getInt(1);
		}
		return rateValue;
	}
		

}
