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
		setBounds(200, 220, 500, 400);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(panel);
		panel.setLayout(null);
		
		resultL = new JLabel("Décision de la simulation : ");
		resultL.setBounds(50, 20, 200, 30);
		panel.add(resultL);
		
		result = new JTextField();
		result.setBounds(250, 20, 200, 30);
		panel.add(result);
		
		amountL = new JLabel("Montant emprunté : ");
		amountL.setBounds(50, 50, 200, 30);
		panel.add(amountL);
		
		amount = new JTextField();
		amount.setBounds(250, 50, 200, 30);
		panel.add(amount);
		
		durationL = new JLabel("Durée (nb mois) : ");
		durationL.setBounds(50, 80, 200, 30);
		panel.add(durationL);
		
		duration = new JTextField();
		duration.setBounds(250, 80, 200, 30);
		panel.add(duration);
		
		rateL = new JLabel("Taux d'intérêt fixe : ");
		rateL.setBounds(50, 110, 200, 30);
		panel.add(rateL);
		
		rate = new JTextField();
		rate.setBounds(250, 110, 200, 30);
		panel.add(rate);
		
		installationWithoutInsL = new JLabel("Mensualité hors assurance : ");
		installationWithoutInsL.setBounds(70, 150, 200, 30);
		panel.add(installationWithoutInsL);
		
		installationWithoutIns = new JTextField();
		installationWithoutIns.setBounds(270, 150, 200, 30);
		panel.add(installationWithoutIns);
		
		rateInsuranceL = new JLabel("Taux d'assurance : ");
		rateInsuranceL.setBounds(50, 190, 200, 30);
		panel.add(rateInsuranceL);
		
		rateInsurance = new JTextField();
		rateInsurance.setBounds(250, 190, 200, 30);
		panel.add(rateInsurance);
		
		installationWithInsL = new JLabel("Mensualité avec assurance : ");
		installationWithInsL.setBounds(70, 230, 200, 30);
		panel.add(installationWithInsL);
		
		installationWithIns = new JTextField();
		installationWithIns.setBounds(270, 230, 200, 30);
		panel.add(installationWithIns);
		
		totalL = new JLabel("Coût total du crédit : ");
		totalL.setBounds(70, 270, 200, 30);
		panel.add(totalL);
		
		total = new JTextField();
		total.setBounds(270, 270, 200, 30);
		panel.add(total);	
		
	}
	
	public static void main (String[] args){
		ResultPanel frame1 = new ResultPanel();
		frame1.setVisible(true);
	}
}