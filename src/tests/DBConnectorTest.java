package tests;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

import applus.DBConnector;
import junit.framework.TestCase;

public class DBConnectorTest extends TestCase{
	
	@Test
	public void testGetConnexion() throws ClassNotFoundException, SQLException {
		System.out.println("testGetConnexion");
		DataSource ds = null;
		Connection co = null;
		ds = DBConnector.getConnection();
		co = ds.getConnection();
		
		assertTrue(co != null);
		
		
	}

}
