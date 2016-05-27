package edu.aplus.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import edu.aplus.business.SimulatorFixedRate;
import edu.aplus.model.Client;
import edu.aplus.model.Loan;
import edu.client.model.Chart;
import edu.client.socket.ChartTCPClient;

public class ResultPanel extends JFrame{
	
	private JPanel panel;
	private JLabel creditTypeL;
	private JTextField creditType;
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
	private JButton chartButton;
	
	public ResultPanel(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 220, 500, 400);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(panel);
		panel.setLayout(null);
		
		creditTypeL = new JLabel("D�cision de la simulation : ");
		creditTypeL.setBounds(50, 20, 200, 30);
		panel.add(creditTypeL);
		
		creditType = new JTextField();
		creditType.setBounds(250, 20, 200, 30);
		panel.add(creditType);
		
		amountL = new JLabel("Montant emprunt� : ");
		amountL.setBounds(50, 50, 200, 30);
		panel.add(amountL);
		
		amount = new JTextField();
		amount.setBounds(250, 50, 200, 30);
		panel.add(amount);
		
		durationL = new JLabel("Dur�e (nb mois) : ");
		durationL.setBounds(50, 80, 200, 30);
		panel.add(durationL);
		
		duration = new JTextField();
		duration.setBounds(250, 80, 200, 30);
		panel.add(duration);
		
		rateL = new JLabel("Taux d'int�r�t fixe : ");
		rateL.setBounds(50, 110, 200, 30);
		panel.add(rateL);
		
		rate = new JTextField();
		rate.setBounds(250, 110, 200, 30);
		panel.add(rate);
		
		installationWithoutInsL = new JLabel("Mensualit� hors assurance : ");
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
		
		installationWithInsL = new JLabel("Mensualit� avec assurance : ");
		installationWithInsL.setBounds(70, 230, 200, 30);
		panel.add(installationWithInsL);
		
		installationWithIns = new JTextField();
		installationWithIns.setBounds(270, 230, 200, 30);
		panel.add(installationWithIns);
		
		totalL = new JLabel("Co�t total du cr�dit : ");
		totalL.setBounds(70, 270, 200, 30);
		panel.add(totalL);
		
		total = new JTextField();
		total.setBounds(270, 270, 200, 30);
		panel.add(total);
		
		chartButton = new JButton("Show chart");
		chartButton.setBounds(330, 320, 100, 40);
		panel.add(chartButton);
		
		JButton saveButton = new JButton("Save loan");
		saveButton.setBounds(230, 320, 100, 40);
		panel.add(saveButton);
		
		chartButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("Button cliked");
				try {
					ChartTCPClient clientSocket = new ChartTCPClient("LineChart");
				} catch (ClassNotFoundException | IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}
	
	public static void main (String[] args){
		ResultPanel frame1 = new ResultPanel();
		frame1.setVisible(true);
	}
	public void remplir(Loan loan) {
		String aM = String.valueOf(loan.getAskesAmount());
		amount.setText(aM);
		String aD = String.valueOf(loan.getAskedDuration() * 12);
		duration.setText(aD);
		String aR = String.valueOf(loan.getAskedRate());
		rate.setText(aR);
		String aRI = String.valueOf(loan.getAskedRateInsurance());
		rateInsurance.setText(aRI);
		SimulatorFixedRate simulator = new SimulatorFixedRate();
    	double d1 = simulator.calculateInstallment(null, loan.getAskesAmount(), loan.getAskedDuration(), loan.getAskedRate());
    	String s = String.valueOf(d1);
    	installationWithoutIns.setText(s);
    	double d2 = simulator.calculateFinalInstallment(null, loan.getAskesAmount(), loan.getAskedDuration(), loan.getAskedRate(), loan.getAskedRateInsurance());
    	String s1 = String.valueOf(d2);
    	installationWithIns.setText(s1);
    	double t = loan.getAskesAmount() + (loan.getAskedRate() + loan.getAskedRateInsurance())*loan.getAskedDuration();
    	total.setText(String.valueOf(t));
    	
		
		//amountAsked = SimulatoinPanel.getAmount();
		//amount.setText();
		//charge.setText(client.getCharge());
		//debtRate.setText(client.getDebtRate());
	}
}