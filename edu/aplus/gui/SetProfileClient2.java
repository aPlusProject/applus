package edu.aplus.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import org.junit.experimental.categories.Categories;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.aplus.business.SimulatorFixedRate;
import edu.aplus.metier.*;
import edu.aplus.model.Client;
import edu.aplus.model.Loan;
import edu.aplus.model.Rate;
import edu.aplus.service.JsonParser_new;
import edu.client.socket.RateTCPClient;
import edu.client.socket.TCPClient;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import edu.aplus.gui.SearchRatePanel2;

public class SetProfileClient2  extends JFrame{

	private static final String Clientid = null;
	private JComboBox loanType;
	private JComboBox duration;
	private JPanel panel;
	private JLabel durationL;
	private JLabel salaryL;
	private JLabel chargeL;
	private JLabel creditL;
	private JLabel statusL;
	private JLabel etatSanteL;
	private JLabel ageL;
	private JLabel creditTypeL;
	private JTextField salary;
	private JTextField charge;
	private JTextField credit;
	private JTextField status;
	private JTextField etatSante;
	private static JRadioButton good ;
	private static JRadioButton bad;
	private ButtonGroup health ;
	private JTextField age;
	private JButton bouton;
	private JButton reset;
	private JTextField rateT;
	private JLabel rateL;
	private JLabel precisionSalary;
	private JLabel precisionStatus;
	private JLabel precisionCharge;
	private JLabel precisionCredit;
	private JLabel precisionAge;
	private JButton evaluer;
	private JButton enregistrer;
	private static int ageT;
	private static int salaryT;
	private static int chargeT;
	private static int creditT;
	private static String etatSanteT;
	private static String statusT;
	private JTextArea risques;
	String receivedMsg;
	double newRateReceived;
	
