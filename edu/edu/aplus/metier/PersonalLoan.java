package edu.aplus.metier;


import java.awt.EventQueue;
import java.sql.Connection;

import javax.sql.DataSource;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PersonalLoan extends JFrame {
	
	private DataSource ds;
	private JPanel contentPanel;
	private Connection co;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalLoan frame = new PersonalLoan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public PersonalLoan(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Prêt personnel");
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel labelLoanType = new JLabel("Type du prêt: ");
		labelLoanType.setBounds(10, 41, 113, 14);
		contentPanel.add(labelLoanType);
	}
	
	

}
