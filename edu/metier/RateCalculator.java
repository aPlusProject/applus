package metier;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.sql.DataSource;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RateCalculator extends JFrame {
	
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
					RateCalculator frame = new RateCalculator();
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
	public RateCalculator() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel labelDuration = new JLabel("Durée du prêt: ");
		labelDuration.setBounds(10, 41, 113, 14);
		contentPanel.add(labelDuration);
		JTextField duration = new JTextField();
		duration.setBounds(130, 41, 113, 14);
		contentPanel.add(duration);
		
		JLabel labelRateValue = new JLabel("Taux d'intérêt fixe: ");
		labelRateValue.setBounds(10, 71, 138, 14);
		contentPanel.add(labelRateValue);
		JTextField rateValue = new JTextField("to be defined");
		rateValue.setBounds(130, 71, 113, 14);
		contentPanel.add(rateValue);
		
		JButton calculate = new JButton ("Calculer");
		calculate.setBounds(70,111,113,14);
		contentPanel.add(calculate);
		
		
		calculate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InterestRate calcul = new InterestRate();
				// calcul.setVisible(true);
			}
		});

		
	
	
	}
}