	Rate rate ;
	SearchRatePanel2 srp = new SearchRatePanel2(loanType,duration); 
	Client client = null;
	double rateReceived;
	public SetProfileClient2(final double rateReceived) throws UnknownHostException, ClassNotFoundException, IOException, InterruptedException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 220, 600, 600);
		final String loanType =srp.getSelectedLoanType();
		final int durationLoan = srp.getSelectedDuration();
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(panel);
		panel.setLayout(null);
		
		rateL = new JLabel("Donnez les informations personnelles du client");
		rateL.setBounds(45, 40, 300,15);
		panel.add(rateL);
		
		salaryL = new JLabel("Revenu total:  ");
		salaryL.setBounds(20, 80, 150, 15);
		panel.add(salaryL);
		
		salary = new JTextField();
		salary.setBounds(150, 80, 60, 20);
		panel.add(salary);
		
		precisionSalary = new JLabel("euros/mois");
		precisionSalary.setBounds(320, 80, 150, 15);
		panel.add(precisionSalary);
		
		chargeL = new JLabel("Charge total:  ");
		chargeL.setBounds(20, 110, 150, 15);
		panel.add(chargeL);
		
		precisionCharge = new JLabel("euros/mois");
		precisionCharge.setBounds(320, 110, 150, 15);
		panel.add(precisionCharge);
		
		charge = new JTextField();
		charge.setBounds(150, 110, 60, 20);
		panel.add(charge);
		
		ageL = new JLabel("Age: ");
		ageL.setBounds(20, 140, 140, 15);
		panel.add(ageL);
		
		age = new JTextField();
		age.setBounds(150, 140, 150, 20);
		panel.add(age);
		
		precisionAge = new JLabel("ans");
		precisionAge.setBounds(320, 140, 150, 15);
		panel.add(precisionAge);

		creditL = new JLabel("Credit: ");
		creditL.setBounds(20, 170, 200, 15);
		panel.add(creditL);
		
		credit = new JTextField();
		credit.setBounds(150, 170, 60, 20);
		panel.add(credit);
		
		precisionCredit = new JLabel("euros/mois");
		precisionCredit.setBounds(320, 170, 150, 15);
		panel.add(precisionCredit);
		
		etatSanteL = new JLabel("Etat de santé: ");
		etatSanteL.setBounds(20, 200, 200, 15);
		panel.add(etatSanteL);
		
		good = new JRadioButton("Bon");
		bad = new JRadioButton("Mauvais");
		health = new ButtonGroup();
		health.add(good);
		health.add(bad);
		//good.setSelected(true);
		good.setBounds(150, 200, 60, 20);
		bad.setBounds(220, 200, 100, 20);
		panel.add(good);
		panel.add(bad);
		
		//etatSante = new JTextField();
		//etatSante.setBounds(150, 200, 150, 20);
		
		
		statusL = new JLabel("Type contrat: ");
		statusL.setBounds(20, 230, 200, 15);
		panel.add(statusL);
		
		status = new JTextField();
		status.setBounds(150, 230, 100, 20);
		panel.add(status);
		
		precisionStatus = new JLabel("(CDI, CDD, Autoentrepreneur)");
		precisionStatus.setBounds(320, 230, 250, 15);
		panel.add(precisionStatus);
		
		risques = new JTextArea();
		risques.setBounds(70,290,350,150);
		panel.add(risques);
		
		enregistrer = new JButton("Enregistrer");
		enregistrer.setBounds(120,470,200,20);
		panel.add(enregistrer);
		
		
		evaluer = new JButton("Evaluer");
		evaluer.setBounds(80, 260, 150, 20);
		panel.add(evaluer);
		
		reset = new JButton("Réinitialiser");
		reset.setBounds(240,260,200,20);
		panel.add(reset);
		reset.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		        risques.setText("");
		        charge.setText("");
		        credit.setText("");
		        salary.setText("");
		        age.setText("");
		        status.setText("");
		       
		    }
		});
		
		
		evaluer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e){
				if(salary.getText().equals("") || charge.getText().equals("") || credit.getText().equals("") || status.getText().equals("")|| 
						age.getText().equals("") || (!good.isSelected() && !bad.isSelected()))
				{
			    JOptionPane.showMessageDialog(panel, "Veuillez remplir les cases vides", "Erreur", JOptionPane.ERROR_MESSAGE);
			    } 
				else{
				String salaryS,ageS,creditS,chargeS;
				salaryS = salary.getText();
				ageS = age.getText();
			//	etatSanteT = etatSante.getText();
				statusT = status.getText();
				chargeS = charge.getText();
				creditS = credit.getText();
				salaryT = Integer.parseInt(salaryS);
				ageT = Integer.parseInt(ageS) ;
				creditT = Integer.parseInt(creditS) ;
				chargeT =Integer.parseInt(chargeS) ;
				EvaluateRisk2 evRisk2 = new EvaluateRisk2(salaryT,statusT,creditT,ageT,chargeT);
				final String myRisk = evRisk2.Risk(rateReceived);
				System.out.println(myRisk);
				risques.setText(myRisk);
				//new EvaluateRiskPanel2();
				
				}}});
		
		enregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){


				Rate rate = new Rate();
				rate.setLoanName(loanType);

				   System.out.println(loanType);


					try {

						rate.setDuration(durationLoan);

						 receivedMsg  = updateRateFromServer(rate);

						Map<String,Object> map = new HashMap<String,Object>();
						Gson gson = new Gson();

						map = (Map<String,Object>) gson.fromJson(receivedMsg, map.getClass());

						newRateReceived =  (double) map.get("rate");
						System.out.println("Le nouveau rate est : "+ newRateReceived);		
						


					} catch (ClassNotFoundException | IOException | InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}); 
		
			
	}
	static String  updateRateFromServer(Rate rate) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {

		Gson gson = new Gson();
		JsonParser_new jparser = new JsonParser_new();

		RateTCPClient clientTcp = new RateTCPClient();

		String receivedMsg = clientTcp.SendRecieve("updateRate");

		receivedMsg = clientTcp.SendRecieve(jparser.ObjectToJSonRate(rate));

		return receivedMsg;		
	}	
	public static int getCharge(){return SetProfileClient2.chargeT;}
	public static void setCharge(int chargeT){SetProfileClient2.chargeT = chargeT;}

	public static int getSalary(){return SetProfileClient2.salaryT;}
	public static void setSalary(int salaryT){SetProfileClient2.salaryT = salaryT;}

	public static int getCredit(){return SetProfileClient2.creditT;}
	public static void setCredit(int creditT){SetProfileClient2.creditT = creditT;}

	public  static int getAge(){return SetProfileClient2.ageT;}
	public static void setAge(int ageT){SetProfileClient2.ageT = ageT;}

	public static String getStatus(){return SetProfileClient2.statusT;}
	public static void setStatus(String statusT){SetProfileClient2.statusT = statusT;}

	public static String getHealth(){return SetProfileClient2.etatSanteT;}
	public  void setHealth(String etatSanteT){SetProfileClient2.etatSanteT = etatSanteT;}
	
	public static boolean goodHealthSelected(){
		return good.isSelected();
	}
	
	public static boolean badHealthSelected(){
		return bad.isSelected();
	}

	}