package edu.aplus.client.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.sql.DataSource;

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
		
		System.out.println("ok1");
	      DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	      System.out.println("ok2");
	      
	      ChartsIndicator instance = new ChartsIndicator();
	      System.out.println("ok3");
	      
	      ArrayList<Integer> list = instance.getLoanAmountForEachYear();
	      
	      int valueToIncrement = 0;
	      for(int i=0; i<list.size(); i++) {
	    	  
	    	  System.out.println("Année "+(2000+i)+" demande :"+(list.get(i)+valueToIncrement));
	    	  
	    	  dataset.addValue((list.get(i)+valueToIncrement), "Evolution des demandes", (2000+i)+"");
	    	  valueToIncrement = valueToIncrement + list.get(i);
	      }
	      
	      return dataset;
	   }
	

}
