package model;

public class Client extends Someone{
	
	private int id;
	private Employee employee;
	private String lastName;
	private String firstName;
	private String email;
	private String telNum;
	private String city;
	private String address;
	private String zipCode;
	
	
	public Client(Employee employee, String lastName, String firstName, String email, String telNum, String city, String adrdess,
			String zipCode) {
		this.employee = employee;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.telNum = telNum;
		this.city = city;
		this.address = adrdess;
		this.zipCode = zipCode;
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
