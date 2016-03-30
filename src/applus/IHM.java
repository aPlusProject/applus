package applus;
import model.Client;
import model.Employee;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class IHM {

    Statement ps;
    ResultSet rs;

    private static ArrayList<String> unClient = new ArrayList<String>();
    private static ArrayList<ArrayList<String>> tabClient = new ArrayList<ArrayList<String>>();
    private static ArrayList<String> entete = new ArrayList<String>();
    private static ArrayList<ArrayList<String>> tableClient = new ArrayList<ArrayList<String>>();

    //launch the application
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

    	Employee employee = new Employee();
        
        ArrayList<Client> listClient = employee.seeClients(false, 1);
        
        for(int i=0; i< listClient.size(); i++) {
        	unClient = new ArrayList<String>();
        	unClient.add(listClient.get(i).getFirstName());
        	unClient.add(listClient.get(i).getLastName());
        	unClient.add(listClient.get(i).getID()+"");
        	tabClient.add(unClient);
        	
        }
        
        for(int i=0;i<tabClient.size();i++) {
        	tableClient.add(tabClient.get(i));
        }
        
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
	
        
        entete.add("Nom");
        entete.add("Prénom");
        entete.add("ID");
        
    }


}