package edu.client.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import edu.aplus.gui.AllClientsDisplayPanel;
import edu.aplus.model.Employee;

public class EmployeePanel {
	
	private static final String ALLCLIENTS = "allClientsDisplay";
	private static AllClientsDisplayPanel allClientsPanel;
	private static final String DELETECLIENT = "deleteClientDisplay";
	private static final String UPDATECLIENT = "updateClientDisplay";
	private static final String CREATECLIENT = "createClientDisplay";
	
	
	private JButton retour;
	private JButton allClients;
	private JButton deleteClient;
	private JButton updateClient;
	private JButton insertClient;
	
	private Employee employee;

    //launch the application
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
    	
        
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                    JFrame frame = new JFrame("Accueil");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
    }
	
	private static final Dimension MAIN_SIZE = new Dimension(400,200);
	private JPanel mainPanel = new JPanel();
	
	
	
	
	public EmployeePanel() throws ClassNotFoundException, SQLException {
		
		retour = new JButton("Retour");
		allClients =  new JButton("Voir tous les clients");
		deleteClient = new JButton("Supprimer un client");
		updateClient = new JButton("Modifier un client");
		insertClient = new JButton("Ajouter un nouveau client");
		mainPanel.add(retour);
		mainPanel.add(allClients);
		mainPanel.add(deleteClient);
		mainPanel.add(updateClient);
		mainPanel.add(insertClient);
		
		/*allClients.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("EmployeePanel : ");
				Window win = SwingUtilities.getWindowAncestor(allClientsPanel.getMainComponent());
	            win.dispose();
				
			}
			
		});*/
	}
	
	public JComponent getMainComponent() {
		return mainPanel;
	}

	public void addBackBtnActionListener(ActionListener listener) {
	      retour.addActionListener(listener);
	}
	
	public void addCreateClientBtnActionListener(ActionListener listener) {
	      insertClient.addActionListener(listener);
	}
	
	public void addSeeAllClientsBtnActionListener(ActionListener listener) {
	      allClients.addActionListener(listener);
	}
	
	public void addDeleteClientBtnActionListener(ActionListener listener) {
	      deleteClient.addActionListener(listener);
	}
	
	public void addUpdateClientBtnActionListener(ActionListener listener) {
	      updateClient.addActionListener(listener);
	}
	
	public void addEmployeeObject(Employee e) {
		this.employee = e;
	}
	
	

}