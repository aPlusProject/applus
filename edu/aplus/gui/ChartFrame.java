package edu.aplus.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ChartFrame extends JFrame {

	private JPanel mainPanel;
	private JLabel titleLabel;
	public ChartFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 220, 500, 400);
		
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		titleLabel = new JLabel("Chart GUI");
		titleLabel.setBounds(100, 50, 100, 50);
		mainPanel.add(titleLabel);
	}
}
