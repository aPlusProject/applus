package IHM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Employee_menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee_menu frame = new Employee_menu();
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
	public Employee_menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployee = new JLabel("Employee");
		lblEmployee.setBounds(10, 11, 46, 14);
		contentPane.add(lblEmployee);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(101, 11, 113, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setBounds(258, 11, 138, 14);
		contentPane.add(lblLastName);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(10, 47, 296, 14);
		contentPane.add(lblAdresse);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setBounds(10, 85, 46, 14);
		contentPane.add(lblMenu);
		
		JButton btnSimulate = new JButton("Simulate");
		btnSimulate.setBounds(71, 116, 89, 23);
		contentPane.add(btnSimulate);
	}

}
