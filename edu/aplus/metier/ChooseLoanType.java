

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
import edu.aplus.model.Rate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import edu.aplus.model.Loan;


class DemoModelItem {
	public String RateType;
	public float RateLoan;

	public DemoModelItem(String RateType,float RateLoan){
		this.RateType = RateType;
		this.RateLoan = RateLoan;
	}

	public String toString(){
		return RateType;
	}
}

public class ChooseLoanType  extends JFrame{
	public static String RateType;
	JPanel contentPanel;
	private Loan loan ;
	static Rate rate = new Rate();
	static int loanDuration;
	private int durationInt;
	


	private static DefaultComboBoxModel<DemoModelItem> buildComboBoxModel() throws Exception {

		ConnectionPool conn = rate.getPool();
		Connection co= null;
		conn = new ConnectionPool();
		conn.makeStack();
		DefaultComboBoxModel<DemoModelItem> comboBoxModel = null;


		try {
			co = conn.getConnection();
			PreparedStatement ps;
			ResultSet rs;
			comboBoxModel = new DefaultComboBoxModel<DemoModelItem>();
			String sql = "SELECT RATE_TYPE,MIN(RATE_VALUE) FROM RATE GROUP BY RATE_TYPE";
			ps = co.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {

				//this.LoanType = new LoanType();
				///this.lt.setLoanType(rs.getString(1));
				comboBoxModel.addElement(new DemoModelItem(rs.getString("RATE_TYPE"),rs.getFloat("MIN(RATE_VALUE)")));
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

	public int getLoanDuration() {
		return this.durationInt;
	}


	public void setLoanDuration(int durationInt) {
		this.durationInt = durationInt;
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
					final DemoModelItem itemSelected = (DemoModelItem) e.getItem();
					System.out.println(e.getItem().toString());
					RateType = e.getItem().toString();
					final JFrame frame = new JFrame(RateType);
					frame.getContentPane().setLayout(null);
					frame.setBounds(100, 100, 600, 400);

					final JLabel description = new JLabel("Ce taux est défini pour un capital de 100 000 euros empruntés pour une durée min de 7 ans");
					description.setBounds(10,2,600,20);

					final JLabel label = new JLabel("Taux d'intérêt: ");
					label.setBounds(10,30,100,20);

					final JTextField champ = new JTextField(itemSelected.RateLoan+"");
					champ.setBounds(110,30,100,20);

					final JButton modify = new JButton("Modifier le taux");
					modify.setBounds(220,30,130,20);

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
							try{
								ResultSet rs;
								PreparedStatement ps ;
								Connection co = conn.getConnection();

								
								String query = "UPDATE RATE SET RATE_AGENCY = "+champ.getText()+" WHERE RATE_TYPE ='"+RateType+"'";

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
					}); // end of modify.addactionlistener


					final JButton setDuration = new JButton("Durée pret");
					setDuration.setBounds(120,70,100,20);
					setDuration.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent actionEvent) {
							final ConnectionPool conn = new ConnectionPool();
							final JFrame frame2 = new JFrame(RateType);
							frame2.getContentPane().setLayout(null);

							frame2.setTitle("Modifier durée pret");
							frame2.setBounds(100, 100, 300, 300);
							frame2.getContentPane().setBounds(100, 100, 200, 200);
							final JLabel labelSetPret = new JLabel ("Entrez la durée du pret");
							labelSetPret.setBounds(10,10,200,30);
							final JTextField entrerDuree = new JTextField();
							entrerDuree.setBounds(10,50,120,30);

							final JButton validerDuree = new JButton("Valider");
							validerDuree.setBounds(10,90,120,30);
							validerDuree.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent actionEvent) {
									try {
										conn.makeStack();
									} catch (ClassNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try{
										ResultSet rs;
										PreparedStatement ps ;
										Connection co = conn.getConnection();
										String query = "SELECT RATE_VALUE FROM RATE WHERE RATE_DURATION ="+entrerDuree.getText()+" AND RATE_TYPE = '"+itemSelected.RateType+"'";      

										ps = co.prepareStatement(query);
										rs = ps.executeQuery();

										while(rs.next()) {

											champ.setText(rs.getString("RATE_VALUE"));
										}
										
										//setLoanDuration(entrerDuree.getText());
										String durationString = entrerDuree.getText();
										int durationInt; 
										durationInt = Integer.parseInt(durationString); 
										System.out.println(durationInt);
										setLoanDuration(durationInt);
										System.out.println(getLoanDuration());



										rs.close();
										ps.close();
										frame.setVisible(true);

										//System.out.println(itemSelected.RateLoan+"");
										//System.out.println(query);
										//ps = co.prepareStatement(query);

										//ps.setString(1, champ.getText());
										//ps.executeUpdate();
										//rs = ps.executeQuery();



									} catch (SQLException e) {
										e.printStackTrace();
									}
									PreparedStatement ps;
							} });// nd of duree add action listenrr
							JButton back2frame = new JButton ("Retour");
							back2frame.setBounds(140,90,100,30);

							back2frame.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent actionEvent) {
									try {
										frame2.dispose();
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									//clt.setVisible(true);
								}
							});
							
							
							frame2.getContentPane().add(entrerDuree);
							frame2.getContentPane().add(validerDuree);
							frame2.getContentPane().add(labelSetPret);
							frame2.getContentPane().add(back2frame);

							frame2.setVisible(true);


						} });
					final JButton riskCost = new JButton("Evaluer risque");
					riskCost.setBounds(10,70,100,20);
					riskCost.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent actionEvent) {
								final ConnectionPool conn = new ConnectionPool();
								final JFrame frame3 = new JFrame(RateType);
								frame3.getContentPane().setLayout(null);

								frame3.setTitle("Evaluer risque");
								frame3.setBounds(100, 100, 300, 300);
								frame3.getContentPane().setBounds(100, 100, 300, 300);
								final JLabel labelSetPret = new JLabel ("Taux de la maison-mere:");
								labelSetPret.setBounds(10,10,200,30);
								final JTextField hqRate = new JTextField();
								hqRate.setBounds(10,50,120,30);
								final JLabel labelAgencyRate = new JLabel ("Taux de l'agence:");
								labelAgencyRate.setBounds(180,10,200,30);
								final JTextField agencyRate = new JTextField();
								agencyRate.setBounds(180,50,120,30);
										try {
											conn.makeStack();
										} catch (ClassNotFoundException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										try{
											ResultSet rs, rs2;
											PreparedStatement ps ;
											PreparedStatement ps2 ;

											Connection co = conn.getConnection();
											String query = "SELECT RATE_VALUE FROM RATE WHERE RATE_DURATION ="+getLoanDuration()+" AND RATE_TYPE = '"+itemSelected.RateType+"'";      
											String query2 = "SELECT RATE_AGENCY FROM RATE WHERE RATE_DURATION ="+getLoanDuration()+" AND RATE_TYPE = '"+itemSelected.RateType+"'";    
											System.out.println(query);
											System.out.println(query2);

											ps = co.prepareStatement(query);
											ps2 = co.prepareStatement(query2);
											rs = ps.executeQuery();
											rs2 = ps2.executeQuery();


											while(rs.next() && rs2.next()) {
											

												hqRate.setText(rs.getString("RATE_VALUE"));
												agencyRate.setText(rs2.getString("RATE_AGENCY"));

											}
											
											//setLoanDuration(entrerDuree.getText());
											rs.close();
											rs2.close();
											ps.close();
											ps2.close();
											frame.setVisible(true);

										} catch (SQLException e) {
											e.printStackTrace();
										}
										
													
										
										frame3.getContentPane().add(labelSetPret);
										frame3.getContentPane().add(hqRate);		
										frame3.getContentPane().add(agencyRate);
										frame3.getContentPane().add(labelAgencyRate);
										frame3.setVisible(true);
								} });// nd of duree add action listenrr
					
					
					JButton back = new JButton ("Retour");
					back.setBounds(240,70,100,20);

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
					frame.getContentPane().add(setDuration);


					frame.setVisible(true);
					//frame.pack();
					//System.out.println(itemSelected.RateLoan);

				}}

		});


		//contentPanel.add(comboBox);
		//pack();
		setVisible(true);
	}


	

} 