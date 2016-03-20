package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import applus.DBConnector;

public class Employee extends Someone {
	
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
	

	public Agency getAgency() {
		return agency;
	}



	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	
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
		ResultSet rs;
		String sql = "INSERT INTO LOAN VALUES ('',1,1,1,null,"+amountAsked+",SYSDATE,0)";
		System.out.println(sql);
		ps = co.prepareStatement(sql);
		rs = ps.executeQuery();
		System.out.println("query executed.");
		co.commit();
		
	}
	
	public ArrayList<Client> seeClients() throws ClassNotFoundException, SQLException {
		DataSource ds = DBConnector.createDataSource();
		co = ds.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		String sql = "SELECT * FROM CLIENT";
		ps = co.prepareStatement(sql);
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
		return this.clients;
	}
	
	public ArrayList<Client> seeClients(int idEmployee) throws ClassNotFoundException, SQLException {
		DataSource ds = DBConnector.createDataSource();
		co = ds.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		String sql = "SELECT * FROM CLIENT WHERE ID_EMPLOYEE = ?";
		ps = co.prepareStatement(sql);
		ps.setInt(1, idEmployee);
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
		return this.clients;
	}



	
	
	
	
}
