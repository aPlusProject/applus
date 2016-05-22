package edu.aplus.gui;
 
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.regex.Pattern;
 
import javax.swing.DefaultRowSorter;
import javax.swing.JButton;
import javax.swing.JFrame;
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
 
	private JTextField filterTextField;
	private JTable table;
	private JFrame f;
	private Checkbox boxImmo;
	private Checkbox boxPerso;
	private JTextField nbRowsField;
	
	private JPanel tablePanel;
	private JPanel indicatorsPanel;
 
	public Indicators() {
		String[] cols = { "N° Pret", "Statut", "Taux interet", "Montant emprunté", "Type de prêt" , "Durée"};
		String[][] data = { { "01", "accordé", "2.5", "3000", "personnel", "2" },
				{ "02", "refusé", "1.25", "30000", "immobilier", "8" },
				{"03", "en cours", "2.00", "5000", "personnel", "3"}, 
				{ "04", "accordé", "1.25", "30000", "personnel", "10" },
			};
		table = new JTable(data, cols);
		table.setAutoCreateRowSorter(true);
		//filterTextField = new JTextField();
		/*filterTextField.getDocument().addDocumentListener(
				new DocumentListener() {
 
					@Override
					public void removeUpdate(DocumentEvent e) {
						
						if(boxImmo.isEnabled()) {
							applyTableFilter("immobilier");
						}
					}
 
					@Override
					public void insertUpdate(DocumentEvent e) {
						if(boxImmo.isEnabled()) {
							applyTableFilter("immobilier");
						}
					}
 
					@Override
					public void changedUpdate(DocumentEvent e) {
						if(boxImmo.isEnabled()) {
							applyTableFilter("immobilier");
						}
					}
		});*/
		
		tablePanel = new JPanel();
		
		JScrollPane jscroll = new JScrollPane(table);
		tablePanel.add(jscroll);
		
		//indicatorsPanel is the panel for common indicator that don't apply any calcul 
		indicatorsPanel = new JPanel();
		boxImmo = new Checkbox("immobilier");
		boxPerso = new Checkbox("personnel");
		nbRowsField = new JTextField();
		
		//the textfield display the total of rows in the table (recall after each changement of the table)
		nbRowsField.setEditable(false);
		nbRowsField.setText(table.getRowCount()+" sorties");
		
		
		indicatorsPanel.add(boxImmo);
		indicatorsPanel.add(boxPerso);
		indicatorsPanel.add(nbRowsField);
		
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
		// On escape le texte afin que son contenu ne soit pas considéré comme
		// une regexp
		String escapedFilterText = Pattern.quote(filterText);
		// On ajoute les wildcards a gauche et a droite
		String completeFilterText = ".*" + escapedFilterText + ".*";
		// On applique le filtre a la JTable
		((DefaultRowSorter) table.getRowSorter())
				.setRowFilter(RowFilter.regexFilter(completeFilterText));
	}
 
	public static void main(String[] args) {
		new Indicators();
	}
}