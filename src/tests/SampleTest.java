package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
import model.Client;
import model.Employee;


public class SampleTest {
    
    @BeforeClass
    public static void tearDown1() throws SQLException, ClassNotFoundException {
        
                Employee employee = new Employee();        
                System.out.println("Beginning of the ClientTest");
                System.out.println("Clear all tables before the ClientTest");
                DataSource ds = DBConnector.createDataSource();
		        Connection co = ds.getConnection();
                String sql1 = "DELETE * FROM CLIENT";
                String sql2 = "DELETE * FROM EMPLOYEE";
                PreparedStatement ps1 = co.prepareStatement(sql1);
                PreparedStatement ps2 = co.prepareStatement(sql2);
		        ps1.executeQuery();
                ps2.executeQuery(); 
                co.close();
    }
    
    @Test
    public void testSeeClientsEmpty() throws ClassNotFoundException, SQLException {
                
                Employee employee = new Employee();         
                System.out.println("When the data base is empty");
		        ArrayList<Client> expected = null;
                ArrayList<Client> clientsOfFirstAgency = employee.getAllClients(true, 1);
                assertTrue(expected == clientsOfFirstAgency);
    } 
    
    @Test
    public void testSeeClientsOfEmployee() throws ClassNotFoundException, SQLException {
                
                System.out.println("When Employee number 1 has only one client");
                DataSource ds = DBConnector.createDataSource();
		        Connection co = ds.getConnection();
                String sql = "INSERT INTO CLIENT VALUES ('', 1, 'John', 'Dupont', 'john.dupont@gmail.com', 0611111111, 'Paris', '75', 'rue de Paris')";
		        PreparedStatement ps = co.prepareStatement(sql);
		        ResultSet rs = ps.executeQuery();
		
                Employee employee = new Employee();        
                int expected = 1;
                int numberOfClients = employee.getAllClients(false, 1).size();
                assertEquals(expected, numberOfClients);
                co.close();
    }
    
    @Test
    public void testSeeClientsOfAgency() throws ClassNotFoundException, SQLException {
    
                System.out.println("When Agency number 1 has one client");
                DataSource ds = DBConnector.createDataSource();
		        Connection co = ds.getConnection();
                String sql = "INSERT INTO EMPLOYEE VALUES ('', 1, 'Josh', 'Dumast', 'josh.dumast@gmail.com', 0622222222, 'Nice', '75', 'rue de Nice')";
                PreparedStatement ps = co.prepareStatement(sql);
		        ResultSet rs = ps.executeQuery();
                
                Employee employee = new Employee();        
                int expected = 1;
                int numberOfClients = employee.getAllClients(true, 1).size();
                assertEquals(expected, numberOfClients);
                co.close();
    }
    
    @AfterClass
    public static void tearDown() throws SQLException, ClassNotFoundException {
        
                System.out.println("End of the ClientTest");
                System.out.println("Clear all tables after the ClientTest");
                DataSource ds = DBConnector.createDataSource();
		        Connection co = ds.getConnection();
                String sql1 = "DELETE * FROM CLIENT";
                String sql2 = "DELETE * FROM EMPLOYEE";
                PreparedStatement ps1 = co.prepareStatement(sql1);
                PreparedStatement ps2 = co.prepareStatement(sql2);
		        boolean rs1 = ps1.execute();
                boolean rs2 = ps2.execute(); 
                co.close();
    }
}