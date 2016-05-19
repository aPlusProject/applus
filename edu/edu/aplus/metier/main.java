package edu.aplus.metier;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.sql.DataSource;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


	
public class main {
	
	
	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			
			//ChooseLoanType
			public void run() {
				try {
					ChooseLoanType frame = new ChooseLoanType();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//homeLoan
				try {
					HomeLoan frame = new HomeLoan();
				} catch (Exception e) {
					e.printStackTrace();
				}

				//personalLoan
				try {
					PersonalLoan frame = new PersonalLoan();
				} catch (Exception e) {
					e.printStackTrace();
				}

				// professionalLoan
				try {
					ProfessionalLoan frame = new ProfessionalLoan();
				} catch (Exception e) {
					e.printStackTrace();
				}
				//creditRetrieval
				try {
					CreditRetrieval frame = new CreditRetrieval();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}}
