package edu.aplus.gui;
 
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Pattern;
 
import javax.swing.DefaultRowSorter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
 
public class Indicators extends JFrame{
 
	private JTable table;
	private JFrame f;
	private Checkbox boxImmo;
	private Checkbox boxPerso;
	
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

 
	public Indicators() {
		String[] cols = { "N� Pret", "Statut", "Taux interet", "Montant emprunt�", "Type de pr�t" , "Dur�e", "age"};
		String[][] data = { { "01", "accord�", "2.5", "3000", "personnel", "2" , "20"},
				{ "02", "refus�", "1.25", "30000", "immobilier", "8" ,"54"},
				{"03", "en cours", "2.00", "5000", "personnel", "3", "35"}, 
				{ "04", "en cours", "1.25", "30000", "personnel", "10" , "58"},
				{ "05", "refus�", "1.50", "3000", "immobilier", "5" , "38"},
				{ "06", "accord�", "1.25", "30000", "personnel", "10" , "68"},
				{ "07", "accord�", "1.25", "30000", "personnel", "4" , "22"},
				{ "08", "en cours", "2.05", "15000", "immobilier", "2" , "45"},
			};
		table = new JTable(data, cols);
		table.setAutoCreateRowSorter(true);
		
		tablePanel = new JPanel();
		
		JScrollPane jscroll = new JScrollPane(table);
		tablePanel.add(jscroll);
		
		//indicatorsPanel is the panel for common indicator that don't apply any calcul 
		
		boxImmo = new Checkbox("immobilier");
		boxPerso = new Checkbox("personnel");
		nbRowsField = new JTextField();
		
		//the textfield display the total of rows in the table (recall after each changement of the table)
		nbRowsField.setEditable(false);
		nbRowsField.setText(table.getRowCount()+" sorties");
		
		//define the format of double for the display
		formatter = new DecimalFormat("#0.000");
		
		//bloc traitement of interest rate values
		moyInterestRateField = new JTextField("#############");
		moyInterestRateField.setEditable(false);
		btnInterestRate = new JButton("Taux d'inter�t");
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
		btnEmpruntAmount = new JButton("Montants emprunt�s");
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
		btnLenght = new JButton("Dur�e pret");
		btnLenght.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double moy = moyenne(valueSumOfColumn(5),table.getRowCount());
				moyLengthField.setText(formatter.format(moy));				
			}
			
		});
		
		indicatorsPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.NORTH;
		//c.fill = GridBagConstraints.HORIZONTAL;
		
		//checkbox on top
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		indicatorsPanel.add(boxImmo, c);
		c.gridx = 1;
		indicatorsPanel.add(boxPerso, c);
		c.gridx = 2;
		indicatorsPanel.add(nbRowsField, c);
		
		//jump of 2 rows
		c.gridy = 1;
		c.gridx = 0;
		indicatorsPanel.add(new JLabel("   "),c);
		c.gridy = 2;
		indicatorsPanel.add(new JLabel("   "),c);
		
		// bloc of age and lenght
		c.gridy = 5;
		c.gridx = 0;
		indicatorsPanel.add(new JLabel("Calcul de moyennes"), c);
		
		c.gridy = 3;
		c.gridx = 2;
		indicatorsPanel.add(btnAge, c);
		c.gridx = 3;
		indicatorsPanel.add(btnLenght, c);
		
		c.gridy = 4;
		c.gridx = 2;
		indicatorsPanel.add(moyAgeField, c);
		c.gridx = 3;
		indicatorsPanel.add(moyLengthField, c);
		
		
		
		
		//jump of 1 rows
		c.gridy = 5;
		indicatorsPanel.add(new JLabel("   "),c);
		
		//bloc of emprunt amount and interest rate
		c.gridy = 6;
		c.gridx = 2;
		indicatorsPanel.add(btnEmpruntAmount, c);
		c.gridx = 3;
		indicatorsPanel.add(btnInterestRate, c);
		c.gridy = 7;
		c.gridx = 2;
		indicatorsPanel.add(moyEmpruntAmountField, c);
		c.gridx = 3;
		indicatorsPanel.add(moyInterestRateField, c);
		
		
		
		
		boxImmo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(boxImmo.getState() && !boxPerso.getState()) {
					applyTableFilter("immobilier");
					nbRowsField.setText(table.getRowCount()+" sorties");
				}
				else if(boxImmo.getState() && boxPerso.getState()) {
					applyTableFilter("immobilier");
					applyTableFilter("personnel");
					nbRowsField.setText(table.getRowCount()+" sorties");
				}
				else if(!boxImmo.getState() && !boxPerso.getState()) {
					applyTableFilter("");
					nbRowsField.setText(table.getRowCount()+" sorties");
				}
				else if(!boxImmo.getState() && boxPerso.getState()) {
					applyTableFilter("personnel");
					nbRowsField.setText(table.getRowCount()+" sorties");
				}
				
			}
			
		});
		
		boxPerso.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(boxPerso.getState() && !boxImmo.getState()) {
					applyTableFilter("personnel");
					nbRowsField.setText(table.getRowCount()+" sorties");
				}
				else if(boxPerso.getState() && boxImmo.getState() ){
					applyTableFilter("personnel");
					applyTableFilter("immobilier");
					nbRowsField.setText(table.getRowCount()+" sorties");
				}
				else if(!boxPerso.getState() && !boxImmo.getState()) {
					applyTableFilter("");
					nbRowsField.setText(table.getRowCount()+" sorties");
				}
				else if(!boxPerso.getState() && boxImmo.getState()) {
					applyTableFilter("immobilier");
					nbRowsField.setText(table.getRowCount()+" sorties");
				}
			}
			
		});
		
		
		
		f = new JFrame();
		f.setLayout(new GridLayout(1, 1));
		//f.add(new JScrollPane(filteredTable));
		//f.add(filterTextField, BorderLayout.SOUTH);
		//f.add(boxImmo, BorderLayout.SOUTH);
		
		//f.add(boxPerso, BorderLayout.PAGE_END);
		
		f.setSize(1000, 700);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.getContentPane().add(tablePanel, BorderLayout.CENTER);
		f.getContentPane().add(indicatorsPanel, BorderLayout.EAST);
		
		
		f.setVisible(true);
	}
 
	private void applyTableFilter(String filterText) {
		// On escape le texte afin que son contenu ne soit pas consid�r� comme
		// une regexp
		String escapedFilterText = Pattern.quote(filterText);
		// On ajoute les wildcards a gauche et a droite
		String completeFilterText = ".*" + escapedFilterText + ".*";
		// On applique le filtre a la JTable
		((DefaultRowSorter) table.getRowSorter())
				.setRowFilter(RowFilter.regexFilter(completeFilterText));
	}
	
	
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
		new Indicators();
	}
}