

package edu.aplus.metier;

import java.awt.BorderLayout;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.SQLException;
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
import edu.aplus.db.ConnectionPool;
import edu.aplus.model.Rate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import edu.aplus.model.Loan;
import edu.aplus.metier.ChooseLoanType;

import javax.swing.border.EmptyBorder;
import edu.aplus.db.ConnectionPool;
import edu.aplus.model.Rate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import edu.aplus.gui.*;
/* We have here all the methods to get our request to the database
 * modifyRate : to set the rate_agency
 * setDuration : to modify the duration for the rate
 * compareRisk : to compare risks depending on the margin 
 * 
 */


public class ChooseLoanType  extends JFrame{
	ChooseLoanTypePanel cltp ;
	public static String RateType;
	JPanel contentPanel;
	private Loan loan ;
	static Rate rate = new Rate();
	static int loanDuration;
	private int durationInt;
	static float RateLoan;

	ConnectionPool conn = rate.getPool();
	Connection co= null;
	static DefaultComboBoxModel<DemoModelItem> combox;		
	static DemoModelItem dmi = new DemoModelItem(RateType,RateLoan);
	private JTextField toGetChamp;
	
	public int getLoanDuration() {
		return this.durationInt;
	}


	public void setLoanDuration(int durationInt) {
		this.durationInt = durationInt;
	}
	
	
	
	// METHOD TO MODIFY THE RATE
	public void modifyRate(float f) {
		ConnectionPool conn = new ConnectionPool();
		try {
			conn.makeStack();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Connection connexion = conn.getConnection();
		try{
			ResultSet rs;
			PreparedStatement ps ;
			Connection co = conn.getConnection();

			// rate_agency is the column for the new rate"( modified by the director)
			String query = "UPDATE RATE SET RATE_AGENCY = "+f+" WHERE RATE_TYPE ='"+cltp.getRateType()+"'";

			System.out.println(query);
			ps = co.prepareStatement(query);

			//ps.setString(1, champ.getText());
			//ps.executeUpdate();
			rs = ps.executeQuery();


		} catch (SQLException e) {
			e.printStackTrace();
		}
}
		
// METHOD TO SET THE DURATION
	
		public void setDuration(String durationTF){
			
			ConnectionPool conn = new ConnectionPool();

			try {
				conn.makeStack();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try{
				ResultSet rs;
				PreparedStatement ps ;
				Connection co = conn.getConnection(); //this rate was already written in the database
				String query = "SELECT RATE_VALUE FROM RATE WHERE RATE_DURATION ="+durationTF+" AND RATE_TYPE = '"+cltp.getRateType()+"'"; 
				//System.out.println("jcherche"+fielChamp.getText());

				ps = co.prepareStatement(query);
				rs = ps.executeQuery();

				while(rs.next()) {

					JTextField rateValue = ChooseLoanTypePanel.getRateTF();
					rateValue.setText(rs.getString("RATE_VALUE"));
					}
				String durationString = durationTF;
				int durationInt; 
				durationInt = Integer.parseInt(durationString); 
				setLoanDuration(durationInt);
				rs.close();
				ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
	// end of duree add action listener

		} 
		

	
// METHOD TO COMPARE RISK
		
		public void CompareRate(JTextField pcRatetf, JTextField agRatetf){
		ConnectionPool conn = new ConnectionPool();
			try {
				conn.makeStack();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try{
				ResultSet rs , rs2; // because we want the both rates
				PreparedStatement ps ;
				PreparedStatement ps2 ;
				Connection co = conn.getConnection();
				String query = "SELECT RATE_VALUE FROM RATE WHERE RATE_DURATION ="+AddDurationPanel.getDuree()+" AND RATE_TYPE = '"+cltp.getRateType()+"'";      
				String query2 = "SELECT RATE_AGENCY FROM RATE WHERE RATE_DURATION ="+AddDurationPanel.getDuree()+" AND RATE_TYPE = '"+cltp.getRateType()+"'";    
				System.out.println(query);
				System.out.println(query2);
				ps = co.prepareStatement(query); // 
				ps2 = co.prepareStatement(query2);
				rs = ps.executeQuery();
				rs2 = ps2.executeQuery();
				while(rs.next() && rs2.next()) {
					
					String pcRate = rs.getString("RATE_VALUE");
					String agRate = rs2.getString("RATE_AGENCY");
					pcRatetf.setText(pcRate);
					agRatetf.setText(agRate);

				}
				
				//setLoanDuration(entrerDuree.getText());
				rs.close();
				rs2.close();
				ps.close();
				ps2.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	

} 