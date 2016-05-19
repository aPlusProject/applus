package edu.aplus.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
				
		}
		
		conn.closeConnection(co);
		return this.cl;
		
	}
		
}
