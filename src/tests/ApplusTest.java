package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import junit.framework.TestCase;

public class ApplusTest extends TestCase {
	
	@Test
	public void testGetConnexion() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//create the connection object
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "vyach", "vyach");

		//create the statement object
//		Statement stmt = con.createStatement();
		
		assertTrue(con != null );
	}

}
