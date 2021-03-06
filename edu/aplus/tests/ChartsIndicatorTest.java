package edu.aplus.tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

import edu.aplus.client.panel.ChartsIndicatorFrame;
import edu.aplus.db.DBConnector;
import edu.aplus.service.ChartsIndicatorExpose;

public class ChartsIndicatorTest {

	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 * test the number of loans in 2016
	 * 
	 */
	@Test
	public void testGetAmountOfLoansByYears() throws ClassNotFoundException, SQLException {

		System.out.println("testGetAmountOfLoansByYears");
		
		ChartsIndicatorExpose instance = new ChartsIndicatorExpose();
		
		int loansNbIn = instance.getLoanAmountInAYear(2011);
		
		int loansNbFromSQL = 0;
		
		DataSource ds = DBConnector.createDataSource();
        Connection co = ds.getConnection();
        
        String sql = "SELECT COUNT(*) FROM LOAN WHERE "
				+ "EXTRACT (YEAR FROM ASKED_DATE) = ?";
        
        PreparedStatement ps = co.prepareStatement(sql);
        ps.setInt(1, 2011);
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()) { 
        	loansNbFromSQL = rs.getInt(1);
        }
        
        System.out.println("Nombre de pr�t depuis req sql : "+loansNbFromSQL);
        System.out.println("Nombre de pr�t depuis methode : "+loansNbIn);

		
		
		assertTrue(loansNbIn == loansNbFromSQL);
		
		
	}
	
	@Test
	public void testGetAmountOfMonthInAYear() throws ClassNotFoundException, SQLException {
		
		ChartsIndicatorExpose instance = new ChartsIndicatorExpose();
		
		assertTrue(instance.getAmountOfLoansByMonth(2014).size() == 12);
		
	}
	
	@Test
	public void testGetAmontOfYearSince2000() throws ClassNotFoundException, SQLException {
		
		System.out.println("testGetAmontOfYearSince2000");
		
		ChartsIndicatorExpose instance = new ChartsIndicatorExpose();
		
		
		//17 complete years since 2000
		assertTrue(instance.getLoanAmountForEachYear().size() == 17);
		
	}

}
