package edu.aplus.client.panel;

import java.awt.FlowLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConnexionPanel extends JPanel {
	
	private JTextField tfLogin;
	private JTextField tfPwd;

	/**
	 * Create the panel.
	 */
	public ConnexionPanel() {
		setBorder(new EmptyBorder(50, 50, 50, 50));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblLogin = new JLabel("Login");
		add(lblLogin);
		
		tfLogin = new JTextField();
		add(tfLogin);
		tfLogin.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		add(lblMotDePasse);
		
		tfPwd = new JTextField();
		add(tfPwd);
		tfPwd.setColumns(10);
		
		JButton btnConnexion = new JButton("Connexion");
		add(btnConnexion);

	}

}
