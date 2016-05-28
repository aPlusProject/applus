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
    }*/
    
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
