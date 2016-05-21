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

public class WelcomePanel  extends JFrame{

	private JPanel panel;
	private JButton buttonProspect;
	private JButton buttonClient;

	public WelcomePanel() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		buttonClient = new JButton("Client");
		buttonClient.setBounds(168, 80, 89, 23);
		panel.add(buttonClient);
		
		buttonProspect = new JButton("Prospect");
		buttonProspect.setBounds(168, 120, 89, 23);
		panel.add(buttonProspect);
		
	    //Add action listener to button
		buttonClient.addActionListener(new ActionListener() {
	    	
	    	public void actionPerformed(ActionEvent e){
	    		//Execute when button is pressed
					
	    				GetClientInfoPanel frame1 = new GetClientInfoPanel();
						frame1.setVisible(true);	
	        }
	    	
	    }); 
		
	buttonProspect.addActionListener(new ActionListener() {
	    	
	    	public void actionPerformed(ActionEvent e){
	    		//Execute when button is pressed
	    		
						SimulatoinPanel frame2 = new SimulatoinPanel();
						frame2.setVisible(true);	
	        }
	    	
	    }); 
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePanel frame = new WelcomePanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
