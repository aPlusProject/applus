package IHM;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Employee_info extends JPanel {
	private JTextField IDtextField;
	private JTextField Montant_textField;
	private JTextField Taux_textField;
	private JTextField Duree_textField;

	/**
	 * Create the panel.
	 */
	public Employee_info() {
		setLayout(null);
		
		JLabel nameLabel = new JLabel("");
		nameLabel.setBounds(10, 11, 418, 14);
		add(nameLabel);
		
		JLabel infoLabel = new JLabel("");
		infoLabel.setBounds(10, 36, 418, 14);
		add(infoLabel);
		
		IDtextField = new JTextField();
		IDtextField.setBounds(116, 97, 86, 20);
		add(IDtextField);
		IDtextField.setColumns(10);
		
		JLabel lblIdClient = new JLabel("ID client");
		lblIdClient.setBounds(10, 100, 75, 14);
		add(lblIdClient);
		
		JLabel lblMontant = new JLabel("Montant");
		lblMontant.setBounds(10, 131, 56, 14);
		add(lblMontant);
		
		Montant_textField = new JTextField();
		Montant_textField.setBounds(116, 128, 86, 20);
		add(Montant_textField);
		Montant_textField.setColumns(10);
		
		JLabel lblDure = new JLabel("Dur\u00E9e");
		lblDure.setBounds(10, 165, 46, 14);
		add(lblDure);
		
		Duree_textField = new JTextField();
		Duree_textField.setBounds(116, 162, 86, 20);
		add(Duree_textField);
		Duree_textField.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 190, 19, 20);
		add(label);
		
		JLabel lblTaux = new JLabel("Taux");
		lblTaux.setBounds(10, 201, 46, 14);
		add(lblTaux);
		
		Taux_textField = new JTextField();
		Taux_textField.setBounds(116, 198, 86, 20);
		add(Taux_textField);
		Taux_textField.setColumns(10);
		
		JButton btnSimuler = new JButton("Simuler");
		btnSimuler.setBounds(241, 245, 89, 23);
		add(btnSimuler);
		
		
		JLabel lblEuro = new JLabel("euro");
		lblEuro.setBounds(225, 131, 46, 14);
		add(lblEuro);
		
		JLabel lblAns = new JLabel("ans");
		lblAns.setBounds(225, 165, 46, 14);
		add(lblAns);
		
		JLabel label_2 = new JLabel("%");
		label_2.setBounds(225, 196, 46, 14);
		add(label_2);

	}
}
