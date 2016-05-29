package edu.aplus.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import edu.aplus.business.SimulatorFixedRate;
import edu.aplus.model.Client;
import edu.aplus.service.JsonParser_new;
import edu.client.socket.ChartTCPClient;
import edu.client.socket.TCPClient;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GetClientInfoPanel  extends JFrame{

	private JPanel panel;
	private JTextField text;
	private JButton buttonClient;
	private JLabel label;
	Client  client = null;

	public GetClientInfoPanel() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(panel);
		panel.setLayout(null);
		
		label = new JLabel("Renseignez le numéro du client : ");
		label.setBounds(120, 23, 500, 14);
		label.setFont(new Font("New Times Roman", Font.BOLD, 14));
	    label.setForeground(Color.DARK_GRAY);   
		panel.add(label);
		
		text = new JTextField();
		text.setBounds(168, 73, 92, 20);
		panel.add(text);
		text.setColumns(10);
		
		buttonClient = new JButton("Entrer");
		buttonClient.setBounds(168, 120, 89, 23);
		panel.add(buttonClient);
		
		final JLabel errorMessage = new JLabel(" ");
		errorMessage.setBounds(168, 150, 200, 23);
		panel.add(errorMessage);
		
	    //Add action listener to button
		buttonClient.addActionListener(new ActionListener() {
	    	
	    	public void actionPerformed(ActionEvent e){
	    		//Execute when button is pressed
	    		SimulatorFixedRate simulator = new SimulatorFixedRate();
	    		int i = Integer.parseInt(text.getText());
	    	
	    		
	    		//client = simulator.getClientByID(i);
	    		try {
	    			
					client = getclientfromServer(i);
					
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				if(client == null)  {
					JFrame frame = new JFrame("Renseignez le numéro du client");
					JOptionPane.showMessageDialog(frame,
					"Le client avec ce numéro n'exste pas",
					"Warning message",
					JOptionPane.WARNING_MESSAGE);
					System.exit(0);
				}
				else {
					SimulatoinPanel frame1 = new SimulatoinPanel();
					frame1.remplir(client);
					frame1.setVisible(true);	
				}
	        }
	    	
	    }); 
	}
	
	public Client getclientfromServer(int Clientid) throws UnknownHostException, ClassNotFoundException, IOException, InterruptedException {
		
		String recievedmsg;
		TCPClient clientTcp = new TCPClient();
		
		recievedmsg = clientTcp.SendRecieve("getclientbyID");
		
		recievedmsg = clientTcp.SendRecieve(""+Clientid);
		
		JsonParser_new jparser = new JsonParser_new();
		
		return jparser.JSonToObject(recievedmsg);

		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetClientInfoPanel frame = new GetClientInfoPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
