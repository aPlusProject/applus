package model;

public class Rate {
	
	private int id;
	private int value;
	private String name;
	
	
	public int getId() {
		return id;
	}
	
	/*
	 * get the value (in euro*100)
	 */
	public int getValue() {
		return value;
	}
	
	/*
	 * return the value of the n rate
	 */
	public int getValue(String n) {
		return 0;
	}
	
	/*
	 * get the name of the rate
	 */
	public String getName() {
		return name;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	

}
