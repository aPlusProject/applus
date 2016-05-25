package edu.aplus.client.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class mainPanel extends JPanel {
	
	
	private JButton gotoIndicatorsBtn;
	private ActionListener action;

	/**
	 * Create the panel.
	 */
	public mainPanel() {
		
		gotoIndicatorsBtn = new JButton("Voir les indicateurs");
		
		add(gotoIndicatorsBtn);

	}
	
	
	public void setActionListener(ActionListener actionListener) {
		
		gotoIndicatorsBtn.addActionListener(actionListener);
		
	}
	
	

}
