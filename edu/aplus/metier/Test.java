package edu.aplus.metier;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import edu.aplus.model.Rate;
import edu.aplus.db.ConnectionPool;




public class Test extends JFrame {

	ButtonGroup lngGrp = null;
	private Rate rate;

	public void init(){

		//create group
		lngGrp = new ButtonGroup();

		//create checkboxes and add to group


	}

	public ButtonGroup checkbox  () throws Exception {
		ConnectionPool conn = rate.getPool();
		Connection co= null;
		conn = new ConnectionPool();
		conn.makeStack();
		ButtonGroup lngGrp;
		try {
			co = conn.getConnection();
			PreparedStatement ps;
			ResultSet rs;
			lngGrp = new ButtonGroup();


			String sql = "SELECT RATE_DURATION FROM RATE";

			ps = co.prepareStatement(sql);
			//ps.setString(1,"LOAN_NAME");
			//	ps.setFloat(1, "RATE");
			rs = ps.executeQuery();

			while(rs.next()) {

				//this.LoanType = new LoanType();
				///this.lt.setLoanType(rs.getString(1));
				lngGrp.add(new JRadioButton(rs.getString("RATE_DURATION")));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			throw e;
		}finally{
			try{co.close();}catch(Exception e){;}
		}
		
		setBounds(100, 100, 600, 400);
		setTitle ("Choix duree de prêt");
		

	
		getContentPane().add(new Checkbox());
		getContentPane().setVisible(true);
		return lngGrp;


	}
	public void itemStateChanged(ItemEvent ie) {
		//  repaint();
	}
	public static void main(String[] args) throws Exception  {

		new Test();
		

	}

}



