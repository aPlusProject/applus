package edu.aplus.client.panel;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ArrayIndicatorsPanel extends JPanel {
	
	
	private JTable table;
	private DefaultTableModel model;
	private TableRowSorter<DefaultTableModel> sorter;

	/**
	 * this panel allow the display of the array of all loans
	 */
	public ArrayIndicatorsPanel() {
		
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
		
		// create a sorter object to apply filter on it (FilterIndicatorsPanel.java)
		sorter = new TableRowSorter<DefaultTableModel>(model);
        table.setRowSorter(sorter);
        
        // set the array scrollable
        add(new JScrollPane(table));

	}
	
	/**
	 * 
	 * @return current JTable object
	 * 
	 */
	public JTable getJTableObject() {
		
		return table;
	}
	
	/**
	 * 
	 * @return current TableRowSorter<DefaultTableModel> object
	 */
	public TableRowSorter<DefaultTableModel> getSorterObject() {
		
		return sorter;
	}

}
