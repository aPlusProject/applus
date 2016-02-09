package model;

import java.util.ArrayList;

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

	@Override
	public int simulate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", id_agency=" + id_agency + ", agency="
				+ agency + ", lastName=" + lastName + ", firstName="
				+ firstName + ", email=" + email + ", telNum=" + telNum
				+ ", password=" + password + ", clients=" + clients
				+ ", rates=" + rates + "]";
	}


	

	
	
	
	
}
