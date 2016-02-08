package IHM;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import applus.DBConnector;

import javax.swing.JLabel;
import javax.swing.JButton;

public class Employee_menu extends JFrame {

	private JPanel contentPane;
	private Connection co;
	private int amount = 10000;
	Statement ps;
	ResultSet rs;

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
		btnSimulate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("envoi de la simulation");
				try {
					co = DBConnector.getConnection();
					System.out.println("connexion");
					String query = "INSERT INTO LOAN VALUES ('',1,1,1,null,20000,SYSDATE,0)";
					ps = co.createStatement();
					System.out.println("query prepared");
					rs = ps.executeQuery(query);
					System.out.println("query executed");
					co.close();
					System.out.println("co closed");
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		btnSimulate.setBounds(71, 116, 89, 23);
		contentPane.add(btnSimulate);
	}

}
