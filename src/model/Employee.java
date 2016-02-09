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
	private int id_agency;
	private Agency agency;
	private String lastName;
	private String firstName;
	private String email;
	private String telNum;
	private String password;
	
	
	private ArrayList<Client> clients;
	private ArrayList<Rate> rates;
	
	

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
		this.id_agency = id_agency;
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
	
	
	public ArrayList<Client> getClients() {
		return this.clients;
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

	/*public static void main(String[] args) throws ClassNotFoundException, SQLException { 
		DataSource ds = DBConnector.createDataSource();
		Connection co = ds.getConnection();
		
		simulate(100000,co);
		
	}*/



	
	
	
	
}
