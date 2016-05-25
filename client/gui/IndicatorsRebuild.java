package client.gui;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



public class IndicatorsRebuild extends JFrame {
	
	private JPanel indicatorsPanel;

    private JTable table;
    private DefaultTableModel model;
    private TableRowSorter<DefaultTableModel> sorter;
    
    private JLabel avgLbl;
    private JTextField nbRowsField;	
	private JTextField avgInterestRateField;
	private JTextField avgEmpruntAmountField;
	private JTextField avgAgeField;
	private JTextField avgLengthField;

    public IndicatorsRebuild() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setLayout(new GridLayout(0, 1));
        setSize(1000, 700);
        initComponents();
        pack();
        setVisible(true);

    }

    public static void main(String... strings) {
        new IndicatorsRebuild();
    }

    private void initComponents() {
    	
    	
    	indicatorsPanel = new JPanel();
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
            	doubleFilter(boxLoanType.getSelectedItem().toString(), 4, boxLoanStatus.getSelectedItem().toString(), 1);
            	
            }
        });
        
        
        
        
        indicatorsPanel.add(new JLabel("Type de prêt :"));
        indicatorsPanel.add(boxLoanType);
        indicatorsPanel.add(new JLabel("Status du prêt :"));
        indicatorsPanel.add(boxLoanStatus);
        indicatorsPanel.add(filterBtn);
        indicatorsPanel.add(nbRowsField);
        
        indicatorsPanel.add(avgLbl);
        indicatorsPanel.add(avgAgeField);
        indicatorsPanel.add(avgLengthField);
        indicatorsPanel.add(avgInterestRateField);
        indicatorsPanel.add(avgEmpruntAmountField);
        
        
        
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
        
        nbRowsField.setText(table.getRowCount()+" trouvés");
        setAllAvgField(6, 3, 2, 5);
        
        add(indicatorsPanel,BorderLayout.EAST);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
    
    public void filterViaComboBox(JComboBox<String> box, int idCol) {
    	RowFilter<DefaultTableModel, Object> rf = null;
    	rf  = RowFilter.regexFilter("", idCol);
    	if(box.getSelectedItem().toString() != "tout") {
    		rf  = RowFilter.regexFilter(box.getSelectedItem().toString(), idCol);		
    	}
    	
    	
        sorter.setRowFilter(rf);
    }
    
    public void doubleFilter(String stringFiltre1, int idColFiltre1, String stringFiltre2, int idColFiltre2) {
    	
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
    	
    	setAllAvgField(6, 3, 2, 5);

    	
    }
    
    
    private double getAvgOfColByIdCol(int idCol) {
    	
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
    
    private void setAllAvgField(int idAgeCol, int idEmpruntAmountCol, int idInterestRateCol, int idLenghtCol) {
    	
    	DecimalFormat formatter = new DecimalFormat("#0.000");
    	
    	avgInterestRateField.setText(formatter.format(getAvgOfColByIdCol(idInterestRateCol)));
        avgEmpruntAmountField.setText(formatter.format(getAvgOfColByIdCol(idEmpruntAmountCol)));
        avgAgeField.setText(formatter.format(getAvgOfColByIdCol(idAgeCol)));
        avgLengthField.setText(formatter.format(getAvgOfColByIdCol(idLenghtCol)));
    }
    
    
}