package edu.aplus.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
	
public class Fenetre extends JFrame {
	  private static final String Option = null;
	private JPanel container = new JPanel();
	private JPanel container2 = new JPanel();
	  private JComboBox combo = new JComboBox();
	  private JComboBox combo2 = new JComboBox();
	  private JLabel label = new JLabel("Simulation 1");
	  private JLabel label2 = new JLabel("Simulation 2");
	  private JButton Button = new JButton("Comparer");
	  DefaultTableModel model = new DefaultTableModel(); 


	  public Fenetre(){
	    this.setTitle("Animation");
	    this.setSize(600, 600);

/*	    String[] columnNames = {"Indicateur","Option 1",
                "Option 2",
                "Differenc"};
	    
	    Object[][] data = {
	    		 {"Total des interets", "Smith",
		    	     "Snowboarding", new Integer(5)},
	    	    {"Niveau d'endettement", "Smith",
	    	     "Snowboarding", new Integer(5)},
	    	    {"Poids dans la mensualité", "Doe",
	    	     "Rowing", new Integer(3)},
	    	    {"Sue", "Black",
	    	     "Knitting", new Integer(2)}
	    	};
	    
    JTable table = new JTable(data, columnNames);*/ 
	   model.addColumn("Indicateur"); 
	   model.addColumn("Simulation 1"); 
	   model.addColumn("Simulation 2");
	    model.addColumn("Difference"); 
	   Object[] data = {
   		 "Total des interets", "0",
		    	     "0", "0"};
	    Object[]   data1 = {"Niveau d'endettement", "0",
	    	     "0", "0"};
	    Object[]   data2 = {"Poids dans la mensualité", "0",
	    	     "0", "0"};
	    model.addRow(new Object[]{"Décision", 0, 0, 0});
	    model.addRow(new Object[]{"Montant demandé", 0, 0, 0});
	    model.addRow(new Object[]{"Nombre de mois", 0, 0, 0});
	    model.addRow(new Object[]{"Total des interets/mois", 0, 0, 0});
	   	model.addRow(data);
	    model.addRow(new Object[]{"Taux d'endettement", 0, 0, 0});
	    model.addRow(data1);
	    model.addRow(data2);

	  			
  JTable table = new JTable(model); 

	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    container.setBackground(Color.white);
	    container.setLayout(new BorderLayout());
	    combo.setPreferredSize(new Dimension(100, 20));
	    combo.setName("1");
	    
	    //REQUETE FORM
	    Connection2 a = new Connection2();
	    Connection vCon = a.connection();
	      
		try {
			Statement vSt = vCon.createStatement();
			ResultSet vRs = vSt.executeQuery("SELECT * FROM LOAN WHERE ID_CLIENT=1");
			while(vRs.next()){
				int vNom = vRs.getInt(1);
				combo.addItem(vNom);
				combo2.addItem(vNom);
				//System.out.println("Nom="+vNom);
				}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    combo.addItemListener(new ItemState());
	    combo2.setPreferredSize(new Dimension(100, 20));
	    combo2.addItemListener(new ItemState2());
	    Button.addActionListener(new ItemAction());
	    
	    JPanel top = new JPanel();
	    JPanel panelTableau = new JPanel();
	    panelTableau.setLayout(new BorderLayout()) ;
	    panelTableau.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);

	    top.add(label);

	    top.add(combo);
	    top.add(label2);
	    top.add(combo2);
	    top.add(Button);
	   //bottom.add(table);
	    container.add(top, BorderLayout.PAGE_START);
	    container.add(panelTableau, BorderLayout.CENTER);
	    
		//  getContentPane().add(table.getTableHeader(), BorderLayout.SOUTH);
	  //  getContentPane().add(table, BorderLayout.SOUTH);
	//    container.add(bottom, BorderLayout.SOUTH);
	   
	    this.setContentPane(container2);
	    this.setContentPane(container);
	    
	    this.setVisible(true);    
	    
	  }
 
	  
	  
