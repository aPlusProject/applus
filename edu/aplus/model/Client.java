package edu.aplus.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.aplus.model.Account;
import edu.aplus.model.Employee;
import edu.aplus.model.Loan;
import edu.aplus.model.Someone;

public class Client extends Someone{
	
	
	private int id;
	private int age;
	private Employee employee;
	private String lastName;
	private String firstName;
	private String email;
	private String telNum;
	private String city;
	private String address;
	private String zipCode;
	private String salary;
	private String charge;
	private String debtRate;
	
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
		this.age = age;
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
	public void setAge(int age){
		this.age = age;
	}
	
	public void setIdClient(int idClient) {
		this.id = idClient;
		
	
	}


	@Override
	public int getID() {
		return this.id;
	}
	public int getAge(){
		return this.age;
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

	public String getSalary(){
		return this.salary;
	}
	
	public String getCharge(){
		return this.charge;
	}
	
	public String getDebtRate(){
		return this.debtRate;
	}
	
	public void setSalary(String salary) {
		this.salary = salary;	
	}
	
	public void setCharge(String charge) {
		this.charge = charge;	
	}
	
	public void setDebtRate(String debtRate) {
		this.debtRate = debtRate;	
	}

	/*@Override
	public void simulate(int amountAsked, Connection co) throws SQLException {
		// TODO Auto-generated method stub
		
	}*/

	


	

}
