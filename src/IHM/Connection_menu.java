package IHM;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;
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

public class Connection_menu extends JFrame implements Observer{

	private JPanel panel;
	private JTextField textField;
	private JTextField emailTextField;
	private JLabel lblPassword;
	private JLabel lblFirstName;
	private JPasswordField passwordField;
	private Employee conseiller = null;

	private static Connection co;
	private static PreparedStatement ps;
	private static Statement stmt;
	private static ResultSet rs = null;
	private static String queryConnect;

	private boolean logged=false;

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
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Connection_menu() throws ClassNotFoundException, SQLException {
		setTitle("Fenêtre de login"); // On donne un titre à l'application
		setSize(500, 350); // On donne une taille à notre fenêtre
		setLocationRelativeTo(null); // On centre la fenêtre sur l'écran
		setResizable(true); // On permet le redimensionnement
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // On dit à
														// l'application de se
														// fermer lors du clic
														// sur la croix

		// setBounds(100, 100, 450, 300);
		panel = new JPanel();
		panel.setLayout(null);
		setContentPane(panel);
		// panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setContentPane(panel);
		// panel.setLayout(null);

		JLabel lblBankName = new JLabel("Login page");
		lblBankName.setBounds(172, 11, 76, 14);
		panel.add(lblBankName);

		JLabel lblId = new JLabel("email");
		lblId.setBounds(81, 77, 46, 14);
		panel.add(lblId);

		emailTextField = new JTextField();
		emailTextField.setBounds(162, 74, 86, 20);
		panel.add(emailTextField);

		lblPassword = new JLabel("Password");
		lblPassword.setBounds(81, 131, 71, 14);
		panel.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(162, 128, 86, 20);
		panel.add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			private JLabel lblLastName;
			private JLabel lblEmail;
			private JLabel lblMessageLog;

			public void actionPerformed(ActionEvent arg0) {
				try {
					System.out.println("bouton pressé");
					co = DBConnector.getConnection();
					queryConnect = "Select * FROM Employee WHERE employee_email='"
							+ emailTextField.getText()
							+ "' AND tel_num='"
							+ new String(passwordField.getPassword()) + "'";
					ps = co.prepareStatement(queryConnect);
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						int id = rs.getInt("ID_Employee");
						int agency = rs.getInt("ID_Agency");
						String firstName = rs.getString("Employee_first_name");
						String lastName = rs.getString("Employee_last_name");
						String email = rs.getString("Employee_email");
						String telNum = rs.getString("Tel_num");
						conseiller = new Employee(agency, lastName, firstName,
								email, telNum);
						System.out.println(conseiller.toString());
						
					}
					

					panel.setVisible(false);
					//setLayout(null);
					setTitle("Fenetre de simulation");
					JPanel info_panel = new JPanel();
					setContentPane(info_panel);
					info_panel.setVisible(true);
					info_panel.setLayout(null);
					
					JLabel nameLabel = new JLabel(conseiller.getFirstName() + " " + conseiller.getLastName());
					nameLabel.setBounds(10, 11, 418, 14);
					info_panel.add(nameLabel);
					
					JLabel infoLabel = new JLabel(conseiller.getEmail() + " " + conseiller.getTelNum());
					infoLabel.setBounds(10, 36, 418, 14);
					info_panel.add(infoLabel);
					
					JTextField IDtextField = new JTextField();
					IDtextField.setBounds(116, 97, 86, 20);
					info_panel.add(IDtextField);
					IDtextField.setColumns(10);
					
					JLabel lblIdClient = new JLabel("ID client");
					lblIdClient.setBounds(10, 97, 75, 14);
					info_panel.add(lblIdClient);
					
					JLabel lblMontant = new JLabel("Montant");
					lblMontant.setBounds(10, 131, 56, 14);
					info_panel.add(lblMontant);
					
					JTextField Montant_textField = new JTextField();
					Montant_textField.setBounds(116, 128, 86, 20);
					info_panel.add(Montant_textField);
					Montant_textField.setColumns(10);
					
					JLabel lblDure = new JLabel("Dur\u00E9e");
					lblDure.setBounds(10, 165, 46, 14);
					info_panel.add(lblDure);
					
					JTextField Duree_textField = new JTextField();
					Duree_textField.setBounds(116, 162, 86, 20);
					info_panel.add(Duree_textField);
					Duree_textField.setColumns(10);
					
					JLabel label = new JLabel("");
					label.setBounds(10, 190, 19, 20);
					info_panel.add(label);
					
					JLabel lblTaux = new JLabel("Taux");
					lblTaux.setBounds(10, 201, 46, 14);
					info_panel.add(lblTaux);
					
					JTextField Taux_textField = new JTextField();
					Taux_textField.setBounds(116, 198, 86, 20);
					info_panel.add(Taux_textField);
					Taux_textField.setColumns(10);
					
					JButton btnSimuler = new JButton("Simuler");
					btnSimuler.setBounds(241, 245, 89, 23);
					info_panel.add(btnSimuler);
					
					JLabel lblEuro = new JLabel("euro");
					lblEuro.setBounds(225, 131, 46, 14);
					info_panel.add(lblEuro);
					
					JLabel lblAns = new JLabel("ans");
					lblAns.setBounds(225, 165, 46, 14);
					info_panel.add(lblAns);
					
					JLabel label_2 = new JLabel("%");
					label_2.setBounds(225, 196, 46, 14);
					info_panel.add(label_2);

					/*
					 * lblMessageLog = new JLabel();
					 * //lblMessageLog.setText("Process to login failed");
					 * lblMessageLog.setBounds(300,35,200,50);
					 * 
					 * while(rs.next()){ int id=rs.getInt("ID_Employee"); int
					 * agency=rs.getInt("ID_Agency"); String
					 * firstName=rs.getString("Employee_first_name"); String
					 * lastName=rs.getString("Employee_last_name"); String
					 * email=rs.getString("Employee_email"); String
					 * telNum=rs.getString("Tel_num"); conseiller = new
					 * Employee(agency, lastName, firstName, email, telNum);
					 * System.out.println(firstName);
					 * 
					 * lblMessageLog.removeAll();
					 * lblMessageLog.setText("Loged");
					 * 
					 * 
					 * lblFirstName = new
					 * JLabel("First name : "+conseiller.getFirstName());
					 * lblFirstName.setBounds(300, 50,200, 50);
					 * 
					 * lblLastName = new
					 * JLabel("Last name : "+conseiller.getLastName());
					 * lblLastName.setBounds(300,65,200,50);
					 * 
					 * lblEmail = new JLabel("email : "+conseiller.getEmail());
					 * lblEmail.setBounds(300,80,200,50);
					 * 
					 * 
					 * panel.add(lblEmail); panel.add(lblLastName);
					 * panel.add(lblFirstName); }
					 * 
					 * panel.add(lblMessageLog); panel.updateUI();
					 */

				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		});
		btnLogin.setBounds(253, 169, 89, 23);
		panel.add(btnLogin);
		

	}

	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	

}
