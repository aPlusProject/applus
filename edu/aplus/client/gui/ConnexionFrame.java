package edu.aplus.client.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.SwingConstants;

public class ConnexionFrame extends JFrame {

	private ConnexionPanel connexionPanel;
	private JTextField textField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnexionFrame frame = new ConnexionFrame();
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
	public ConnexionFrame() {
		setTitle("Connexion \u00E0 l'application Bureau");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 472);
		connexionPanel = new ConnexionPanel();
		setContentPane(connexionPanel);
		
		
	}

}
