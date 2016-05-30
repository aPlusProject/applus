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
/* The most important part of the project is is this class
 * We first have an IHM which allow us to choose the rate type that we want, so that it will display its rates loan.
 * We use for that : 
 * RateType: the type of the loan so type of rate ( we consider that the rate value depends also on the type
 * RateLoan : The rate corresponding to that type
 * <DemoModelItem>: is a generic class used to fill the comboBox by getting the information in the databae
 * 
 */



public class ChooseLoanTypePanel extends JFrame {

	ChooseLoanType clt;
	static String RateType;
	JPanel contentPanel;
	private Loan loan ;
	static Rate rate = new Rate();
	static int loanDuration;
	String rateTF;
	static JTextField champ ;
	static float RateLoan;


	static DefaultComboBoxModel<DemoModelItem> combox;		
	static DemoModelItem dmi = new DemoModelItem(RateType,RateLoan);
	protected DemoModelItem itemSelected;


	public ChooseLoanTypePanel() throws Exception {
		JComboBox comboBox = new JComboBox();  
		comboBox.setModel(dmi.buildComboBoxModel()); 

		setBounds(100, 100, 600, 400);
		setTitle ("Choix du type de prêt");
		getContentPane().setLayout(null);
		getContentPane().add(comboBox);
		JLabel choose = new JLabel("Veuillez choisir le type de prêt: ");
		choose.setBounds(145,150,200,22);
		comboBox.setBounds(170,170,187,22);
		getContentPane().add(choose);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) { // to know which item is selected
				if (e.getStateChange() == 1){
					//System.out.println("Jai choisi une valeur, je dois l'afficher dans une nouvelle fenetre"+ e.getItem());
					itemSelected = (DemoModelItem) e.getItem();
					System.out.println(e.getItem().toString());
					RateType = e.getItem().toString();
					final JFrame frame = new JFrame(RateType);// name of the frame can be "Pret immo, conso, or profesionnel"
					frame.getContentPane().setLayout(null);
					frame.setBounds(100, 100, 600, 400);
					final JLabel description = new JLabel("Ce taux est défini pour un capital de 100 000 euros empruntés pour une durée min de 7 ans");
					description.setBounds(10,2,600,20);
					final JLabel label = new JLabel("Taux d'intérêt: ");
					label.setBounds(10,30,100,20);
					champ = new JTextField(itemSelected.RateLoan+"");// it displays the rateloan of the loan type selected
					//rateTF= champ.getText();
					champ.setBounds(110,30,100,20);
					final JButton modify = new JButton("Modifier le taux"); // it is in order to let the director modify the rate and add it into a new column in the datatable
					modify.setBounds(220,30,130,20);
					modify.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent actionEvent) {
							float f = Float.parseFloat(champ.getText());
							ChooseLoanType clt = new ChooseLoanType();
							clt.modifyRate(f);
							javax.swing.JOptionPane.showMessageDialog(null,"Vous avez bien modifié le taux d'intérêt de l'agence"); 

						}});

					// end of modify.addactionlistener



					final JButton setDuration = new JButton("Durée pret");
					setDuration.setBounds(120,70,100,20);
					setDuration.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent actionEvent) {
							try {
								AddDurationPanel adp = new AddDurationPanel();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} });

					final JButton riskCost = new JButton("Evaluer risque"); // the frame to evaluate the risks of changing the rate
					riskCost.setBounds(10,70,100,20);
					riskCost.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent actionEvent) {
							try {
								new EvaluateRiskPanel();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}


						}
					});
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
					frame.getContentPane().add(modify);		//	
					frame.getContentPane().add(riskCost);
					frame.getContentPane().add(description);
					frame.getContentPane().add(setDuration);
					frame.getContentPane().add(back);
					frame.setVisible(true);
				}
			}	});

		//	frame.getContentPane().add(back)

		setVisible(true);
	}




	public static String getRateType() {
		return RateType;
	}




	public static void setRateType(String rateType) {
		RateType = rateType;
	}




	public static JTextField getRateTF (){
		return champ;								
	}
	




}


