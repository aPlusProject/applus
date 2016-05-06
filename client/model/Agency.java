package model;

public class Agency {
	
	private int id;
	private HQ hq;
	private String name;
	private String city;
	private String zipCode;
	private String telNum;
	
	
	
	public Agency(HQ hq, String name, String city, String zipCode, String telNum) {
		this.hq = hq;
		this.name = name;
		this.city = city;
		this.zipCode = zipCode;
		this.telNum = telNum;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public HQ getHQ() {
		return hq;
	}
	public void setHQ(HQ hq) {
		this.hq = hq;
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
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	
	
	

}
