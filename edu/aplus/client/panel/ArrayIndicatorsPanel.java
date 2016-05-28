package edu.aplus.client.panel;

import java.awt.FlowLayout;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import edu.aplus.service.ArrayIndicatorExpose;

public class ArrayIndicatorsPanel extends JPanel {
	
	
	private JTable table;
	private DefaultTableModel model;
	private TableRowSorter<DefaultTableModel> sorter;

	/**
	 * this panel allow the display of the array of all loans
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ArrayIndicatorsPanel() throws ClassNotFoundException, SQLException {
		
		setLayout(new FlowLayout());
		
		//					0				1			2		3		4			5
		String[] cols = { "Type de prêt", "Montant", "Durée", "Taux", "Date" , "Decision"};
		
		ArrayIndicatorExpose arrayIndicExpose = new ArrayIndicatorExpose();
		
		String[][] data = arrayIndicExpose.getData();
		
		/*String[][] data = { { "01", "accordé", "2.5", "3000", "personnel", "2"},
				{ "02", "refusé", "1.25", "30000", "immobilier", "8"},
				{"03", "en cours", "2.00", "5000", "personnel", "3"}, 
				{ "04", "en cours", "1.25", "30000", "personnel", "10"},
				{ "05", "refusé", "1.50", "3000", "immobilier", "5"},
				{ "06", "accordé", "1.25", "30000", "personnel", "10"},
				{ "07", "accordé", "1.25", "30000", "personnel", "4"},
				{ "08", "en cours", "2.05", "15000", "immobilier", "2"},
				{ "09", "accordé", "2.05", "15000", "immobilier", "2"},
		};*/
		
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
