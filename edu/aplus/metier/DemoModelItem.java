package edu.aplus.metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import edu.aplus.db.ConnectionPool;
import edu.aplus.model.Rate;



public class DemoModelItem {
	public String RateType;
	public float RateLoan;
	private static Rate rate;



	public DemoModelItem(String RateType,float RateLoan){
		this.RateType = RateType;
		this.RateLoan = RateLoan;
	}

	public String toString(){
		return RateType;
	}
	public float getRateLoan() {
		return RateLoan;
	}

	public void setRateLoan(float rateLoan) {
		RateLoan = rateLoan;
	}


	
	
	
	public static DefaultComboBoxModel buildComboBoxModel() throws Exception {
		ConnectionPool conn = null;
		conn = new ConnectionPool();
		
		conn.makeStack();
		DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
		Connection co = null;

		try {
			co = conn.getConnection();
			PreparedStatement ps;
			ResultSet rs;
			comboBoxModel = new DefaultComboBoxModel<DemoModelItem>();
			String sql = "SELECT RATE_TYPE,MIN(RATE_VALUE) FROM RATE GROUP BY RATE_TYPE";
			ps = co.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {

				//this.LoanType = new LoanType();
				///this.lt.setLoanType(rs.getString(1));
				comboBoxModel.addElement(new DemoModelItem(rs.getString("RATE_TYPE"),rs.getFloat("MIN(RATE_VALUE)")));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			throw e;
		}finally{
			try{co.close();}catch(Exception e){;}

		}	
		return comboBoxModel;
	}


/*	public static void main(String[] args) throws Exception {  
	    JComboBox comboBox = new JComboBox();  
	    comboBox.setModel(buildComboBoxModel());  

	    JFrame frame = new JFrame("Combo Demo");  
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

	    frame.getContentPane().add(comboBox);  
	    frame.pack();  
	    frame.setVisible(true);  
	}  */

}
