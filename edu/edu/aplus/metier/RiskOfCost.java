
package edu.aplus.metier;

import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RiskOfCost extends JFrame {
	
	private JPanel contentPanel;

	
	
	ChooseLoanType clt = new ChooseLoanType();
	PersonalLoan pl = new PersonalLoan();
	HomeLoan hl = new HomeLoan();
	CreditRetrieval cr = new CreditRetrieval();
	ProfessionalLoan pfr = new ProfessionalLoan();
	
	public RiskOfCost (){
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		setTitle("Coût du risque");
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		

	}
	}