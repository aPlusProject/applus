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

import javax.sql.DataSource;
import javax.swing.JButton;

import applus.DBConnector;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPanel extends JFrame implements Observer{

	private JPanel loginPanel;
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
					MainPanel frame = new MainPanel();
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
	public MainPanel() throws ClassNotFoundException, SQLException {
		setTitle("Fenêtre de login"); 
		setSize(500, 350); 
		setLocationRelativeTo(null); 
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginPanel = new JPanel();
		loginPanel.setLayout(null);
		setContentPane(loginPanel);

		JLabel lblBankName = new JLabel("Login page");
		lblBankName.setBounds(172, 11, 76, 14);
		loginPanel.add(lblBankName);

		JLabel lblId = new JLabel("email");
		lblId.setBounds(81, 77, 46, 14);
		loginPanel.add(lblId);

		emailTextField = new JTextField();
		emailTextField.setBounds(162, 74, 86, 20);
		loginPanel.add(emailTextField);

		lblPassword = new JLabel("Password");
		lblPassword.setBounds(81, 131, 71, 14);
		loginPanel.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(162, 128, 86, 20);
		loginPanel.add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			private JLabel lblLastName;
			private JLabel lblEmail;
			private JLabel lblMessageLog;
			private boolean flag = false;

			public void actionPerformed(ActionEvent arg0) {
				try {
					System.out.println("bouton pressed.");
					DataSource ds = DBConnector.createDataSource();
					co = ds.getConnection();
					queryConnect = "Select * FROM Employee WHERE employee_email='"
							+ emailTextField.getText()
							+ "' AND tel_num='"
							+ new String(passwordField.getPassword()) + "'";
					ps = co.prepareStatement(queryConnect);
					ResultSet rs = ps.executeQuery();
					System.out.println("query executed.");
					while (rs.next()) {
						System.out.println("trying to read data...");
						int id = rs.getInt("ID_Employee");
						int agency = rs.getInt("ID_Agency");
						String firstName = rs.getString("Employee_first_name");
						String lastName = rs.getString("Employee_last_name");
						String email = rs.getString("Employee_email");
						String telNum = rs.getString("Tel_num");
						conseiller = new Employee(agency, lastName, firstName,
								email, telNum);
						System.out.println("reading of data done.");
						loginPanel.setVisible(false);
						
						flag = true;
						
					}
					
					if (flag) {
						System.out.println("lauche of simulate panel...");
						setTitle("Fenetre de simulation");
						JPanel simulationPanel = new JPanel();
						setContentPane(simulationPanel);
						simulationPanel.setVisible(true);
						simulationPanel.setLayout(null);
						
						JLabel nameLabel = new JLabel(conseiller.getFirstName() + " " + conseiller.getLastName());
						nameLabel.setBounds(10, 11, 418, 14);
						simulationPanel.add(nameLabel);
						
						JLabel emailLabel = new JLabel("email : "+conseiller.getEmail());
						emailLabel.setBounds(10, 36, 418, 14);
						simulationPanel.add(emailLabel);
						
						JLabel telLabel = new JLabel("tel : "+conseiller.getTelNum());
						telLabel.setBounds(10, 50, 418, 14);
						simulationPanel.add(telLabel);
						
						JTextField IDtextField = new JTextField();
						IDtextField.setBounds(116, 97, 86, 20);
						simulationPanel.add(IDtextField);
						IDtextField.setColumns(10);
						
						JLabel lblIdClient = new JLabel("ID client");
						lblIdClient.setBounds(10, 97, 75, 14);
						simulationPanel.add(lblIdClient);
						
						JLabel lblMontant = new JLabel("Montant");
						lblMontant.setBounds(10, 131, 56, 14);
						simulationPanel.add(lblMontant);
						
						JTextField Montant_textField = new JTextField();
						Montant_textField.setBounds(116, 128, 86, 20);
						simulationPanel.add(Montant_textField);
						Montant_textField.setColumns(10);
						
						JLabel lblDure = new JLabel("Dur\u00E9e");
						lblDure.setBounds(10, 165, 46, 14);
						simulationPanel.add(lblDure);
						
						JTextField Duree_textField = new JTextField();
						Duree_textField.setBounds(116, 162, 86, 20);
						simulationPanel.add(Duree_textField);
						Duree_textField.setColumns(10);
						
						JLabel label = new JLabel("");
						label.setBounds(10, 190, 19, 20);
						simulationPanel.add(label);
						
						JLabel lblTaux = new JLabel("Taux");
						lblTaux.setBounds(10, 201, 46, 14);
						simulationPanel.add(lblTaux);
						
						JTextField Taux_textField = new JTextField();
						Taux_textField.setBounds(116, 198, 86, 20);
						simulationPanel.add(Taux_textField);
						Taux_textField.setColumns(10);
						
						JButton btnSimuler = new JButton("Simuler");
						btnSimuler.setBounds(241, 245, 89, 23);
						simulationPanel.add(btnSimuler);
						
						JLabel lblEuro = new JLabel("euro");
						lblEuro.setBounds(225, 131, 46, 14);
						simulationPanel.add(lblEuro);
						
						JLabel lblAns = new JLabel("ans");
						lblAns.setBounds(225, 165, 46, 14);
						simulationPanel.add(lblAns);
						
						JLabel label_2 = new JLabel("%");
						label_2.setBounds(225, 196, 46, 14);
						simulationPanel.add(label_2);
					} else {
						System.out.println("query do not pass");
					}

					
				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		});
		btnLogin.setBounds(253, 169, 89, 23);
		loginPanel.add(btnLogin);
		

	}

	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	

}
