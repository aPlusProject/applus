package edu.metier;


import java.awt.EventQueue;
import java.sql.Connection;
import javax.sql.DataSource;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CreditRetrieval extends JFrame {
	
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
					CreditRetrieval frame = new CreditRetrieval();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public CreditRetrieval(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Référentiel taux intérêts rachat de crédits");
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel labelLoanType = new JLabel("Type du prêt: ");
		labelLoanType.setBounds(10, 41, 113, 14);
		contentPanel.add(labelLoanType);
		
		JButton modify = new JButton ("Modifier taux");
		modify.setBounds(70,111,113,29);
		contentPanel.add(modify);
	}
	
	


}
