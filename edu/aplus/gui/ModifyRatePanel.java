package edu.aplus.gui;

import java.awt.BorderLayout;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import edu.aplus.db.ConnectionPool;
import edu.aplus.model.Rate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import edu.aplus.model.Loan;
import edu.aplus.metier.ChooseLoanType;
import edu.aplus.metier.DemoModelItem;



public class ModifyRatePanel extends JFrame {

	ChooseLoanType clt;
	//ChooseLoanTypePanel cltp;
	JComboBox<DemoModelItem> comboBox;
	




	public ModifyRatePanel() throws Exception {
		
		getContentPane().setLayout(null);
		setBounds(100, 100, 600, 400);

		final JLabel description = new JLabel("Ce taux est défini pour un capital de 100 000 euros empruntés pour une durée min de 7 ans");
		description.setBounds(10,2,600,20);

		final JLabel label = new JLabel("Taux d'intérêt: ");
		label.setBounds(10,30,100,20);
		
		final JTextField champ = new JTextField(comboBox.getSelectedItem()+""); // it displays the rateloan of the loan type selected
		champ.setBounds(110,30,100,20);

		final JButton modify = new JButton("Modifier le taux"); // it is in order to let the director modify the rate and add it into a new column in the datatable
		modify.setBounds(220,30,130,20);
		modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				float f = Float.parseFloat(champ.getText());
				clt.modifyRate(f);
				}

		});
		

		getContentPane().add(label);
		getContentPane().add(champ);
		getContentPane().add(modify);		//	frame.getContentPane().add(back);
		getContentPane().add(description);
		}
	
}