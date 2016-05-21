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
	private JTextField amount;
	private JLabel amountL;
	private JTextField duration;
	private JLabel durationL;
	private JTextField rate;
	private JLabel rateL;
	private JButton bouton;

	public SimulatoinPanel() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(3, 3, 3, 3));
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
		salary.setBounds(150, 80, 50, 20);
		panel.add(salary);
		salary.setColumns(20);
		
		chargeL = new JLabel("Charge total : ");
		chargeL.setBounds(20, 120, 150, 15);
		panel.add(chargeL);
		
		charge = new JTextField();
		charge.setBounds(150, 120, 50, 20);
		panel.add(charge);
		charge.setColumns(2);
		
		debtRateL = new JLabel("Taux d'endettement : ");
		debtRateL.setBounds(20, 160, 150, 15);
		panel.add(debtRateL);
		
		debtRate = new JTextField();
		debtRate.setBounds(150, 160, 50, 20);
		panel.add(debtRate);
		debtRate.setColumns(2);
		
		amountL = new JLabel("Montant du prêt : ");
		amountL.setBounds(230, 80, 200, 15);
		panel.add(amountL);
		
		amount = new JTextField();
		amount.setBounds(370, 80, 50, 20);
		panel.add(amount);
		amount.setColumns(2);
		
		durationL = new JLabel("Durée du prêt : ");
		durationL.setBounds(230, 120, 200, 15);
		panel.add(durationL);
		
		duration = new JTextField();
		duration.setBounds(370, 120, 50, 20);
		panel.add(duration);
		duration.setColumns(2);
		
		rateL = new JLabel("Taux d'intérêt du prêt : ");
		rateL.setBounds(230, 160, 250, 15);
		panel.add(rateL);
		
		rate = new JTextField();
		rate.setBounds(370, 160, 50, 20);
		panel.add(rate);
		rate.setColumns(2);
		
		bouton = new JButton("Enter");
		bouton.setBounds(170, 250, 100, 20);
		panel.add(bouton);
		
	    //Add action listener to button
	    bouton.addActionListener(new ActionListener() {
	    	
	    public void actionPerformed(ActionEvent e){
	    		//Execute when button is pressed
	    		SimulatorFixedRate simulator = new SimulatorFixedRate();
	    		int i = Integer.parseInt(amount.getText());
	    		try {
					simulator.getClientByID(i);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
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

	// a remplir
public void remplir(Client client) {
	salary.setText(client.getSalary());
	charge.setText(client.getCharge());
	debtRate.setText(client.getDebtRate());
}
	
}