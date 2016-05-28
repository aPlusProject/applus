package edu.aplus.tests;


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

/* This will be the test of the core application
 * ChooseLoanType.java in edu.aplus.metier; 
 */

public class ChooseLoanTypeTest {

	public static String RateType = "Pret immobilier";
	JPanel contentPanel;
	private Loan loan ;
	static Rate rate = new Rate();
	static int loanDuration;
	private int durationInt;

	//Check if the user exists or no in the dataBase 
	/*	public void testUserExist() { 
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

				String query = "UPDATE RATE SET RATE_AGENCY = 3.5 WHERE RATE_TYPE ='"+RateType+"'";

				System.out.println(query);
				ps = co.prepareStatement(query);

				//ps.setString(1, champ.getText());
				//ps.executeUpdate();
				rs = ps.executeQuery();

				javax.swing.JOptionPane.showMessageDialog(null,"Vous êtes sur le point de modifier le taux d'intérêt"); 


			} catch (SQLException e) {
				e.printStackTrace();
			}
			assertEquals();
	 	} */
}

