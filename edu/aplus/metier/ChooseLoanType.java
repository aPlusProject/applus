

package edu.aplus.metier;

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
import edu.aplus.model.LoanType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class DemoModelItem {
	public String LoanTypeName;
	public float RateLoan;

	public DemoModelItem(String LoanType,float RateLoan){
		this.LoanTypeName = LoanType;
		this.RateLoan = RateLoan;
	}

	public String toString(){
		return LoanTypeName;
	}
}

public class ChooseLoanType  extends JFrame{
	public String LoanTypeName;
	JPanel contentPanel;

	static LoanType lt = new LoanType();


	private static DefaultComboBoxModel<DemoModelItem>     buildComboBoxModel() throws Exception {

		ConnectionPool conn = lt.getPool();
		Connection co= null;
		conn = new ConnectionPool();
		conn.makeStack();
		DefaultComboBoxModel<DemoModelItem> comboBoxModel;
		try {
			co = conn.getConnection();
			PreparedStatement ps;
			ResultSet rs;
			comboBoxModel = new DefaultComboBoxModel<DemoModelItem>();


			String sql = "SELECT LOAN_NAME,RATE FROM LOAN_TYPE";

			ps = co.prepareStatement(sql);
			//ps.setString(1,"LOAN_NAME");
			//	ps.setFloat(1, "RATE");
			rs = ps.executeQuery();

			while(rs.next()) {

				//this.LoanType = new LoanType();
				///this.lt.setLoanType(rs.getString(1));
				comboBoxModel.addElement(new DemoModelItem(rs.getString("LOAN_NAME"),rs.getFloat("RATE")));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			throw e;
		}finally{
			try{co.close();}catch(Exception e){;}
		}
		return comboBoxModel;


	}


	public ChooseLoanType() throws Exception  {
		setBounds(100, 100, 600, 400);
		setTitle ("Choix du type de prêt");
		JComboBox<DemoModelItem> comboBox = new JComboBox<DemoModelItem>();
		comboBox.setModel(buildComboBoxModel());
		getContentPane().setLayout(null);
		getContentPane().add(comboBox);
		JLabel choose = new JLabel("Veuillez choisir le type de prêt: ");
		choose.setBounds(145,150,200,22);
		comboBox.setBounds(170,170,187,22);
		getContentPane().add(choose);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1){
					//System.out.println("Jai choisi une valeur, je dois l'afficher dans une nouvelle fenetre"+ e.getItem());
					DemoModelItem itemSelected = (DemoModelItem) e.getItem();
					System.out.println(e.getItem().toString());
					LoanTypeName = e.getItem().toString();
					final JFrame frame = new JFrame(LoanTypeName);
					frame.getContentPane().setLayout(null);
					frame.setBounds(100, 100, 600, 400);

					JLabel description = new JLabel("Ce taux est défini pour un capital de 100 000 euros empruntés pour une durée de 7 ans");
					description.setBounds(10,2,600,20);

					JLabel label = new JLabel("Taux d'intérêt: ");
					label.setBounds(10,30,100,20);

					JButton modify = new JButton("Modifier");
					modify.setBounds(220,30,100,20);

					final JTextField champ = new JTextField(itemSelected.RateLoan+"");
					champ.setBounds(110,30,100,20);

					modify.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent actionEvent) {
							ConnectionPool conn = new ConnectionPool();
							try {
								conn.makeStack();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							//Connection connexion = conn.getConnection();

							try {
								ResultSet rs;
								PreparedStatement ps ;
								Connection co = conn.getConnection();
								String query = "UPDATE LOAN_TYPE SET RATE = "+champ.getText()+" WHERE LOAN_NAME ='"+LoanTypeName+"'";
								System.out.println(query);
								ps = co.prepareStatement(query);

								//ps.setString(1, champ.getText());
								//ps.executeUpdate();
								rs = ps.executeQuery();

								javax.swing.JOptionPane.showMessageDialog(null,"Vous êtes sur le point de modifier le taux d'intérêt"); 


							} catch (SQLException e) {
								e.printStackTrace();
							}
							PreparedStatement ps;



						}
					}); 



					JButton riskCost = new JButton("Evaluer risque");
					riskCost.setBounds(10,70,100,20);
					riskCost.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent actionEvent) {
							try {
								RiskOfCost roc = new RiskOfCost();
								roc.setVisible(true);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							//clt.setVisible(true);
						}
					});

					JButton back = new JButton ("Retour");
					back.setBounds(120,70,100,20);

					back.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent actionEvent) {
							try {
								frame.dispose();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							//clt.setVisible(true);
						}
					});
					frame.getContentPane().add(label);
					frame.getContentPane().add(champ);
					frame.getContentPane().add(modify);
					frame.getContentPane().add(back);
					frame.getContentPane().add(riskCost);
					frame.getContentPane().add(description);

					frame.setVisible(true);
					//frame.pack();
					//System.out.println(itemSelected.RateLoan);

				}
			}
		});


		//contentPanel.add(comboBox);
		//pack();
		setVisible(true);
	}







	static private String selectedString(ItemSelectable is) {

		Object selected[] = is.getSelectedObjects();
		return ((selected.length == 0) ? "null" : (String)selected[0]);
	}





} 