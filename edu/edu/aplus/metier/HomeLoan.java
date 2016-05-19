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

public class HomeLoan extends JFrame{

	private DataSource ds;
	private JPanel contentPanel;
	private Connection co;
	private Object rowData[][] = {
				{ "DUREE/MOIS", "TAUX REFERENTIEL(%)"}, 
				{"","",""},
				{ "10 ANS/120 MOIS", "1,50" }, 
				{ "15 ANS/180 MOIS", "1,85" },
				{ "20 ANS/240 MOIS", "2,05" },
				{ "25 ANS/300 MOIS", "2,20"},
				{ "30 ANS/360 MOIS", "3,50"},
			};
	private String columnNames[] = { "Durée du prêt(mois)", "Taux référentiel" };
	private JTable table = new JTable(rowData, columnNames);
	private int idSelectedIndex;




	public HomeLoan(){

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		setTitle("Prêt Immobilier");
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		
		JLabel label = new JLabel("Barème des taux immobiliers pour 100 000 euros empruntés");
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
		
		JTextField newRate = new JTextField();
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
		
		riskCost.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent actionEvent) {
			RiskOfCost rc = new RiskOfCost();
			rc.setVisible(true);
			}
		});
	
		
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

