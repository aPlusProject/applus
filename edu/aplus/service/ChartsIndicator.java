package edu.aplus.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.sql.DataSource;
import javax.swing.JComboBox;

import org.jfree.data.category.DefaultCategoryDataset;

import edu.aplus.db.DBConnector;

public class ChartsIndicator {
	


	/**
	 * 
	 *  @param year > 0
	 *  
	 *  @return ArrayList<Integer> number of loans for each month
	 *  january = arraylist.get(0) and december = arraylist.get(11)
	 *  
	 */
	public ArrayList<Integer> getAmountOfLoansByMonth(int year) throws ClassNotFoundException, SQLException {
				
		ArrayList<Integer> listLoanByYear = new ArrayList<Integer>();
		for(int i = 1; i <= 12; i++) {
			
			String sql = "SELECT COUNT(*) FROM LOAN "
					+ "WHERE EXTRACT (YEAR FROM ASKED_DATE) = ? "
					+ "AND EXTRACT (MONTH FROM ASKED_DATE) = ?";
			
			DataSource ds = DBConnector.createDataSource();
	        Connection co = ds.getConnection();
	        
	        PreparedStatement ps = co.prepareStatement(sql);
	        ps.setInt(1, year);
	        ps.setInt(2, i);
	        
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) { 
	        	listLoanByYear.add(rs.getInt(1));
	        }
	        
	        System.out.println("mois no"+listLoanByYear.size()+" : "+listLoanByYear.get(i-1)+" demandes");
			
		}
			
		
		return listLoanByYear;
	}
	
	
	public int getLoanAmountInAYear(int year) throws SQLException, ClassNotFoundException {
		
		int loanAmount = 0;
		
		
		DataSource ds = DBConnector.createDataSource();
        Connection co = ds.getConnection();
        
        String sql = "SELECT COUNT(*) FROM LOAN WHERE "
				+ "EXTRACT (YEAR FROM ASKED_DATE) = ?";
        
        PreparedStatement ps = co.prepareStatement(sql);
        ps.setInt(1, year);
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()) { 
        	loanAmount = rs.getInt(1);
        }
		co.close();
		
		
		return loanAmount;
	}
	
	
	public ArrayList<Integer> getLoanAmountForEachYear() throws ClassNotFoundException, SQLException {
		
		ArrayList<Integer> listLoanEachYear = new ArrayList<Integer>();
		
		//get the current year for the the boucle
		int year = Calendar.getInstance().get(Calendar.YEAR);
		//add the amount of loan for each year until this current year
		for(int i=2000; i <= year; i++) {
			listLoanEachYear.add(this.getLoanAmountInAYear(i));
			System.out.println("année no"+listLoanEachYear.size()+" : "+listLoanEachYear.get(i-2000)+" demandes");
		}
		
		
		return listLoanEachYear;
		
	}
	
	
	public DefaultCategoryDataset createDatasetForIncrementalLine() throws ClassNotFoundException, SQLException{
		
		System.out.println("in createDatasetForIncrementalLine");
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	  
		ChartsIndicator instance = new ChartsIndicator();
	  
		ArrayList<Integer> list = instance.getLoanAmountForEachYear();
		
		
		int valueToIncrement = 0;   //need for the incremental process
		for(int i=0; i<list.size(); i++) {
		  
			System.out.println("Année "+(2000+i)+" demande :"+(list.get(i)+valueToIncrement));
			
			//creation of the dataset for the charts 
		  dataset.addValue((list.get(i)+valueToIncrement), "Evolution des demandes", (2000+i)+"");
		  valueToIncrement = valueToIncrement + list.get(i);
		  
		}
	      
	    return dataset;
	}
	
	public DefaultCategoryDataset createDatasetForBarChart(int year) throws ClassNotFoundException, SQLException {
		
		
		ArrayList<String> yearList = new ArrayList<String>();
		yearList.add("Janvier");
		yearList.add("Février");
		yearList.add("Mars");
		yearList.add("Avril");
		yearList.add("Mai");
		yearList.add("Juin");
		yearList.add("Juillet");
		yearList.add("Aout");
		yearList.add("Septemblre");
		yearList.add("Octobre");
		yearList.add("Novembre");
		yearList.add("Décembre");
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		ChartsIndicator instance = new ChartsIndicator();
		
		ArrayList<Integer> list = instance.getAmountOfLoansByMonth(year);
		
		for(int i=0; i<list.size(); i++) {
			  
			//creation of the dataset for the charts 
		  dataset.addValue((list.get(i)), "Nombre de prêts demandés par mois", yearList.get(i));  // example : amount = 8 for the month 0 = janvier 
		  
		}
		
		return dataset;
		
		
	}
	
	
	
	/**
	 * 
	 * @return  a combo list of Integer from this current year from 2000
 	 */
	public JComboBox<Integer> getListOfYear() {
		
		
		JComboBox<Integer> comboBoxYears = new JComboBox<Integer>();
		
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int firstYear = 2000;
		
		comboBoxYears.addItem(currentYear);
		while(comboBoxYears.getItemAt(comboBoxYears.getItemCount()-1) != 2000) {
			
			comboBoxYears.addItem(currentYear--);
			
			System.out.println(comboBoxYears.getItemAt(comboBoxYears.getItemCount()-1));
			
		}
		
		return comboBoxYears;
	}
	

}
