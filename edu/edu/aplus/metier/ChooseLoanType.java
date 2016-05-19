package edu.aplus.metier;

import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.sql.DataSource;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class ChooseLoanType extends JFrame {

	private DataSource ds;
	private JPanel contentPanel;
	private Connection co;
	final String[] loanType = {"Prêt immobilier", "Prêt de consommation", "Prêt professionnel", "Rachat de crédits"};

	

	/*
	 * Create the frame.
	 */
	public ChooseLoanType() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		setTitle("Recherche des taux d'intérêts");
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JLabel labelLoanType = new JLabel("Type de prêt : ");
		labelLoanType.setBounds(10, 45, 113, 14);
		contentPanel.add(labelLoanType);

		
		final JComboBox listLoanType = new JComboBox(loanType);
		listLoanType.setBounds(120, 35, 160, 30);

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
				if (selectedString(is) == loanType[1]){ // Pret de consommation
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