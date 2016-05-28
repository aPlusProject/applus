package edu.aplus.tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import edu.aplus.db.ConnectionPool;
import edu.aplus.model.Loan;

public class LoanTest {

	@Test
	public void testGetLoansListForArrayIndicatorSize() throws ClassNotFoundException, SQLException {
		
		System.out.println("testGetLoansListForArrayIndicatorSize()");
		
		Loan instance = new Loan();
		
		ArrayList<Loan> list = instance.getLoansListForArrayIndicator();
		
		int size = 0;
		
		ConnectionPool pool = new ConnectionPool();
		pool.makeStack();
		Connection co = pool.getConnection();
		
		
		PreparedStatement ps;
		ResultSet rs;

		
		String sql = "SELECT COUNT(*) FROM LOAN";
		ps = co.prepareStatement(sql);
		rs = ps.executeQuery();
		
		
		rs = ps.executeQuery();
		while(rs.next()) {
			size = rs.getInt(1);
		}
		System.out.println("number of row in table LOAN : "+size);
		
		assertTrue(size == list.size());
		
		
	}

}
