package edu.aplus.metier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.aplus.metier.InterestRisk;
import edu.aplus.metier.main;
import edu.aplus.metier.ChooseLoanType;

/* This class is a form in order to catch the information about a profile client and see what is the impact if we increase or 
 * decrease the rate interest for him.
 * For that we need to have 6 parameters ( explained in javadoc interestRisk.java)
 */

public class FrameProfile  extends JFrame{


	static int salary;
	static String etatSante ;
	static String status ;
	static int charge;
	static int credit ;
	static int age ;
	private InterestRisk risk;


	

	public FrameProfile (){
			this.risk = new InterestRisk(salary, etatSante, status, credit, age, charge);

		setBounds(100, 100, 600, 400);
		setTitle ("Profil du client");
		getContentPane().setLayout(null);
		getContentPane().setBounds(100, 100, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		JLabel setAge = new JLabel("Age: ");
		setAge.setBounds(10,10,100,20);
		final JTextField getAge = new JTextField();
		getAge.setBounds(120,10,100,20);

		JLabel setSalary = new JLabel("Salaire: ");
		setSalary.setBounds(10,40,100,20);
		final JTextField getSalary = new JTextField();
		getSalary.setBounds(120,40,100,20);

		JLabel setCharge = new JLabel("Charges: ");
		setCharge.setBounds(10,70,100,20);
		final JTextField getCharge = new JTextField();
		getCharge.setBounds(120,70,100,20);

		JLabel setCredit = new JLabel("Crédits en cours: ");
		setCredit.setBounds(10,100,160,20);
		final JTextField getCredit = new JTextField();
		getCredit.setBounds(120,100,100,20);

		JLabel setStatus = new JLabel("Type de contrat: ");
		setStatus.setBounds(10,130,160,20);
		final JTextField getStatus = new JTextField();
		getStatus.setBounds(120,130,100,20);

		JLabel setHealth = new JLabel("Etat de santé: ");
		setHealth.setBounds(10,160,160,20);
		final JTextField getHealth = new JTextField();
		getHealth.setBounds(120,160,100,20);

		final JTextArea listRisk = new JTextArea("Les risques ici...", 10, 20);
		listRisk.setBounds(60,250,600,100);


		JButton seeRisk = new JButton("Risques");
		seeRisk.setBounds(60,190,100,20);
		seeRisk.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent actionEvent) {
				String salaryS,ageS,creditS,chargeS;
				salaryS = getSalary.getText();
				ageS = getAge.getText();
				etatSante = getHealth.getText();
				status = getStatus.getText();
				chargeS = getCharge.getText();
				creditS = getCredit.getText();
				salary = Integer.parseInt(salaryS);
				age = Integer.parseInt(ageS) ;
				credit = Integer.parseInt(creditS) ;
				charge =Integer.parseInt(chargeS) ;
						
		
				risk = new InterestRisk (salary,etatSante, status, credit, age, charge);
				final String myRisk = risk.Risk();
				
				listRisk.setText(myRisk);

			} });




		getContentPane().add(getAge);
		getContentPane().add(setAge);
		getContentPane().add(getSalary);
		getContentPane().add(setSalary);
		getContentPane().add(getCharge);
		getContentPane().add(setCharge);
		getContentPane().add(getCredit);
		getContentPane().add(setCredit);
		getContentPane().add(getStatus);
		getContentPane().add(setStatus);
		getContentPane().add(getHealth);
		getContentPane().add(setHealth);
		getContentPane().add(seeRisk);
		getContentPane().add(listRisk);


		setVisible(true);

	}
	
	public static int getCharge(){return FrameProfile.charge;}
	public static void setCharge(int charge){FrameProfile.charge = charge;}

	public static int getSalary(){return FrameProfile.salary;}
	public static void setSalary(int salary){FrameProfile.salary = salary;}

	public static int getCredit(){return FrameProfile.credit;}
	public static void setCredit(int credit){FrameProfile.credit = credit;}

	public  static int getAge(){return FrameProfile.age;}
	public static void setAge(int age){FrameProfile.age = age;}

	public static String getStatus(){return FrameProfile.status;}
	public static void setStatus(String status){FrameProfile.status = status;}

	public static String getHealth(){return FrameProfile.etatSante;}
	public  void setHealth(String etatSante){FrameProfile.etatSante = etatSante;}



}