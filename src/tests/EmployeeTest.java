package tests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import applus.DBConnector;
import junit.framework.TestCase;
import model.Client;
import model.Employee;

public class EmployeeTest extends TestCase{
	
	private Employee employee;
	
	/*@Test
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
	}*/
	
	/*@BeforeClass
    public void tearDownBefore() throws SQLException, ClassNotFoundException {
		
				
        		this.employee = new Employee();
                System.out.println("Beginning of the ClientTest");
                System.out.println("Clear all tables before the ClientTest");
                DataSource ds = DBConnector.createDataSource();
		        Connection co = ds.getConnection();
                String sql1 = "DELETE * FROM CLIENT";
                String sql2 = "DELETE * FROM EMPLOYE";
                PreparedStatement ps1 = co.prepareStatement(sql1);
                PreparedStatement ps2 = co.prepareStatement(sql2);
		        ResultSet rs1 = ps1.executeQuery();
                ResultSet rs2 = ps2.executeQuery(); 
                co.close();
    }*/
    
    @Test
    public void testSeeClientsEmpty() throws ClassNotFoundException, SQLException {
                
                System.out.println("When the data base is empty");
		        ArrayList<Client> expected = null;
                ArrayList<Client> clientsOfFirstAgency = this.employee.getAllClients(true, 1);
                assertTrue(expected == clientsOfFirstAgency);
    } 
    
    @Test
    public void testSeeClientsOfEmployee() throws ClassNotFoundException, SQLException {
                
    	
		    	System.out.println("Beginning of the ClientTest");
		        System.out.println("Clear all tables before the ClientTest");
		        DataSource ds = DBConnector.createDataSource();
		        Connection co = ds.getConnection();
		        String sql1 = "DELETE * FROM CLIENT";
		        String sql2 = "DELETE * FROM EMPLOYE";
		        PreparedStatement ps1 = co.prepareStatement(sql1);
		        PreparedStatement ps2 = co.prepareStatement(sql2);
		        ResultSet rs1 = ps1.executeQuery();
		        ResultSet rs2 = ps2.executeQuery(); 
		        
        
                System.out.println("When Employee number 1 has only one client");
                DataSource ds2 = DBConnector.createDataSource();
		        Connection co2 = ds.getConnection();
                String sql = "INSERT INTO CLIENT VALUES ('', 1, 'John', 'Dupont', 'john.dupont@gmail.com', 0611111111, 'Paris', '75', 'rue de Paris')";
		        PreparedStatement ps21 = co.prepareStatement(sql);
		        ResultSet rs = ps21.executeQuery();
		        
		        /*String sql2 = "SELECT * FROM EMPLOYEE";
		        PreparedStatement ps2 = co.prepareStatement(sql2);
		        ResultSet rs2 = ps2.executeQuery();
		        while (rs2.next()) {
		        	System.out.println(rs2.getString(1));
		        }*/
		        
		        Employee employee = new Employee();
                int expected = 1;
                System.out.println(employee.getAllClients(false, 1).size());
                int numberOfClients = employee.getAllClients(false, 1).size();
                
                assertEquals(expected, numberOfClients);
                co.close();
    }
    
    /*@Test
    public void testSeeClientsOfAgency() throws ClassNotFoundException, SQLException {
    
                System.out.println("When Agency number 1 has one client");
                DataSource ds = DBConnector.createDataSource();
		        Connection co = ds.getConnection();
                String sql = "INSERT INTO Employee VALUES ('', 1, 'Josh', 'Dumast', 'josh.dumast@gmail.com', 0622222222, 'Nice', '75', 'rue de Nice')";
                PreparedStatement ps = co.prepareStatement(sql);
		        ResultSet rs = ps.executeQuery();
                
                int expected = 1;
                int numberOfClients = this.employee.getAllClients(true, 1).size();
                assertEquals(expected, numberOfClients);
                co.close();
    }*/
    
    @AfterClass
    public void tearDown() throws SQLException, ClassNotFoundException {
        
                System.out.println("End of the ClientTest");
                System.out.println("Clear all tables after the ClientTest");
                DataSource ds = DBConnector.createDataSource();
		        Connection co = ds.getConnection();
                String sql1 = "DELETE * FROM CLIENT";
                String sql2 = "DELETE * FROM EMPLOYE";
                PreparedStatement ps1 = co.prepareStatement(sql1);
                PreparedStatement ps2 = co.prepareStatement(sql2);
		        ResultSet rs1 = ps1.executeQuery();
                ResultSet rs2 = ps2.executeQuery(); 
                co.close();
    }

}
