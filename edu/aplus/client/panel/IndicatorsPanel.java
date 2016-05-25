package edu.aplus.client.panel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class IndicatorsPanel extends JPanel {
	
	private JLabel avgLbl;
    private JTextField nbRowsField;	
	private JTextField avgInterestRateField;
	private JTextField avgEmpruntAmountField;
	private JTextField avgAgeField;
	private JTextField avgLengthField;
	
	private TableRowSorter<DefaultTableModel> upSorter;
	private JTable upTable;

	/**
	 * Create the panel.
	 */
	public IndicatorsPanel(JTable table, TableRowSorter<DefaultTableModel> sorter) {
		
		upTable = table;
		upSorter = sorter;
		
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		
		nbRowsField = new JTextField();
    	nbRowsField.setEditable(false);
    	
    	avgLbl = new JLabel("Affichage des moyennes");
    	
    	avgInterestRateField = new JTextField();
    	avgInterestRateField.setEditable(false);
    	avgEmpruntAmountField = new JTextField();
    	avgEmpruntAmountField.setEditable(false);
    	avgAgeField = new JTextField();
    	avgAgeField.setEditable(false);
    	avgLengthField = new JTextField();
    	avgLengthField.setEditable(false);
    	
        final JComboBox<String> boxLoanType = new JComboBox<>(new String[]{"Tout","immobilier","personnel"});
        final JComboBox<String> boxLoanStatus = new JComboBox<>(new String[]{"Tout","accordé","refusé", "en cours"});
        JButton filterBtn = new JButton("filter");
        
        filterBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //filterViaComboBox(boxLoanType, 4);
            	doubleFilter(upSorter, upTable, boxLoanType.getSelectedItem().toString(), 4, boxLoanStatus.getSelectedItem().toString(), 1);
            	
            }
        });
        
        add(new JLabel("Type de prêt :"));
        add(boxLoanType);
        add(new JLabel("Status du prêt :"));
        add(boxLoanStatus);
        add(filterBtn);
        add(nbRowsField);
        
        add(avgLbl);
        add(avgAgeField);
        add(avgLengthField);
        add(avgInterestRateField);
        add(avgEmpruntAmountField);
        
        nbRowsField.setText(upTable.getRowCount()+" trouvés");
        setAllAvgField(upTable, 6, 3, 2, 5);

	}
	
public void doubleFilter(TableRowSorter<DefaultTableModel> sorter, JTable table, String stringFiltre1, int idColFiltre1, String stringFiltre2, int idColFiltre2) {
    	
    	RowFilter<DefaultTableModel, Object> rfType = null;
    	RowFilter<DefaultTableModel, Object> rfStatus = null;
    	
    	System.out.println("double filtre, string 1 :" +stringFiltre1);
    	System.out.println("double filtre, string 2 :" +stringFiltre2);
    	
    	if(stringFiltre1 == "Tout") {
    		stringFiltre1 = "";
    	}
    	if(stringFiltre2 == "Tout") {
    		stringFiltre2 = "";
    	}
    	rfType = RowFilter.regexFilter(stringFiltre1, idColFiltre1);
    	rfStatus = RowFilter.regexFilter(stringFiltre2, idColFiltre2);
    	
    	
    	
    	
    	
    	ArrayList<RowFilter<DefaultTableModel, Object>> andFilters = new ArrayList<RowFilter<DefaultTableModel, Object>>();
    	andFilters.add(rfType);
    	andFilters.add(rfStatus);
    	
    	sorter.setRowFilter(RowFilter.andFilter(andFilters));
    	
    	nbRowsField.setText(table.getRowCount()+" trouvés");
    	System.out.println(table.getRowCount());
    	
    	setAllAvgField(table, 6, 3, 2, 5);

    	
    }

	private void setAllAvgField(JTable table, int idAgeCol, int idEmpruntAmountCol, int idInterestRateCol, int idLenghtCol) {
	
		DecimalFormat formatter = new DecimalFormat("#0.000");
		
		avgInterestRateField.setText(formatter.format(getAvgOfColByIdCol(table, idInterestRateCol)));
	    avgEmpruntAmountField.setText(formatter.format(getAvgOfColByIdCol(table, idEmpruntAmountCol)));
	    avgAgeField.setText(formatter.format(getAvgOfColByIdCol(table, idAgeCol)));
	    avgLengthField.setText(formatter.format(getAvgOfColByIdCol(table, idLenghtCol)));
	
	}
	
	private double getAvgOfColByIdCol(JTable table, int idCol) {
    	
    	double avg = 0;
    	
    	System.out.println("nombre de ligne "+table.getRowCount());
    	
    	if(table.getRowCount() != 0) {
    		double sum = 0;
    		for(int i=0; i < table.getRowCount(); i++) {
    			sum = sum +  Double.parseDouble(table.getValueAt(i, idCol)+"");
    		}
    		
    		avg = sum / table.getRowCount();
    	}
    	
    	
    	return avg;
    	
    }

}
