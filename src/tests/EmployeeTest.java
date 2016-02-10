package tests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

import applus.DBConnector;
import junit.framework.TestCase;
import model.Employee;

public class EmployeeTest extends TestCase{
	
	@Test
	public void testSimulate() throws ClassNotFoundException, SQLException {
		DataSource ds = DBConnector.createDataSource();
		Connection co = ds.getConnection();
		
		int amountAsked = 9999;
		Employee.simulate(amountAsked, co);
		
		String sql = "SELECT * FROM LOAN";
		PreparedStatement ps = co.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int value = 0;
		while(rs.next()) {
			value = rs.getInt("asked_amount");
		}
		
		assertTrue(value == amountAsked);
	}

}
