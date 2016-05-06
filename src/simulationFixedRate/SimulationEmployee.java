package simulationFixedRate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import applus.model.Employee;
import applus.model.Client;
import applus.PoolConnection;

public class SimulationEmployee {
	
	Client cl = null;
	
	Employee simulationEmployee = new Employee();

	public ArrayList<Client> getClientByID(int idClient) throws ClassNotFoundException, SQLException {
		
		PoolConnection conn = simulationEmployee.getPool(); // ajouter getPool() dans model.Employee
		
		Connection co= null;
		conn = new PoolConnection();
		conn.makeStack();
		co = conn.getConnection();
		
		
		
		PreparedStatement ps;
		ResultSet rs;
		
		String sql = null;				
		
		sql = "SELECT * FROM CLIENT WHERE id = ?";
		
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
			simulationEmployee.addClient(cl);
			
			
		}
		conn.closeConnection(co);
		return simulationEmployee.getClients();
	}
	
}
