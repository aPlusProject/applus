package edu.aplus.gui;
 
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.DefaultRowSorter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
 
public class IndicatorsToDelete{
 
	private JTable table;
	private JFrame f;
	
	
	private JTextField nbRowsField;	
	private JTextField moyInterestRateField;
	private JButton btnInterestRate;
	private JTextField moyEmpruntAmountField;
	private JButton btnEmpruntAmount;
	private JTextField moyAgeField;
	private JButton btnAge;
	private JTextField moyLengthField;
	private JButton btnLenght;
	
	private JPanel tablePanel;
	private JPanel indicatorsPanel;
	private NumberFormat formatter;

	private JRadioButton rbStAllowed;
	private JRadioButton rbStDenied;
	private JRadioButton rbStPending;
	private JRadioButton rbImmo;
	private JRadioButton rbPerso;
	private JRadioButton rbAgeJeune;         //18-25 ans
	private JRadioButton rbAgeAdulte;        //26-40 ans
	private JRadioButton rbAgePreSenior;     //41-65 ans
	private JRadioButton rbAgeSenior;        // > 65 ans
	
	private TableRowSorter<TableModel> sorter;
	
	
 
	public IndicatorsToDelete() {
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
		
		TableModel model = new DefaultTableModel(data, cols){
			public Class getColumnClass(int column) {
				Class returnValue;
				if ((column > 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		
		table = new JTable(model);
		sorter = new TableRowSorter<TableModel>(model);
		//table.setAutoCreateRowSorter(true);
		table.setRowSorter(sorter);
		
		
		
		tablePanel = new JPanel();
		
		JScrollPane jscroll = new JScrollPane(table);
		tablePanel.add(jscroll);
		
		//indicatorsPanel is the panel for common indicator that don't apply any calcul 
		
		
		nbRowsField = new JTextField();
		
		//the textfield display the total of rows in the table (recall after each changement of the table)
		nbRowsField.setEditable(false);
		nbRowsField.setText(table.getRowCount()+" sorties");
		
		//define the format of double for the display
		formatter = new DecimalFormat("#0.000");
		
		//bloc traitement of interest rate values
		moyInterestRateField = new JTextField("#############");
		moyInterestRateField.setEditable(false);
		btnInterestRate = new JButton("Taux d'interêt");
		btnInterestRate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double moy = moyenne(valueSumOfColumn(2),table.getRowCount());
				moyInterestRateField.setText(formatter.format(moy));
				
			}
			
		});
		
		//bloc traitement of emprunt amount value
		moyEmpruntAmountField = new JTextField("#############");
		moyEmpruntAmountField.setEditable(false);
		btnEmpruntAmount = new JButton("Montants empruntés");
		btnEmpruntAmount.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double moy = moyenne(valueSumOfColumn(3),table.getRowCount());
				moyEmpruntAmountField.setText(formatter.format(moy));				
			}
			
		});
		
		//bloc traitement of age value 
		moyAgeField = new JTextField("#############");
		moyAgeField.setEditable(false);
		btnAge = new JButton("Age");
		btnAge.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double moy = moyenne(valueSumOfColumn(6),table.getRowCount());
				moyAgeField.setText(formatter.format(moy));				
			}
			
		});
		
		//bloc traitement of loans lenght value
		moyLengthField = new JTextField("#############");
		moyLengthField.setEditable(false);
		btnLenght = new JButton("Durée pret");
		btnLenght.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double moy = moyenne(valueSumOfColumn(5),table.getRowCount());
				moyLengthField.setText(formatter.format(moy));				
			}
			
		});
		
		
		
		ButtonGroup cbGrp = new ButtonGroup();
		
		
		rbStAllowed = new JRadioButton("Accordé");
		rbStDenied = new JRadioButton("Refusé");
		rbStPending = new JRadioButton("En cours");
		
		rbImmo = new JRadioButton("Immobilier");
		rbPerso = new JRadioButton("Personnel");
		
		rbAgeJeune = new JRadioButton("18-25 ans");
		rbAgeAdulte = new JRadioButton("26-40 ans");
		rbAgePreSenior = new JRadioButton("41-65 ans");
		rbAgeSenior = new JRadioButton("Supérieur à 65 ans");
		
		
		cbGrp.add(rbStAllowed);
		cbGrp.add(rbStDenied);
		cbGrp.add(rbStPending);
		
		cbGrp.add(rbImmo);
		cbGrp.add(rbPerso);
		cbGrp.add(rbAgeJeune);
		cbGrp.add(rbAgeAdulte);
		cbGrp.add(rbAgePreSenior);
		cbGrp.add(rbAgeSenior);
		
		
		
		indicatorsPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.NORTH;
		//c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		
		
		// bloc of age and lenght on top
		c.gridy = 0;
		c.gridx = 0;
		indicatorsPanel.add(new JLabel("Calcul de moyennes : "), c);
		
		c.gridy = 0;
		c.gridx = 1;
		indicatorsPanel.add(btnAge, c);
		c.gridx = 2;
		indicatorsPanel.add(btnLenght, c);
		
		c.gridy = 1;
		c.gridx = 1;
		indicatorsPanel.add(moyAgeField, c);
		c.gridx = 2;
		indicatorsPanel.add(moyLengthField, c);
		
		//jump of 1 rows
		c.gridy = 2;
		c.gridx = 0;
		indicatorsPanel.add(new JLabel("   "),c);
		
		//bloc of emprunt amount and interest rate
		c.gridy = 3;
		c.gridx = 1;
		indicatorsPanel.add(btnEmpruntAmount, c);
		c.gridx = 2;
		indicatorsPanel.add(btnInterestRate, c);
		c.gridy = 4;
		c.gridx = 1;
		indicatorsPanel.add(moyEmpruntAmountField, c);
		c.gridx = 2;
		indicatorsPanel.add(moyInterestRateField, c);
		
		//jump of 1 rows
		c.gridy = 5;
		c.gridx = 0;
		indicatorsPanel.add(new JLabel("   "),c);
		
		//radio button type of loan
		c.gridy = 6;
		c.gridx = 0;
		indicatorsPanel.add(rbImmo, c);
		c.gridx = 1;
		indicatorsPanel.add(rbPerso, c);
		c.gridx = 2;
		indicatorsPanel.add(nbRowsField, c);
		
		//radio button state of loans
		c.gridy = 7;
		c.gridx = 0;
		indicatorsPanel.add(rbStAllowed, c);
		c.gridx = 1;
		indicatorsPanel.add(rbStDenied, c);
		c.gridx = 2;
		indicatorsPanel.add(rbStPending, c);
		
		
		//radio button intervalle of ages
		c.gridy = 8;
		c.gridx = 0;
		indicatorsPanel.add(rbAgeJeune);
		c.gridx = 1;
		indicatorsPanel.add(rbAgeAdulte);
		c.gridx = 2;
		indicatorsPanel.add(rbAgePreSenior);
		c.gridy = 9;
		c.gridx = 0;
		indicatorsPanel.add(rbAgeSenior);
		
	
		
		rbImmo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				applyTableFilter("immobilier");
				nbRowsField.setText(table.getRowCount()+" sorties");
			}
			
		});
		
		rbPerso.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				applyTableFilter("personnel");
				nbRowsField.setText(table.getRowCount()+" sorties");
			}
			
		});
		
		rbStAllowed.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//applyTableFilter("");
				applyTableFilter("accordé");
				nbRowsField.setText(table.getRowCount()+" sorties");
				
			}
			
		});
		
		rbStDenied.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//applyTableFilter("");
				applyTableFilter("refusé");
				nbRowsField.setText(table.getRowCount()+" sorties");
				
			}
			
		});
		
		rbStPending.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//applyTableFilter("");
				applyTableFilter("en cours");
				nbRowsField.setText(table.getRowCount()+" sorties");
				
			}
			
		});
		
		
		
		f = new JFrame();
		f.setLayout(new GridLayout(0, 1));
		
		f.setSize(1000, 700);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.getContentPane().add(tablePanel, BorderLayout.CENTER);
		f.getContentPane().add(indicatorsPanel, BorderLayout.EAST);
		
		
		f.setVisible(true);
		
	}
 
	private void actionOnAvgField() {
		//TODO : créer l'algo pour factoriser le calcules des avg pour tous les champs
		
	}

	private void applyTableFilter(String filterText) {
		
		
		// escape the text so the content will not be considered as a regexp
		
		if (filterText.length() == 0 || filterText == null) {
	          sorter.setRowFilter(null);
	    } else {
	    	String escapedFilterText = Pattern.quote(filterText);
	    	sorter.setRowFilter(RowFilter.regexFilter(escapedFilterText));
	    }
	}
	
	/*public void filterTableByAges(int ageMin, int ageMax) {
		/*List<RowFilter<TableModel,String>> filters = new ArrayList<RowFilter<TableModel,String>>(2);
		filters.add( RowFilter.rowFilter(ComparisonType.AFTER, ageMin) );
		filters.add( RowFilter.rowFilter(ComparisonType.BEFORE, ageMax) 
		RowFilter<Object, Object> rf = RowFilter.andFilter("selecta", 0);
		sorter.setRowFilter(rf);
	}*/
	
	
	
	/**
	 * 
	 * @param numCol >= 0
	 * 
	 * the content of the column must be number 
	 * 
	 */
	public double valueSumOfColumn(int numCol) {
		double sum = 0;
		for(int i=0; i < table.getRowCount(); i++) {
			sum = sum +  Double.parseDouble(table.getValueAt(i, numCol)+"");
		}
		return sum;
	}
	
	/**
	 * 
	 * @param totalValue > 0 else return 0
	 * @param coeff > 0 else return 0
	 * @return the moyenne
	 */
	public double moyenne(double totalValue, int coeff) {
		
		double moy = 0;
		if ((totalValue > 0) && (coeff > 0)) {
			moy = totalValue/coeff;
		}
		
		
		return moy;
	}
		
 
	public static void main(String[] args) {
		new IndicatorsToDelete();
	}
}