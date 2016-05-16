package edu.metier;


import java.awt.EventQueue;
import java.awt.ItemSelectable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.sql.DataSource;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ChooseLoanType extends JFrame {

	private DataSource ds;
	private JPanel contentPanel;
	private Connection co;


	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseLoanType frame = new ChooseLoanType();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public ChooseLoanType() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Recherche des taux d'intérêts");
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JLabel labelLoanType = new JLabel("Type du prêt: ");
		labelLoanType.setBounds(10, 41, 113, 14);
		contentPanel.add(labelLoanType);

		final String[] loanType = {"Prêt immobilier", "Prêt personnel", "Prêt professionnel", "Rachat de crédits"};
		final JComboBox listLoanType = new JComboBox(loanType);
		listLoanType.setBounds(160, 41, 130, 14);

		/*JButton findRate = new JButton ("Voir");
		findRate.setBounds(70,111,113,29);
		contentPanel.add(findRate); */

		ActionListener cbActionListener = new ActionListener() {

			public void actionPerformed(ActionEvent actionEvent) {
				System.out.println("Command: " + actionEvent.getActionCommand());
				ItemSelectable is = (ItemSelectable)actionEvent.getSource();
				// System.out.println(", Selected: " + selectedString(is));
				if (selectedString(is) == loanType[0]){ // Pret immobilier
					HomeLoan hl = new HomeLoan();
					hl.setVisible(true);			        	
				}
				if (selectedString(is) == loanType[1]){ // Pret personnel
					PersonalLoan pl = new PersonalLoan();
					pl.setVisible(true);			        	
				}
				if (selectedString(is) == loanType[2]){ // Pret professionnel
					ProfessionalLoan pfl = new ProfessionalLoan();
					pfl.setVisible(true);			        	
				}
				if (selectedString(is) == loanType[3]){ // Rachat de crédits
					CreditRetrieval cr = new CreditRetrieval();
					cr.setVisible(true);			        	
				}
			}
		};
		listLoanType.addActionListener(cbActionListener);


		contentPanel.add(listLoanType); 

	};


	static private String selectedString(ItemSelectable is) {
		Object selected[] = is.getSelectedObjects();
		return ((selected.length == 0) ? "null" : (String)selected[0]);
	}  





}