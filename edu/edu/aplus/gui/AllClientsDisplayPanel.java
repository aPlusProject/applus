package edu.aplus.gui;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.aplus.service.EmployeePanelModel;

public class AllClientsDisplayPanel {

    Statement ps;
    ResultSet rs;

    private static ArrayList<String> entete;
    private static ArrayList<ArrayList<String>> tableClient;
    private JPanel mainPanel = new JPanel();

    //launch the application
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	
    	EmployeePanelModel modelEmployee = new EmployeePanelModel(false,1);
    	tableClient = modelEmployee.getArrayOfClients();
    	entete = modelEmployee.getEntete();
        
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                    Object[] tempEntete = entete.toArray();
                    String[][] tempTable = new String[tableClient.size()][];
                    int i = 0;
                     for (List<String> next : tableClient) {
                        tempTable[i++] = next.toArray(new String[next.size()]);
                      }
                    JTable endTable = new JTable(tempTable,tempEntete);
                    JFrame frame = new JFrame("Liste des clients");
                    frame.getContentPane().add(new JScrollPane(endTable));
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
    }
    
    public JComponent getMainComponent() {
		return mainPanel;
	}


}