	  public static int indebt(){
		  Connection2 a = new Connection2();
		  Connection vCon = a.connection();
	      
			try {
				Statement vSt = vCon.createStatement();
				ResultSet vRs = vSt.executeQuery("SELECT * FROM CLIENT");
				while(vRs.next()){
					String vNom = vRs.getString(1);
					String vPrenom = vRs.getString(2);
					System.out.println("Nom="+vNom+"Prenom="+vPrenom);
					}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		  
		  return 0;
	  }
	public static void main(String[] args) throws SQLException {
		
		
		
		new Fenetre();
	}
	  class ItemState implements ItemListener{
		    public void itemStateChanged(ItemEvent e) {
		  /*  	String Option;
		     System.out.println("événement déclenché sur : " + e.getItem());
		   	System.out.println("événement déclenché sur : " + e.getID());
		    Option = (String) e.getItem();
		   System.out.println("événement déclenché sur : " + Option);
		      System.out.println("événement déclenché sur : " +  e.getItem());*/
		    }   
		    }
	  class ItemState2 implements ItemListener{
		    public void itemStateChanged(ItemEvent e) {
		    /*	String Option2;
		      //System.out.println("événement déclenché sur : " + e.getItem());
		    	System.out.println("événement déclenché sur : " + e.getID());
		      Option2 = (String) e.getItem();
		      System.out.println("événement déclenché sur : " + Option2);
		      System.out.println("événement déclenché sur : " +  e.getItem());*/
		    }   
		    }
	  class ItemAction implements ActionListener{
		  int i = 0;
		    public void actionPerformed(ActionEvent e) {
		     // System.out.println("ActionListener : action sur " + combo.getSelectedItem());
		    //  System.out.println("ActionListener : action sur " + combo2.getSelectedItem());
		      String requete1 = "SELECT * FROM LOAN WHERE ID_LOAN="+combo.getSelectedItem();
		      String requete2 = "SELECT * FROM LOAN WHERE ID_LOAN="+combo2.getSelectedItem();
		      int id_loan1 = (int) combo.getSelectedItem();
		      int id_loan2 = (int) combo2.getSelectedItem();

		      
		      getInfo info = new getInfo();
		      
		      Calculation calcul = new Calculation();
		      float total1 = calcul.totalinteret(id_loan1);
		      float total2 = calcul.totalinteret(id_loan2);
		      float total3 = (float) total1-total2;
		      float mois1 = calcul.totalinteretParMois(id_loan1);
		      float mois2 = calcul.totalinteretParMois(id_loan2);
		      float mois3 = (float) mois1-mois2;
		      
		      
		      System.out.println(total1);
		      System.out.println(total2);
		     // Connection2 a = new Connection2();
		    //  Connection vCon = a.connection();
		    /*  try {
					Statement vSt = vCon.createStatement();
					ResultSet vRs = vSt.executeQuery(requete1);
					ResultSet vRs2 = vSt.executeQuery(requete2);
					int vNom = vRs.getInt(8);
					int vNom2 = vRs2.getInt(8);
					System.out.println("Nom="+vNom+vNom2);
					
				/*	while(vRs.next() && vRs2.next()){
						int vNom = vRs.getInt(8);
						int vNom2 = vRs2.getInt(8);
						combo.addItem(vNom);
						combo2.addItem(vNom);
						System.out.println("Nom="+vNom+vNom2);
						}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/


		   //   model.addRow(new Object[]{"Column 1", "Column 2", "Column 3"});
		   //   model.fireTableDataChanged();
		      while (i<8){
		    	  model.removeRow(0);
		    	  i = i + 1;
		      }
		      
		     
		      
	
		   
		      
			/*try {
				Statement vSt = vCon.createStatement();
				ResultSet vRs = vSt.executeQuery("SELECT * FROM CLIENT");
				while(vRs.next()){
					/*String vNom = vRs.getString(1);
					String vPrenom = vRs.getString(2);
					System.out.println("Nom="+vNom+"Prenom="+vPrenom);
					}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
		      
		   
		      
		      model.addRow(new Object[]{"Montant demandé", info.asked_amount(id_loan1)+" €", info.asked_amount(id_loan2)+" €", info.asked_amount(id_loan1)-info.asked_amount(id_loan2)+" €"});
		      model.addRow(new Object[]{"Nombre de mois", info.asked_duration(id_loan1), info.asked_duration(id_loan2), info.asked_duration(id_loan1)-info.asked_duration(id_loan2)});
		      model.addRow(new Object[]{"Décision", info.decision(id_loan1), info.decision(id_loan2), 0});
		      model.addRow(new Object[]{"Total des interets/mois", mois1+" €", mois2+" €", mois3+" €"});
		      model.addRow(new Object[]{"Total des interets", total1+" €", total2+" €", total3+" €"});
		      model.addRow(new Object[]{"Taux d'endettement", calcul.txdendettement(id_loan1), calcul.txdendettement(id_loan2), 0});
		      model.addRow(new Object[]{"Niveau d'endettement", "Column 2", "Column 3", "Column 3"});
		      model.addRow(new Object[]{"Poids dans la mensualité", "Column 2", "Column 3", "Column 3"});
		      i=0;
		      //compare((String)combo.getSelectedItem(),(String)combo2.getSelectedItem());
		      

		      
		      
		    }               
		  }
	  public static void compare(String object, String object2){
		  
	  }
}
