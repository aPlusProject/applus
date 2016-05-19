package edu.aplus.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.aplus.gui.AllClientsDisplayPanel;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

public class ConnectionPanel extends JFrame {

	private static final String ALLCLIENTS = "allClientsDisplay";
	private JPanel mainPanel = new JPanel();
	private AllClientsDisplayPanel allClientsPanel;
	private JButton connection = new JButton("Connexion");
	// private JButton exit = new JButton("Exit");
	private JButton exit;

	public ConnectionPanel() {
		mainPanel.setLayout(new FlowLayout());
		connection = new JButton("Connexion");
		exit = new JButton("exit");

		mainPanel.add(new JLabel("Interface de connexion"));
		mainPanel.add(connection);
		mainPanel.add(exit);

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ConnectionPanel");
				allClientsPanel = new AllClientsDisplayPanel();
				Window win = SwingUtilities.getWindowAncestor(allClientsPanel.getMainComponent());
				win.dispose();
			}
		
		});

	}

	public void addConnectionActionListener(ActionListener listener) {
		connection.addActionListener(listener);
	}

	public JComponent getMainComponent() {
		return mainPanel;
	}

}
