package edu.aplus.tests;


import static org.junit.Assert.*;

import java.awt.BorderLayout;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.junit.Test;

import edu.aplus.db.ConnectionPool;
import edu.aplus.model.Rate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import edu.aplus.model.Loan;

/*JUnits Tests for the queries to the database
 *  RateDatabaseTest : for the "select" query
 *  UpdateRateOk : for the 'update" query
 */

public class RateDatabaseTest {

	public static String RateType = "Pret immobilier";
	JPanel contentPanel;
	private Loan loan ;
	static Rate rate = new Rate();
	static int loanDuration;
	private int durationInt;
	
	
		@Test
		public void testRateExist() { 
	 		ConnectionPool conn = new ConnectionPool();
	 		int duration = 15 ;
			String loanName = "Pret immobilier";
			float value = 0;
			float exp = (float) 1.85;
			try {
				conn.makeStack();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try{
				ResultSet rs;
				PreparedStatement ps ;
				Connection co = conn.getConnection();
				String sql;
				
				sql = "SELECT RATE_VALUE FROM RATE WHERE RATE_DURATION = "+duration+" AND RATE_TYPE = '"+loanName+"' ";
				System.out.println(sql);
				rs = co.createStatement().executeQuery(sql);
				while(rs.next()) {
					value = rs.getFloat("RATE_VALUE");
					rate.setRateValue(value);
				} 


			} catch (SQLException e) {
				e.printStackTrace();
			}
			assertEquals(exp,value,0.4);
	 	} 
		
		@Test
		public void UpdateRateOk(){
			
			ConnectionPool conn = new ConnectionPool();
	 		int duration = 15 ;
			String loanName = "Pret immobilier";
			float value = 0;
			float exp = (float) 1.50;
			float rateHQ = (float) 1.85;
			float rateAgency = (float) (rateHQ - 0.35);
			try {
				conn.makeStack();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try{
				ResultSet rs;
				PreparedStatement ps ;
				Connection co = conn.getConnection();
				String sql = "UPDATE RATE SET RATE_AGENCY = ? WHERE RATE_DURATION = "+duration+" AND RATE_TYPE = '"+loanName+"' ";
				System.out.println(sql);
				ps = co.prepareStatement(sql);
				ps.setDouble(1,rateAgency); 
				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			assertEquals(exp,rateAgency,0.4);
	 	} 
}

