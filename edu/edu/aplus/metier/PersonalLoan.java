package edu.aplus.metier;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.sql.DataSource;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PersonalLoan extends JFrame{

	private DataSource ds;
	private JPanel contentPanel;
	private Connection co;
	private Object rowData[][] = {
				{ "DUREE/MOIS", "TAUX REFERENTIEL(%)"}, 
				{"","",""},
				{ "12 MOIS", "2,49" }, 
				{ "24 MOIS", "2,30" },
				{ "36 MOIS", "2,80" },
				{ "48 MOIS", "2,89"},
				{ "60 MOIS", "3,50"},
				{ "72 MOIS", "4,50"},
			};
	private String columnNames[] = { "Durée du prêt(mois)", "Taux référentiel" };
	private JTable table = new JTable(rowData, columnNames);
	private int idSelectedIndex;


	

	public PersonalLoan(){

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		setTitle("Prêt de Consommation");
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		
		JLabel label = new JLabel("Barème des taux de consommation pour 15 000 euros empruntés");
		label.setBounds(10, 0, 500, 29);
		contentPanel.add(label);
		
		// Highligh selected row
		ListSelectionModel selectionModel = 
				  table.getSelectionModel();
				selectionModel.setSelectionInterval(1,1);
				
		JScrollPane scrollPane = new JScrollPane(table);
		table.setBounds(20,40, 400, 150);

		contentPanel.add(scrollPane, BorderLayout.CENTER);
		contentPanel.add(table) ;
		
		final JTextField newRate = new JTextField();
		newRate.setBounds(10,200,113,29);
		contentPanel.add(newRate);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					idSelectedIndex = ((ListSelectionModel) e.getSource()).getMinSelectionIndex();
					if(idSelectedIndex < 2){
						newRate.setText("");
						return;
					}
					newRate.setText(rowData[idSelectedIndex][1]+"");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

			
		});

		JButton modify = new JButton ("Modifier taux");
		modify.setBounds(150,200,113,29);
		contentPanel.add(modify);
		
		modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				if(idSelectedIndex < 2){
					newRate.setText("");
					return;
				}
				rowData[idSelectedIndex][1] = newRate.getText();
				table.getModel().setValueAt(rowData[idSelectedIndex][1], idSelectedIndex, 1);
			}
		});
		
		JButton riskCost = new JButton ("Coût du risque");
		riskCost.setBounds(270,200,129,29);
		contentPanel.add(riskCost);
		
		JButton back = new JButton ("Retour");
		back.setBounds(10,250,129,29);
		contentPanel.add(back);
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				ChooseLoanType clt = new ChooseLoanType();
				clt.setVisible(true);
			}
		});
		
	}
	
	
	
	public Object getValueAt(int row, int col) {
	    return rowData[row][col];
	}
		public void setValueAt(Object value, int row, int col) {
	    rowData[row][col] = value;
	}


}

