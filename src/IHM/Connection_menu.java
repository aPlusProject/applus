package IHM;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import model.Agency;
import model.Employee;

import javax.swing.JButton;

import applus.DBConnector;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Connection_menu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_ID;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private Employee conseiller;
	
	private static Connection co;
	private static PreparedStatement ps;
	private static Statement stmt;
	private static ResultSet rs;
	private static String connect_query;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connection_menu frame = new Connection_menu();
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
	public Connection_menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBankName = new JLabel("Bank name");
		lblBankName.setBounds(172, 11, 76, 14);
		contentPane.add(lblBankName);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(81, 77, 46, 14);
		contentPane.add(lblId);

		textField_ID = new JTextField();
		textField_ID.setBounds(162, 74, 86, 20);
		contentPane.add(textField_ID);

		lblPassword = new JLabel("Password");
		lblPassword.setBounds(81, 131, 46, 14);
		contentPane.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(162, 128, 86, 20);
		contentPane.add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					co = DBConnector.getConnection();
					connect_query = "Select * FROM Employee WHERE ID_Employee="
							+ textField_ID.getText() ;
//							+ " AND password="
//							+ new String(passwordField.getPassword());
					ps = co.prepareStatement(connect_query);
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						int id=rs.getInt("ID_Employee");
						int agency=rs.getInt("ID_Agency");
						String firstName=rs.getString("Employee_first_name");
						String lastName=rs.getString("Employee_last_name");
						String email=rs.getString("Employee_email");
						String telNum=rs.getString("Tel_num");
						conseiller = new Employee(agency, lastName, firstName, email, telNum);
						
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		btnLogin.setBounds(253, 169, 89, 23);
		contentPane.add(btnLogin);

	}
	
	public String get_connect_query(){
		return this.connect_query;
	}

}
