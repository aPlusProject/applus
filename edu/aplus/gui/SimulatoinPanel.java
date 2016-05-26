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
import edu.aplus.model.Loan;

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
	private String[] possibleValues = {"Cr�dit Immobilier","Cr�dit Personnel","Cr�dit Professionnel"};

	public SimulatoinPanel() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 220, 500, 400);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(panel);
		panel.setLayout(null);
		
		title1 = new JLabel("Donn�es financi�res du client : ");
		title1.setBounds(20, 20, 200, 30);
		panel.add(title1);
		
		title2 = new JLabel("Renseignez les donn�es du pr�t : ");
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
		

		creditTypeL = new JLabel("Type du pr�t : ");
		creditTypeL.setBounds(230, 80, 200, 15);
		panel.add(creditTypeL);
		 	
		creditType = new JComboBox(possibleValues);
		creditType.setBounds(370, 80, 100, 20);
		panel.add(creditType);
		
		amountL = new JLabel("Montant du pr�t : ");
		amountL.setBounds(230, 120, 200, 15);
		panel.add(amountL);
		
		setAmount(new JTextField());
		getAmount().setBounds(370, 120, 100, 20);
		panel.add(getAmount());
		getAmount().setColumns(2);
		
		durationL = new JLabel("Dur�e du pr�t : ");
		durationL.setBounds(230, 160, 200, 15);
		panel.add(durationL);
		
		duration = new JTextField();
		duration.setBounds(370, 160, 100, 20);
		panel.add(duration);
		duration.setColumns(2);
		
		rateL = new JLabel("Taux d'int�r�t : ");
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
		
		final JLabel d = new JLabel("Resultat : ");
		d.setBounds(190, 330, 250, 15);
		panel.add(d);
		
		
		
	    //Add action listener to button
	    bouton.addActionListener(new ActionListener() {
	    	
	    public void actionPerformed(ActionEvent e){
	    	
	    	Loan loan = new Loan();
	    
	    	String amountEntS = getAmount().getText();
			String durationEntS = duration.getText();
			String rateEntS = rate.getText();
			String rateInsuranceEntS = rateInsurance.getText();
			String creditTypeEnt = creditType.getName();
			int amountEnt = Integer.parseInt(amountEntS);
			int durationEnt = Integer.parseInt(durationEntS);
			float rateEnt = Float.parseFloat(rateEntS);
			float rateInsuranceEnt = Float.parseFloat(rateInsuranceEntS);
	    	
			loan.setAskedAmount(amountEnt);
			loan.setAskedDuration(durationEnt);
			loan.setAskedRate(rateEnt);
			loan.setAskedRateInsurance(rateInsuranceEnt);
	    	
			SimulatorFixedRate simulator = new SimulatorFixedRate();
			ResultPanel frame1 = new ResultPanel();
			frame1.remplir(loan);
			frame1.setVisible(true);	
			
	    //	double d1 = simulator.calculateInstallment(creditTypeEnt, amountEnt, durationEnt, rateEnt);
	    	//String s = String.valueOf(d1);
	    	//d.setText(s);
	    	
	    	
	    	
	    	
	    	
	    
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

public JTextField getAmount() {
	return amount;
}

public void setAmount(JTextField amount) {
	this.amount = amount;
}
	
}