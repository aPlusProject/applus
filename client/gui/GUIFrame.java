package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import edu.gui.AllClientsDisplayPanel;
import edu.gui.EmployeePanel;
import model.Client;
import model.Employee;
import socket.SocketClient;

public class GUIFrame extends JFrame {

	private static final String CO = "connection";
	
	private static final String EMPLOYEEPANEL = "employeePanelDisplay";
	private static final String ALLCLIENTS = "allClientsDisplay";
	private static final String DELETECLIENT = "deleteClientDisplay";
	private static final String UPDATECLIENT = "updateClientDisplay";
	private static final String CREATECLIENT = "createClientDisplay";
	private static final String SEEALLCLIENTS = "AllClients";
	private ConnectionPanel coPanel = new ConnectionPanel();
	
	private static EmployeePanel employeePanel;
	private static AllClientsDisplayPanel allClientsPanel;
	private static DeleteClientPanel deleteClientPanel;
	private static UpdateClientPanel updateClientPanel;
	private static CreateClientPanel createClientPanel;
	private static DisplayClientsPanel displayClientsPanel;
	
	private Employee employee;
	
	private CardLayout cardlayout = new CardLayout();
	private JPanel mainPanel = new JPanel(cardlayout);
	private SocketClient sck;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		employeePanel = new EmployeePanel();
		allClientsPanel = new AllClientsDisplayPanel();
		deleteClientPanel = new DeleteClientPanel();
		updateClientPanel = new UpdateClientPanel();
		createClientPanel = new CreateClientPanel();
		displayClientsPanel = new DisplayClientsPanel();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JComponent getMainComponent() {
		return mainPanel;	
	}
	
	public static void createAndShowUI() {
		JFrame frame = new JFrame("Application Client");
        frame.getContentPane().add(new JScrollPane(new GUIFrame().getMainComponent()));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public GUIFrame() {
		mainPanel.add(coPanel.getMainComponent(), CO);
		mainPanel.add(employeePanel.getMainComponent(), EMPLOYEEPANEL);
		mainPanel.add(allClientsPanel.getMainComponent(), ALLCLIENTS);
		mainPanel.add(deleteClientPanel.getMainComponent(), DELETECLIENT);
		mainPanel.add(updateClientPanel.getMainComponent(), UPDATECLIENT);
		mainPanel.add(createClientPanel.getMainComponent(), CREATECLIENT);
		mainPanel.add(displayClientsPanel.getMainComponent(), SEEALLCLIENTS);
		
		
		coPanel.addConnectionActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InetAddress localAdr= null;
				
				try {
					localAdr = InetAddress.getLocalHost();
				} catch (UnknownHostException e2) {
					e2.printStackTrace();
				}
				if (localAdr != null) {
					
					try {
						sck = new SocketClient(localAdr.getHostAddress(),3002);
						//sck = new SocketClient("10.10.10.102",3000);
						sck.send("1");
						System.out.println(System.getProperty("user.dir"));
						try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(new File("C:\\Users\\asus\\git\\under\\AplusClient\\arrayclient.tmp")))) {
							System.out.println("lecture done");
							/*ArrayList<Client> array =  (ArrayList<Client>) input.readObject();
							Employee em = new Employee();
							em.setAllClients(array);
							//allClientsPanel.addObjectEmployee(em);
							employee = em;
							ArrayList<Client> listClients = employee.getAllClients();
							for(int i = 0; i<listClients.size(); i++) {
								System.out.println(listClients.get(i).getID()+" / "+listClients.get(i).getFirstName()+" / "+listClients.get(i).getLastName()+" / "+listClients.get(i).getEmail());
								
							}*/
							//System.out.println(input.readObject());
							
						}
						
						//sck.receive();
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				 
				cardlayout.show(mainPanel, EMPLOYEEPANEL);
				
			}
			
		});
		
		employeePanel.addBackBtnActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(mainPanel, CO);
			}
		});
		
		employeePanel.addSeeAllClientsBtnActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(mainPanel, ALLCLIENTS);
				
			}
			
		});
		
		employeePanel.addCreateClientBtnActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(mainPanel, CREATECLIENT);
				
			}
			
		});
		
		employeePanel.addDeleteClientBtnActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(mainPanel, DELETECLIENT);
				
			}
			
		});
		
		employeePanel.addUpdateClientBtnActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(mainPanel, UPDATECLIENT);
				
			}
			
		});
		
		allClientsPanel.addBackBtnActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(mainPanel, EMPLOYEEPANEL);
				
			}
			
		});
		
		allClientsPanel.addDisplayClientsActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(mainPanel, SEEALLCLIENTS);
			}
			
		});
		
		displayClientsPanel.addAfficherBtnActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(mainPanel, SEEALLCLIENTS);
				
			}
			
		});
		
		deleteClientPanel.addBackBtnActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(mainPanel, EMPLOYEEPANEL);
				
			}
			
		});
		
		updateClientPanel.addBackBtnActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(mainPanel, EMPLOYEEPANEL);
				
			}
			
		});
		
		createClientPanel.addBackBtnActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(mainPanel, EMPLOYEEPANEL);
				
			}
			
		});
		
		
	}

}
