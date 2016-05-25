package edu.aplus.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import edu.aplus.db.ConnectionPool;
import edu.aplus.model.Client;
import edu.aplus.model.Employee;
import edu.aplus.model.Loan;

public class SimulatorFixedRate {
	
	Client cl = null;
	Employee employe = new Employee();

	public Client getClientByID(int idClient) throws ClassNotFoundException, SQLException {
		
		ConnectionPool conn = employe.getPool();
		Connection co= null;
		conn = new ConnectionPool();
		conn.makeStack();
		co = conn.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		String sql = null;		
		
		sql = "SELECT * FROM CLIENT WHERE ID_CLIENT = ?";
		
		ps = co.prepareStatement(sql);
		ps.setInt(1, idClient);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			
			this.cl = new Client();
			this.cl.setIdClient(rs.getInt(1));
			this.cl.setFirstName(rs.getString(4));
			this.cl.setLastName(rs.getString(5));
			this.cl.setEmail(rs.getString(6));
			this.cl.setTelNum(rs.getString(7));
			this.cl.setCity(rs.getString(8));
			this.cl.setAddress(rs.getString(9));
			this.cl.setZipCode(rs.getString(10));
			this.cl.setSalary(rs.getString(11));
			this.cl.setCharge(rs.getString(12));
			this.cl.setDebtRate(rs.getString(13));
				
		}
		
		conn.closeConnection(co);
		return this.cl;
		
	}
	
	public double calculateInstallment(String creditType, int amount, int duration, double rate){
		
			//calculate installment
			double rateFloat = (rate/100);
			double rateMonth = (rateFloat/12);
			double f = (1 - Math.pow((1+rateMonth), -duration*12));
			double installment = (amount*rateMonth) / f;
			return installment;
	}	
	
	public double calculateFinalInstallment(String creditType, int amount, int duration, double rate, double rateInsurance){
		
		//calculate installment
		double rateFloat = (rate/100);
		double rateInsuranceFloat = rateInsurance/100;
		double rateMonth = ((rateFloat + rateInsuranceFloat)/12);
		double f = (1 - Math.pow((1+rateMonth), -duration*12));
		double installment = (amount*rateMonth) / f;
		return installment;
	}
	
	public void addLoan(int idClient, int idConseiller, int idLoanType, int idHistory, int askedAmount, 
			int askedDuration, double askedRate, double askedRateInsurance) throws ClassNotFoundException, SQLException{
		
		ConnectionPool conn = employe.getPool();
		Connection co;
		conn = new ConnectionPool();
		conn.makeStack();
		co = conn.getConnection();
		//System.out.println("Connecté");
		PreparedStatement ps;
		ResultSet rs;
		String sql;		
		
		sql = "INSERT INTO LOAN (id_loan, id_client, id_conseiller, id_loan_type, "
				+ "id_history, asked_amount, asked_duration, asked_rate, asked_rateInsurance, asked_date, decision) "
				+ "VALUES (4,"+idClient+","+idConseiller+","+idLoanType+","+idHistory+","+askedAmount+","+askedDuration+","+askedRate+","+askedRateInsurance+",SYSDATE,0)";
		
		ps = co.prepareStatement(sql);
		rs = ps.executeQuery();
		//System.out.println("Envoyé");
		co.commit();
		conn.closeConnection(co);
		//System.out.println("Fermé");
		
	}
}