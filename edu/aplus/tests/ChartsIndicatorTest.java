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
		
		ChartsIndicatorFrame instance = new ChartsIndicatorFrame();
		
		int loansNbIn2016 = instance.getAmountOfLoansByTime(2016, 0);
		
		int loansNbIn2016FromSQL = 0;
		
		DataSource ds = DBConnector.createDataSource();
        Connection co = ds.getConnection();
        
        String sql = "SELECT COUNT(*) FROM LOAN WHERE "
				+ "EXTRACT (YEAR FROM ASKED_DATE) = ?";
        
        PreparedStatement ps = co.prepareStatement(sql);
        ps.setInt(1, 2016);
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()) { 
        	loansNbIn2016FromSQL = rs.getInt(1);
        }
        
        System.out.println("Nombre de prêt depuis req sql : "+loansNbIn2016FromSQL);
        System.out.println("Nombre de prêt depuis methode : "+loansNbIn2016);

		
		
		assertTrue(loansNbIn2016 == loansNbIn2016FromSQL);
		
		
	}

}
