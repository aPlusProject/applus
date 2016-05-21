package edu.aplus.gui;
 
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.GridLayout;
import java.util.regex.Pattern;
 
import javax.swing.DefaultRowSorter;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
 
public class TableFiltering {
 
	private JTextField filterTextField;
	private JTable filteredTable;
	private JFrame f;
	private Checkbox boxImmo;
	private Checkbox boxPerso;
 
	public TableFiltering() {
		String[] cols = { "N° Pret", "Statut", "Taux interet", "Montant emprunté", "Type de prêt" };
		String[][] data = { { "01", "accordé", "2.5", "3000", "personnel" },
				{ "02", "refusé", "1.25", "30000", "immobilier" },
				{"03", "en cours", "2.00", "5000", "personnel"} };
		filteredTable = new JTable(data, cols);
		filteredTable.setAutoCreateRowSorter(true);
		/*filterTextField = new JTextField();
		filterTextField.getDocument().addDocumentListener(
				new DocumentListener() {
 
					@Override
					public void removeUpdate(DocumentEvent e) {
						applyTableFilter(filterTextField.getText());
					}
 
					@Override
					public void insertUpdate(DocumentEvent e) {
						applyTableFilter(filterTextField.getText());
					}
 
					@Override
					public void changedUpdate(DocumentEvent e) {
						applyTableFilter(filterTextField.getText());
					}
				});
		*/
		boxImmo = new Checkbox("immobilier");
		boxPerso = new Checkbox("personnel");
		
		
		
		f = new JFrame();
		f.setLayout(new GridLayout(1, 0));
		f.add(new JScrollPane(filteredTable));
		//f.add(filterTextField, BorderLayout.SOUTH);
		f.add(boxImmo, BorderLayout.SOUTH);
		
		f.add(boxPerso, BorderLayout.PAGE_END);
		f.setSize(1000, 700);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
 
	private void applyTableFilter(String filterText) {
		// On escape le texte afin que son contenu ne soit pas considéré comme
		// une regexp
		String escapedFilterText = Pattern.quote(filterText);
		// On ajoute les wildcards a gauche et a droite
		String completeFilterText = ".*" + escapedFilterText + ".*";
		// On applique le filtre a la JTable
		((DefaultRowSorter) filteredTable.getRowSorter())
				.setRowFilter(RowFilter.regexFilter(completeFilterText));
	}
 
	public static void main(String[] args) {
		new TableFiltering();
	}
}