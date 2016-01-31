package tests;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import applus.DBConnector;
import junit.framework.TestCase;

public class DBConnectorTest extends TestCase{
	
	@Test
	public void testGetConnexion() throws ClassNotFoundException, SQLException {
		Connection co = null;
		co = DBConnector.getConnection();
		
		assertTrue(co != null);
		
		
	}

}
