package edu.aplus.client.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	
	
	private JButton gotoIndicatorsBtn;
	private ActionListener action;

	/**
	 * The MainPanel display all use case define in the project
	 */
	public MainPanel() {
		
		//go to indicators use case
		gotoIndicatorsBtn = new JButton("Voir les indicateurs");
		add(gotoIndicatorsBtn);

	}
	
	/**
	 * 
	 * @param actionListener 
	 */
	public void setActionListener(ActionListener actionListener) {
		
		gotoIndicatorsBtn.addActionListener(actionListener);
		
	}
	
	

}
