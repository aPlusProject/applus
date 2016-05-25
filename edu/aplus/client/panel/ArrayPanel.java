package edu.aplus.client.panel;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ArrayPanel extends JPanel {
	
	
	private JTable table;
	private DefaultTableModel model;
	private TableRowSorter<DefaultTableModel> sorter;

	/**
	 * Create the panel.
	 */
	public ArrayPanel() {
		
		setLayout(new FlowLayout());
		
		String[] cols = { "N° Pret", "Statut", "Taux interet", "Montant emprunté", "Type de prêt" , "Durée", "age"};
		String[][] data = { { "01", "accordé", "2.5", "3000", "personnel", "2" , "20"},
				{ "02", "refusé", "1.25", "30000", "immobilier", "8" ,"54"},
				{"03", "en cours", "2.00", "5000", "personnel", "3", "35"}, 
				{ "04", "en cours", "1.25", "30000", "personnel", "10" , "58"},
				{ "05", "refusé", "1.50", "3000", "immobilier", "5" , "38"},
				{ "06", "accordé", "1.25", "30000", "personnel", "10" , "68"},
				{ "07", "accordé", "1.25", "30000", "personnel", "4" , "22"},
				{ "08", "en cours", "2.05", "15000", "immobilier", "2" , "45"},
				{ "09", "accordé", "2.05", "15000", "immobilier", "2" , "45"},
		};
		
		table = new JTable(model = new DefaultTableModel(data,cols));
		
		sorter = new TableRowSorter<DefaultTableModel>(model);
        table.setRowSorter(sorter);
        
        add(new JScrollPane(table));

	}
	
	
	public JTable getJTableObject() {
		
		return table;
	}
	
	public TableRowSorter<DefaultTableModel> getSorterObject() {
		
		return sorter;
	}

}
