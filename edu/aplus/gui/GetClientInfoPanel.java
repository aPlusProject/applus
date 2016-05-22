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
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		label = new JLabel("Enter client number : ");
		label.setBounds(168, 37, 150, 14);
		panel.add(label);
		
		text = new JTextField();
		text.setBounds(168, 63, 92, 20);
		panel.add(text);
		text.setColumns(10);
		
		buttonClient = new JButton("Enter");
		buttonClient.setBounds(168, 110, 89, 23);
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
	    		try {
					client = simulator.getClientByID(i);
					
					if(client == null)  {
						//errorMessage.setText("Client with this number does not exist");
						//Object selectCreditType = JOptionPane.WARNING_MESSAGE;
					    JFrame frame = new JFrame("Client does not exist");
					    JOptionPane.showMessageDialog(frame,
					        "Client with this number does not exist",
					        "Warning message",
					        JOptionPane.WARNING_MESSAGE);
					    System.exit(0);
					}
					else {
						SimulatoinPanel frame1 = new SimulatoinPanel();
						frame1.fillClientData(client);
						frame1.setVisible(true);	
					}
					
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
					GetClientInfoPanel frame = new GetClientInfoPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
