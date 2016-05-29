package edu.aplus.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.google.gson.Gson;
import edu.aplus.business.SimulatorFixedRate;
import edu.aplus.model.Client;
import edu.aplus.model.Loan;
import edu.aplus.service.JsonParser_new;
import edu.client.model.Chart;
import edu.client.socket.ChartTCPClient;
import edu.client.socket.TCPClient;

public class ResultPanel extends JFrame{
	
	private JPanel panel;
	private JLabel title;
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
	
	Loan loanresult = null;
	
	public ResultPanel(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 220, 500, 400);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(panel);
		panel.setLayout(null);
		
		title = new JLabel("Résultat de la simulation : ");
		title.setBounds(130, 0, 450, 30);
		title.setFont(new Font("New Times Roman", Font.BOLD, 14));
	    title.setForeground(Color.DARK_GRAY);   
		panel.add(title);
		
		creditTypeL = new JLabel("Type du prêt demandé : ");
		creditTypeL.setBounds(50, 40, 200, 20);
		panel.add(creditTypeL);
		
		creditType = new JTextField();
		creditType.setBounds(250, 40, 200, 20);
		panel.add(creditType);
		
		amountL = new JLabel("Montant emprunté : ");
		amountL.setBounds(50, 60, 200, 20);
		panel.add(amountL);
		
		amount = new JTextField();
		amount.setBounds(250, 60, 200, 20);
		panel.add(amount);
		
		durationL = new JLabel("Durée (nb mois) : ");
		durationL.setBounds(50, 80, 200, 20);
		panel.add(durationL);
		
		duration = new JTextField();
		duration.setBounds(250, 80, 200, 20);
		panel.add(duration);
		
		rateL = new JLabel("Taux d'intérêt fixe : ");
		rateL.setBounds(50, 100, 200, 20);
		panel.add(rateL);
		
		rate = new JTextField();
		rate.setBounds(250, 100, 200, 20);
		panel.add(rate);
		
		installationWithoutInsL = new JLabel("Mensualité hors assurance : ");
		installationWithoutInsL.setBounds(70, 140, 200, 30);
		panel.add(installationWithoutInsL);
		
		installationWithoutIns = new JTextField();
		installationWithoutIns.setBounds(270, 140, 180, 30);
		panel.add(installationWithoutIns);
		
		rateInsuranceL = new JLabel("Taux d'assurance : ");
		rateInsuranceL.setBounds(50, 180, 200, 20);
		panel.add(rateInsuranceL);
		
		rateInsurance = new JTextField();
		rateInsurance.setBounds(250, 180, 200, 20);
		panel.add(rateInsurance);
		
		installationWithInsL = new JLabel("Mensualité avec assurance : ");
		installationWithInsL.setBounds(70, 210, 200, 30);
		panel.add(installationWithInsL);
		
		installationWithIns = new JTextField();
		installationWithIns.setBounds(270, 210, 180, 30);
		panel.add(installationWithIns);
		
		totalL = new JLabel("Coût total du crédit : ");
		totalL.setBounds(70, 240, 200, 30);
		panel.add(totalL);
		
		total = new JTextField();
		total.setBounds(270, 240, 180, 30);
		panel.add(total);
		
		chartButton = new JButton("Show chart");
		chartButton.setBounds(330, 300, 100, 20);
		panel.add(chartButton);
		
		JButton saveButton = new JButton("Enregistrer");
		saveButton.setBounds(100, 300, 100, 20);
		panel.add(saveButton);
		
		
		saveButton.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Button clicked");
				
				try {
					
					System.out.println(saveLoan(loanresult));
					JFrame frame = new JFrame("Demande enregistré");
					JOptionPane.showMessageDialog(frame,
					"Le résultat de la simulation est enregistré",
					"Information message",
					JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
					
				} catch (ClassNotFoundException | IOException | InterruptedException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		
		chartButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Button cliked");
				try {
					
					ChartTCPClient clientSocket = new ChartTCPClient("LineChart");
							
				} catch (ClassNotFoundException | IOException | InterruptedException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
	}
	
	
	public static void main (String[] args){
		
		ResultPanel frame1 = new ResultPanel();
		frame1.setVisible(true);
	}
	
	//Fill the credit information with and without the insurance rate and display the installments.
	public void remplir(Loan loan, String installment, String installmentFinal) {
		
		this.loanresult = loan;		
		String aM = String.valueOf(loan.getAskesAmount());
		amount.setText(aM);
		String aD = String.valueOf(loan.getAskedDuration() * 12);
		duration.setText(aD);
		String aR = String.valueOf(loan.getAskedRate());
		rate.setText(aR);
		String aRI = String.valueOf(loan.getAskedRateInsurance());
		rateInsurance.setText(aRI);
    	String s = installment;
    	installationWithoutIns.setText(s); 	
    	String s1 = installmentFinal;
    	installationWithIns.setText(s1);
    	double t = loan.getAskesAmount() + (loan.getAskedRate() + loan.getAskedRateInsurance())/100*loan.getAskedDuration();
    	total.setText(String.valueOf(t));
	}
	
	//Save the simulation result as a loan to the Loan table in the DB.
	public String saveLoan(Loan loan) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
		
		JsonParser_new jparser = new JsonParser_new();
		 
		TCPClient clientTcp = new TCPClient();
		
		String recievedmsg = clientTcp.SendRecieve("saveLoan");
		
		recievedmsg = clientTcp.SendRecieve(jparser.ObjectToJSonLoan(loan));
		
		return recievedmsg;		
	}	
}