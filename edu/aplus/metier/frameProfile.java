package edu.aplus.metier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.aplus.metier.interestRisk;
import edu.aplus.metier.main;
import edu.aplus.metier.ChooseLoanType;

/* This class is a form in order to catch the information about a profile client and see what is the impact if we increase or 
 * decrease the rate interest for him.
 * For that we need to have 6 parameters ( explained in javadoc interestRisk.java)
 */

public class frameProfile  extends JFrame{


	static int salary;
	static String etatSante ;
	static String status ;
	static int charge;
	static int credit ;
	static int age ;
	private interestRisk risk;


	public static int getCharge(){return frameProfile.charge;}
	public static void setCharge(int charge){frameProfile.charge = charge;}

	public static int getSalary(){return frameProfile.salary;}
	public static void setSalary(int salary){frameProfile.salary = salary;}

	public static int getCredit(){return frameProfile.credit;}
	public static void setCredit(int credit){frameProfile.credit = credit;}

	public  static int getAge(){return frameProfile.age;}
	public static void setAge(int age){frameProfile.age = age;}

	public static String getStatus(){return frameProfile.status;}
	public static void setStatus(String status){frameProfile.status = status;}

	public static String getHealth(){return frameProfile.etatSante;}
	public  void setHealth(String etatSante){frameProfile.etatSante = etatSante;}


	public frameProfile (){
		//	this.risk = new interestRisk(salary, etatSante, status, charge, credit, age);

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
				risk = new interestRisk(salary, etatSante, status, charge, credit, age);
				final String myRisk = risk.Risk();
				salary = Integer.parseInt(getSalary.getText().trim());
				etatSante = getHealth.getText();
				status = getStatus.getText();
				charge = Integer.parseInt(getCharge.getText().trim());
				credit = Integer.parseInt(getCredit.getText().trim());
				age = Integer.parseInt(getAge.getText().trim());
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


}