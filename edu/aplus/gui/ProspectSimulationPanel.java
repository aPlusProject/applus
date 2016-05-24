package edu.aplus.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import edu.aplus.business.SimulatorFixedRate;
import edu.aplus.model.Client;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class SimulatoinPanel  extends JFrame{

	private JPanel panel;
	private JLabel title1;
	private JLabel title2;
	private JTextField salary;
	private JLabel salaryL;
	private JTextField charge;
	private JLabel chargeL;
	private JTextField debtRate;
	private JLabel debtRateL;
	private JComboBox creditType;
	private JLabel creditTypeL;
	private JTextField amount = null;
	private JLabel amountL;
	private JTextField duration;
	private JLabel durationL;
	private JTextField rate;
	private JLabel rateL;
	private JTextField rateInsurance;
	private JLabel rateInsuranceL;
	private JButton bouton;
	private String[] possibleValues = {"Crédit Immobilier","Crédit Personnel","Crédit Professionnel"};

	public SimulatoinPanel() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 220, 500, 400);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(panel);
		panel.setLayout(null);
		
		title1 = new JLabel("Données financières du client : ");
		title1.setBounds(20, 20, 200, 30);
		panel.add(title1);
		
		title2 = new JLabel("Renseignez les données du prêt : ");
		title2.setBounds(230, 20, 200, 30);
		panel.add(title2);
		
		salaryL = new JLabel("Revenu total : ");
		salaryL.setBounds(20, 80, 150, 15);
		panel.add(salaryL);
		
		salary = new JTextField();
		salary.setBounds(150, 80, 60, 20);
		panel.add(salary);
		salary.setColumns(20);
		
		chargeL = new JLabel("Charge total : ");
		chargeL.setBounds(20, 120, 150, 15);
		panel.add(chargeL);
		
		charge = new JTextField();
		charge.setBounds(150, 120, 60, 20);
		panel.add(charge);
		charge.setColumns(2);
		
		debtRateL = new JLabel("Taux d'endettement : ");
		debtRateL.setBounds(20, 160, 150, 15);
		panel.add(debtRateL);
		
		debtRate = new JTextField();
		debtRate.setBounds(150, 160, 60, 20);
		panel.add(debtRate);
		debtRate.setColumns(2);
		

		creditTypeL = new JLabel("Type du prêt : ");
		creditTypeL.setBounds(230, 80, 200, 15);
		panel.add(creditTypeL);
		 	
		creditType = new JComboBox(possibleValues);
		creditType.setBounds(370, 80, 100, 20);
		panel.add(creditType);
		
		amountL = new JLabel("Montant du prêt : ");
		amountL.setBounds(230, 120, 200, 15);
		panel.add(amountL);
		
		amount = new JTextField();
		amount.setBounds(370, 120, 100, 20);
		panel.add(amount);
		amount.setColumns(2);
		
		durationL = new JLabel("Durée du prêt : ");
		durationL.setBounds(230, 160, 200, 15);
		panel.add(durationL);
		
		duration = new JTextField();
		duration.setBounds(370, 160, 100, 20);
		panel.add(duration);
		duration.setColumns(2);
		
		rateL = new JLabel("Taux d'intérêt : ");
		rateL.setBounds(230, 200, 250, 15);
		panel.add(rateL);
		
		rate = new JTextField();
		rate.setBounds(370, 200, 100, 20);
		panel.add(rate);
		rate.setColumns(2);
		
		rateInsuranceL = new JLabel("Taux d'assurance : ");
		rateInsuranceL.setBounds(230, 240, 250, 15);
		panel.add(rateInsuranceL);
		
		rateInsurance = new JTextField();
		rateInsurance.setBounds(370, 240, 100, 20);
		panel.add(rateInsurance);
		rateInsurance.setColumns(2);
		
		bouton = new JButton("Enter");
		bouton.setBounds(190, 300, 100, 20);
		panel.add(bouton);
		
		final String amountEntS = amount.getText();
		final String durationEntS = duration.getText();
		final String rateEntS = rate.getText();
		final String rateInsuranceEntS = rateInsurance.getText();
		final String creditTypeEnt = creditType.getName();
		final int amountEnt = Integer.parseInt(amountEntS);
		final int durationEnt = Integer.parseInt(durationEntS);
		final float rateEnt = Float.parseFloat(rateEntS);
		final int rateInsuranceEnt = Integer.parseInt(rateInsuranceEntS);
		
	    //Add action listener to button
	    bouton.addActionListener(new ActionListener() {
	    	
	    public void actionPerformed(ActionEvent e){
	    	
	    	SimulatorFixedRate simulator = new SimulatorFixedRate();
	    	simulator.simulate(creditTypeEnt, amountEnt, durationEnt, rateEnt);
	    	ResultPanel frame1 = new ResultPanel();
			frame1.setVisible(true);	
	        }
	    	
	    }); 
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimulatoinPanel frame1 = new SimulatoinPanel();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}