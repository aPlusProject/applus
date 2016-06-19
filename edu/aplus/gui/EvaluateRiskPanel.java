package edu.aplus.gui;

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
import edu.aplus.metier.SetProfileClient2;
/* Panel to compare the two rates
 * rate of parent company & rate of agency * 
 */



public class EvaluateRiskPanel extends JFrame {

	ChooseLoanType clt;
	ChooseLoanTypePanel cltp;
	SetProfileClient2 pf;
	static JTextField agRate;
	static JTextField  hqRate;
	
	public EvaluateRiskPanel() throws Exception{
		final JFrame frame3 = new JFrame("Evaluer les risques");
		hqRate = new JTextField();
		hqRate.setBounds(10,50,120,30);
		agRate = new JTextField();
		agRate.setBounds(180,50,120,30);
		frame3.getContentPane().add(hqRate);		
		frame3.getContentPane().add(agRate);
		String hqRateS = hqRate.getText();
		String agRateS = agRate.getText();
		frame3.getContentPane().setLayout(null);
		frame3.setTitle("Evaluer risque");
		frame3.setBounds(100, 100, 350, 300);
		frame3.getContentPane().setBounds(100, 100, 350, 300);
		final JLabel labelSetPret = new JLabel ("Taux de la maison-mere:");
		labelSetPret.setBounds(10,10,200,30);
		ChooseLoanType clt = new ChooseLoanType();
		clt.CompareRate(hqRate,agRate);
		final JLabel labelAgencyRate = new JLabel ("Taux de l'agence:");
		labelAgencyRate.setBounds(180,10,200,30);
		

		//String agRateS = agRate.getText();
		//String hqRateS = hqRate.getText();

		JButton editProfile = new JButton ("Editer profil");
		editProfile.setBounds(120,150,100,20);
		editProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				new SetProfileClient2();
				
			} });
		frame3.getContentPane().add(labelSetPret);
		frame3.getContentPane().add(editProfile);
		
		frame3.getContentPane().add(labelAgencyRate);
		frame3.setVisible(true);
		// nd of duree add action listenrr


		JButton back = new JButton ("Retour");
		back.setBounds(240,70,100,20);

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					frame3.dispose();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//clt.setVisible(true);
			}
		});





	}
}