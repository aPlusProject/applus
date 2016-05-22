package edu.aplus.tests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.junit.AfterClass;
import org.junit.Test;

import junit.framework.TestCase;
import edu.aplus.db.DBConnector;
import edu.aplus.model.Client;
import edu.aplus.model.Employee;
import edu.aplus.model.Loan;

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
	}
	
	@Test
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
    }
    
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
		        }
		        
		        Employee employee = new Employee();
                int expected = 1;
                System.out.println(employee.getAllClients(false, 1).size());
                int numberOfClients = employee.getAllClients(false, 1).size();
                
                assertEquals(expected, numberOfClients);
                co.close();
    }
    
    @Test
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
    }
    
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
    }*/
    
    
    @Test
    public void testGetLoanAmount() throws ClassNotFoundException, SQLException {
    	System.out.println("testGetLoanAmount");
    	
    	Employee responsable = new Employee();
    	responsable.setResponsable(1);
    	
    	int idAgence = 1;
    	
    	ArrayList<Loan> loanList = responsable.getAllLoans(idAgence);
    	int sizeLoan = 0;
    	
    	DataSource ds = DBConnector.createDataSource();
        Connection co = ds.getConnection();
        
        String sql = "SELECT COUNT(*) FROM LOAN l, EMPLOYEE e WHERE l.ID_CONSEILLER = e.ID_EMPLOYEE AND e.ID_AGENCY = ?";
        
        PreparedStatement ps = co.prepareStatement(sql);
        ps.setInt(1, idAgence);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) { 
        	sizeLoan = rs.getInt(1);
        }
    	
    	assertTrue(loanList.size() == sizeLoan);
    }
    
    @Test
    public void testNotResponsableGetAllLoan() throws ClassNotFoundException, SQLException {
    	System.out.println("testNotResponsableGetAllLoan");
    	Employee employee = new Employee();
    	String message = "";
    	try {
    		employee.getAllLoans(1);
    	}
    	catch(IllegalArgumentException e) {
    		message = e.getMessage();
    	}
    	
    	assertTrue(message == "This employee is not a responsable");
    	
    }
    
    /**
     * 
     * @throws ClassNotFoundException
     * 
     * test if the method throw an exception if we call it with an unknow idAgency
     * 
     */
    @Test
    public void testGetAverageOfLoansOfUnknowAgency() throws ClassNotFoundException {
    	System.out.println("testGetAverageOfLoansOfUnknowAgency");
    	Employee responsable = new Employee();
    	responsable.setResponsable(1);
    	
    	int CODE_ERREUR = 933;
    	
    	int errorCode = 0;
    	try {
    		responsable.getAverageOfLoans(999, 1, 0);
    	}
    	catch(SQLException e) {
    		errorCode = e.getErrorCode();
    	}
    	
    	assertTrue(CODE_ERREUR == errorCode);
    	
    }
    
    /**
     * 
     * @throws ClassNotFoundException
     * @throws SQLException
     * 
     * test if the method throw an exception if the employee is not a responsable
     * 
     */
    @Test
    public void testNotResponsableGetAverageOfLoans() throws ClassNotFoundException, SQLException {
    	System.out.println("testNotResponsableGetAverageOfLoans");
    	
    	Employee employee = new Employee();
    	
    	String message = "";
    	try {
    		employee.getAverageOfLoans(1, 1, 1);
    	}
    	catch(IllegalArgumentException e) {
    		message = e.getMessage();
    	}
    	
    	assertTrue(message == "This employee is not a responsable");
    	
    }
    
    
    @Test
    public void testGetAverageOfAllLoans() throws ClassNotFoundException, SQLException {
    	Employee instance = new Employee();
    	instance.setResponsable(1);
    	
    	DataSource ds = DBConnector.createDataSource();
        Connection co = ds.getConnection();
        
        int average = 0;
        int idAgence = 1;
        String sql = "SELECT AVG(l.ASKED_AMOUNT) FROM LOAN l, EMPLOYEE e WHERE e.ID_EMPLOYEE = l.ID_CONSEILLER AND e.ID_AGENCY = ?";
        
        PreparedStatement ps = co.prepareStatement(sql);
        ps.setInt(1, idAgence);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) { 
        	average = rs.getInt(1);
        }
        
        int averageFromMethod;
        averageFromMethod = instance.getAverageOfLoans(1, 0, 0);
        
        assertTrue(average == averageFromMethod);
    	
    }
    
    

}