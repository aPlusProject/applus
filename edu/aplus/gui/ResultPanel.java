package edu.aplus.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ResultPanel extends JFrame{
	
	private JPanel panel;
	private JLabel resultL;
	private JTextField result;
	private JLabel amountL;
	private JTextField amount;
	private JLabel durationL;
	private JTextField duration;
	private JLabel rateL;
	private JTextField rate;
	private JLabel installationWithoutInsL;
	private JTextField installationWithoutIns;
	private JLabel rateInsuranceL;
	private JTextField rateInsurance;
	private JLabel installationWithInsL;
	private JTextField installationWithIns;
	private JLabel totalL;
	private JTextField total;
	
	public ResultPanel(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
	}
}
