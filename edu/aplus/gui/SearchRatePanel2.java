package edu.aplus.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.aplus.model.Client;
import edu.aplus.model.Loan;
import edu.aplus.model.Rate;
import edu.aplus.service.JsonParser_new;
import edu.client.socket.RateTCPClient;
import edu.client.socket.TCPClient;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class SearchRatePanel2   extends JFrame{

	private static final String Clientid = null;
	private static JComboBox loanType;
	private static JComboBox duration;
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
	private JTextField age;
	private JButton bouton;
	private JTextField rateT;
	private JLabel rateL;
	String receivedMsg;
	double rateReceived;
	



	private String[] listType = {"Pret immobilier","Pret de consommation","Pret professionnel"};
	private String[] listDuration = {"1","2","3","4","5","6","7","10","15","20","25","30"};

	Client client = null;
	public SearchRatePanel2(final JComboBox loan, final JComboBox durationLoan) {
		
		this.loanType = loan;
		this.duration = durationLoan;
		
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 220, 400, 400);

		panel = new JPanel();
		panel.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(panel);
		panel.setLayout(null);

		rateL = new JLabel("Déterminer d'abord le type et la durée de prêt");
		rateL.setBounds(20,20,350,15);
		panel.add(rateL);

		creditTypeL = new JLabel("Type du crédit  ");
		creditTypeL.setBounds(20, 60, 200, 15);
		panel.add(creditTypeL);

		loanType = new JComboBox(listType);
		loanType.setBounds(150, 60, 150, 20);
		panel.add(loanType);

		durationL = new JLabel("Durée  ");
		durationL.setBounds(20, 90, 200, 15);
		panel.add(durationL);

		duration = new JComboBox(listDuration);
		duration.setBounds(150, 90, 100, 20);
		panel.add(duration);

		bouton = new JButton("Résultat");
		bouton.setBounds(70, 130, 120, 25);
		panel.add(bouton);
		bouton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e){

				Rate rate = new Rate();
				rate.setLoanName(loanType.getSelectedItem().toString());
				try {
					rate.setDuration(Integer.parseInt(duration.getSelectedItem().toString()));
					 receivedMsg  = getRatefromServer(rate);
					Map<String,Object> map = new HashMap<String,Object>();
					Gson gson = new Gson();

					map = (Map<String,Object>) gson.fromJson(receivedMsg, map.getClass());

					rateReceived =  (double) map.get("rate");
					System.out.println("Le rate est : "+ rateReceived);	
					rate.setValue(rateReceived);
					SetProfileClient2 frame2 = new SetProfileClient2(rateReceived);
					frame2.setVisible(true);


				} catch (ClassNotFoundException | IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}); 
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchRatePanel2 frame = new SearchRatePanel2(loanType,duration);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	static String  getRatefromServer(Rate rate) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {

		Gson gson = new Gson();
		JsonParser_new jparser = new JsonParser_new();
		RateTCPClient clientTcp = new RateTCPClient();
		String receivedMsg = clientTcp.SendRecieve("calculateRate");
		receivedMsg = clientTcp.SendRecieve(jparser.ObjectToJSonRate(rate));

		return receivedMsg;		
	}	

	
	public void setRateReceived(double rateReceived) {
		this.rateReceived = rateReceived;
	}
	public double getRateReceived() {
		return this.rateReceived;
	}

	public String getSelectedLoanType() {
		return (String)loanType.getSelectedItem();
	}
	public int getSelectedDuration() {
		return Integer.parseInt(duration.getSelectedItem().toString());
	}


}