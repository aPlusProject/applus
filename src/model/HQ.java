package model;

public class HQ {
	
	private int id;
	private String name;
	private String city;
	private String zipCode;
	private String address;
	
	
	public HQ(String name, String city, String zipCode, String address) {
		this.name = name;
		this.city = city;
		this.zipCode = zipCode;
		this.address = address;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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
	
	
	

}
