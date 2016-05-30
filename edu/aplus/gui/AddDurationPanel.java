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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import edu.aplus.db.ConnectionPool;
import edu.aplus.model.Rate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import edu.aplus.model.Loan;
import edu.aplus.metier.ChooseLoanType;
import edu.aplus.gui.ChooseLoanTypePanel;
/* This frame is for adding a duration
 * when you enter in this frame, the rate is in basis duration depeding on the loan
 * so to set the duration you'll have to fill the field
 * by the textfield @entrerDuree.
 * 
 */



public class AddDurationPanel extends JFrame {

	ChooseLoanType clt;
	ChooseLoanTypePanel cltp;
	static JTextField entrerDuree ;
	static String entrerDureeS ;


	public AddDurationPanel() throws Exception{



		final JFrame frame2 = new JFrame("Modifier la durée");
		frame2.getContentPane().setLayout(null);
		frame2.setBounds(100, 100, 500, 500);
		frame2.getContentPane().setBounds(100, 100, 500, 500);
		final JLabel labelSetPret = new JLabel ("Entrez la durée du pret");
		labelSetPret.setBounds(10,10,200,30);
		entrerDuree = new JTextField();
		entrerDuree.setBounds(10,50,120,30);

		final JButton validerDuree = new JButton("Valider"); // là on peut modifier la durée et ajouter le taux correspondant
		validerDuree.setBounds(10,90,120,30);
		validerDuree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				ChooseLoanType clt = new ChooseLoanType();
				entrerDureeS = entrerDuree.getText();
				try{
					if(!isInteger(entrerDureeS)){
						JOptionPane.showMessageDialog(null,
								"Veuillez entrer la durée au bon format", 
								"Error", JOptionPane.ERROR_MESSAGE);}
					clt.setDuration(entrerDureeS); }  catch (Exception e){};
					frame2.dispose();

			} });
		final JLabel explain = new JLabel("PS : Ci-dessous le barème des durées de prêt (en années) ");
		final JLabel explain2 = new JLabel("Taux crédit immobilier: 7, 10, 15, 20, 25, 30 ");
		final JLabel explain3 = new JLabel("Taux crédit de conso et professionnel: 1, 2, 3, 4, 5, 6 ");
		explain.setBounds(10,200,390,30);
		explain2.setBounds(10,225,390,30);
		explain3.setBounds(10,250,390,30);
		frame2.add(explain);
		frame2.add(explain2);
		frame2.add(explain3);

		JButton back2frame = new JButton ("Retour"); // get back to the last frame opened
		back2frame.setBounds(140,90,100,30);

		back2frame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					frame2.dispose();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});


		frame2.getContentPane().add(entrerDuree);
		frame2.getContentPane().add(validerDuree);
		frame2.getContentPane().add(labelSetPret);
		frame2.getContentPane().add(back2frame);
		frame2.setVisible(true);

}
	
	public static boolean isInteger(String s) { // methode to check the textfield 
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    // only got here if we didn't return false
	    return true;
	}
	
	public static int getDuree (){
		int i = Integer.parseInt(entrerDureeS);
		return i;								
	}
}