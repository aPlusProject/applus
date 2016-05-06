package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

//import applus.DBConnector;
//import applus.PoolConnection;

public class Employee extends Someone implements Serializable{
	
	//private PoolConnection pool;
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Agency agency;
	private String lastName;
	private String firstName;
	private String email;
	private String telNum;
	private String password;
	private Connection co;
	
	
	private ArrayList<Client> clients;
	private ArrayList<Rate> rates;
	private Client cl;
	
	

	public Employee(Agency agency, String lastName, String firstName, String email, String telNum) {
		this.agency = agency;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.telNum = telNum;
		
		this.clients = new ArrayList<Client>();
		this.rates = new ArrayList<Rate>();
	}
	
	public Employee(){
		
	}
	
	public Employee(int id_agency, String firstName, String lastName, String email, String telNum){
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.telNum = telNum;
		
		this.clients = new ArrayList<Client>();
		this.rates = new ArrayList<Rate>();
	}
	
	
	public ArrayList<Rate> getRates() {
		return this.rates;
	}
	
	
	public void addClient(Client c) {
		this.clients.add(c);
	}
	

	/*public Agency getAgency() {
		return agency;
	}*/



	/*public void setAgency(Agency agency) {
		this.agency = agency;
	}*/
	
	public void login(String email, String password) {
		
	}



	@Override
	public int getID() {
		return this.id;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public String getFirstName() {
		return this.firstName;
	}
	
	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public String getTelNum() {
		return this.telNum;
	}

	
	public static void simulate(int amountAsked, Connection co) throws SQLException {
		//INSERT INTO LOAN VALUES ('',1,1,1,null,10000,SYSDATE,0);
		System.out.println("Enregistrement de la simulation...");
		PreparedStatement ps;
		String sql = "INSERT INTO LOAN VALUES ('',1,1,1,null,"+amountAsked+",SYSDATE,0)";
		System.out.println(sql);
		ps = co.prepareStatement(sql);
		ps.executeQuery();
		co.commit();
		
	}
	
	public void setAllClients(ArrayList<Client> array) {
		this.clients = array;
	}
	
	public ArrayList<Client> getAllClients() {
		return this.clients;
	}
	
	/**
	 * Allow to get all Clients (there is a double fonctionnality) : <br/><br/>
	 * 
	 * isAgencyResponsable = true <br/> so idAgencyOrEmployee = Agency id <br/>
	 * => The method will return all the clients belonging to the agency id called <br/><br/>
	 * 
	 * isAgencyResponsable = false <br/> so idAgencyOrEmployee = Employee id <br/>
	 * => The method will return all the clients belonging to the Employee id called
	 * 
	 */
	public ArrayList<Client> getAllClients(boolean isAgencyResponsable, int idAgencyOrEmployee) throws ClassNotFoundException, SQLException {
		/*this.pool = new PoolConnection();
		this.pool.makeStack();
		co = this.pool.getConnection();
		
		PreparedStatement ps;
		ResultSet rs;
		
		String sql = null;				
		if(isAgencyResponsable) {
			sql = "SELECT * FROM CLIENT c, EMPLOYEE e "
					+ "WHERE c.ID_EMPLOYEE = e.ID_EMPLOYEE"
					+ " AND e.ID_AGENCY = ?";
		}
		else {
			sql = "SELECT * FROM CLIENT WHERE ID_EMPLOYEE = ?";
		}
		
		ps = co.prepareStatement(sql);
		ps.setInt(1, idAgencyOrEmployee);
		rs = ps.executeQuery();
		this.clients = new ArrayList<Client>();
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
			this.clients.add(cl);
			
			
		}
		this.pool.closeConnection(co);*/
		return this.clients;
	}
	
	/*public void insertNewClient(int idEmployee, String clientFirstname, String clientLastname, String email, String num, String ville, String adresse, String code) throws ClassNotFoundException, SQLException {
		
		this.pool = new PoolConnection();
		this.pool.makeStack();
		co = this.pool.getConnection();
		
		PreparedStatement ps;
		
		String sql = null;	
			sql = "INSERT INTO CLIENT VALUES ('',?,?,?,?,?,?,?,?)";
			
		ps = co.prepareStatement(sql);
		ps.setInt(1, idEmployee);
		ps.setString(2, clientFirstname);
		ps.setString(3, clientLastname);
		ps.setString(4, email);
		ps.setString(5, num);
		ps.setString(6, ville);
		ps.setString(7, adresse);
		ps.setString(8, code);
		
		ps.executeQuery();
		System.out.println("new client insered");
		this.pool.closeConnection(co);
		
	}
	
	public void updateAClient(int idClient,String clientFirstname, String clientLastname, String email, String num, String ville, String adress, String code) throws ClassNotFoundException, SQLException {
		this.pool = new PoolConnection();
		this.pool.makeStack();
		co = this.pool.getConnection();
		
		PreparedStatement ps;
		
		String sql = null;	
			sql = "UPDATE CLIENT SET CLIENT_FIRST_NAME=?,"+
					"CLIENT_LAST_NAME=?,"+
					"CLIENT_EMAIL=?,"+
					"TEL_NUM=?,"+
					"CLIENT_CITY=?,"+
					"ADDRESS=?,"+
					"ZIP_CODE=?"+
					"WHERE ID_CLIENT=?";
			
		ps = co.prepareStatement(sql);
		ps.setString(1, clientFirstname);
		ps.setString(2, clientLastname);
		ps.setString(3, email);
		ps.setString(4, num);
		ps.setString(5, ville);
		ps.setString(6, adress);
		ps.setString(7, code);
		ps.setInt(8, idClient);
		
		ps.executeQuery();
		System.out.println("Client updated");
	}
	
	public void deleteAClient(int idClient) throws SQLException, ClassNotFoundException {
		
		this.pool = new PoolConnection();
		this.pool.makeStack();
		co = this.pool.getConnection();
		
		PreparedStatement ps;
		
		String sql = null;	
			sql = "DELETE FROM CLIENT WHERE ID_CLIENT=?";
			
		ps = co.prepareStatement(sql);
		ps.setInt(1, idClient);
		ps.executeUpdate();
		
		System.out.println("client deleted");
	}*/
	
	
	
}
