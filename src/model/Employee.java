package model;

public class Employee extends Someone{
	
	private int id;
	private Agency agency;
	private String lastName;
	private String firstName;
	private String email;
	private String telNum;
	
	

	public Employee(Agency agency, String lastName, String firstName, String email, String telNum) {
		this.agency = agency;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.telNum = telNum;
	}
	
	

	public Agency getAgency() {
		return agency;
	}



	public void setAgency(Agency agency) {
		this.agency = agency;
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



	
	
	
	
}
