package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Client extends Someone implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Employee employee;
	private String lastName;
	private String firstName;
	private String email;
	private String telNum;
	private String city;
	private String address;
	private String zipCode;
	
	private ArrayList<Account> accounts;
	private ArrayList<Loan> loans;
	
	
	public Client() {
		
	}
	
	public Client(Employee employee, String lastName, String firstName, String email, String telNum, String city, String adrdess,
			String zipCode) {
		this.accounts = new ArrayList<Account>();
		this.loans = new ArrayList<Loan>();
		this.employee = employee;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.telNum = telNum;
		this.city = city;
		this.address = adrdess;
		this.zipCode = zipCode;
	}
	
	public void addAccount(Account a) {
		this.accounts.add(a);
	}
	
	public ArrayList<Account> getAccounts() {
		return this.accounts;
	}
	
	public Account getAccount(int i) {
		return this.accounts.get(i);
	}
	
	public void addLoan(Loan loan) {
		this.loans.add(loan);
	}
	
	public ArrayList<Loan> getLoans() {
		return this.loans;
	}
	
	public Loan getLoan(int i) {
		return this.loans.get(i);
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	
	public void setIdClient(int idClient) {
		this.id = idClient;
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

	/*@Override
	public void simulate(int amountAsked, Connection co) throws SQLException {
		// TODO Auto-generated method stub
		
	}*/

	


	

}
