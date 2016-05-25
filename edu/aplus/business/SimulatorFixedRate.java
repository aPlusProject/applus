package edu.aplus.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import edu.aplus.db.ConnectionPool;
import edu.aplus.model.Client;
import edu.aplus.model.Employee;

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
			this.cl.setFirstName(rs.getString(3));
			this.cl.setLastName(rs.getString(4));
			this.cl.setEmail(rs.getString(5));
			this.cl.setTelNum(rs.getString(6));
			this.cl.setCity(rs.getString(7));
			this.cl.setAddress(rs.getString(8));
			this.cl.setZipCode(rs.getString(9));
			this.cl.setSalary(rs.getString(11));
			this.cl.setCharge(rs.getString(12));
			this.cl.setDebtRate(rs.getString(13));
				
		}
		
		conn.closeConnection(co);
		return this.cl;
		
	}
	
public double simulate(String creditType, int amount, int duration, double rate){
		
			//calculate installment
			double rateFloat = (rate/100);
			double rateMonth = (rateFloat/12);
			double f = (1 - Math.pow((1+rateMonth), -duration*12));
			double installment = (amount*rateMonth) / f;
			//System.out.println(installment);
			return installment;
	}
		
		public static void main(String[] args){
			SimulatorFixedRate s = new SimulatorFixedRate();
			double result = s.simulate("Crédit Immobilier", 200000, 20, 4.5);
			System.out.println(result);
		}
		
}