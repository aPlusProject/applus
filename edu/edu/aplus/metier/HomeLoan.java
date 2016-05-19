package edu.aplus.metier;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;

import javax.sql.DataSource;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class HomeLoan extends JFrame{

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
					HomeLoan frame = new HomeLoan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public HomeLoan(){

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Référentiel taux intérêt prêt immobilier");
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		
		JLabel label = new JLabel("Barème des taux immobiliers pour 100 000 euros empruntés");
		label.setBounds(0, 0, 500, 29);
		contentPanel.add(label);
		Object rowData[][] = { { "DUREE/MOIS", "TAUX REFERENTIEL", "Taux référentiel" }, 
				{"","",""},
				{ "10 ANS/120 MOIS", "1,50%" ,""}, 
				{ "15 ANS/180 MOIS", "1,85%", "III" },
				{ "20 ANS/240 MOIS", "2,05%", "III" },
				{ "25 ANS/300 MOIS", "2,20%", "III" },
				{ "30 ANS/360 MOIS", "3,50%", "III" },
				};
		String columnNames[] = { "Durée du prêt(mois)", "Taux référentiel", "Taux référentiel" };

		JTable table = new JTable(rowData, columnNames);

		JScrollPane scrollPane = new JScrollPane(table);
		table.setBounds(20, 40, 500, 150);

		contentPanel.add(scrollPane, BorderLayout.CENTER);
		contentPanel.add(table);


		JButton modify = new JButton ("Modifier taux");
		modify.setBounds(70,111,113,29);
		contentPanel.add(modify);
	}



}

