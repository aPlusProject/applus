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

	//If the simulator is a client of the bank, by his client number, 
	//the employee can have all his information like.
	
	public Client getClientByID(int idClient) throws ClassNotFoundException, SQLException {
		
		System.out.println("id du client in getClientByID : "+idClient);
		
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
		
		System.out.println("traiment done");
		
		conn.closeConnection(co);
		return this.cl;
		
	}
	
	//Calculate installment having interest rate
	public double calculateInstallment(String creditType, int amount, int duration, double rate){
		
			//calculate installment
			double rateFloat = (rate/100);
			double rateMonth = (rateFloat/12);
			double f = (1 - Math.pow((1+rateMonth), -duration*12));
			double installment = (amount*rateMonth) / f;
			return Math.round(installment);
	}	
	
	//Calculate installment having interest rate and insurance rate
	public double calculateFinalInstallment(String creditType, int amount, int duration, double rate, double rateInsurance){
		
		//calculate installment
		double rateFloat = (rate/100);
		double rateInsuranceFloat = (rateInsurance/100);
		double rateMonth = ((rateFloat + rateInsuranceFloat)/12);
		double f = (1 - Math.pow((1+rateMonth), -duration*12));
		double installment = (amount*rateMonth) / f;
		return Math.round(installment);
	}
	
	//According to the information filled for the simulation, employee can save this simulation as a loan on the DB.
	public void addLoan(int idClient, int idConseiller, int idLoanType, int idHistory, int askedAmount, 
			int askedDuration, double askedRate, double askedRateInsurance) throws ClassNotFoundException, SQLException{
		
		System.out.println("Add loan begin");
		
		ConnectionPool conn = employe.getPool();
		Connection co;
		conn = new ConnectionPool();
		conn.makeStack();
		co = conn.getConnection();
		
		System.out.println("Connect�");
		
		PreparedStatement ps;
		ResultSet rs;
		String sql;		
		
		sql = "INSERT INTO LOAN (id_loan, id_client, id_conseiller, id_loan_type, "
				+ "id_history, asked_amount, asked_duration, asked_rate, asked_rateInsurance, asked_date, decision) "
				+ "VALUES ('',"+idClient+","+idConseiller+","+idLoanType+",null,"+askedAmount+","+askedDuration+","
						+ ""+askedRate+","+askedRateInsurance+",SYSDATE,0)";
		
		
		System.out.println(sql);
		
		ps = co.prepareStatement(sql);
		rs = ps.executeQuery();
		
		System.out.println("Envoy�");
		
		co.commit();
		conn.closeConnection(co);
		
		
		
		System.out.println("Ferm�, insertion avec succees");		
	}
}