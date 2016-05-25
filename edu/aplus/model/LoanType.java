

package edu.aplus.model;

import edu.aplus.db.ConnectionPool;

public class LoanType {
	
	private int id;
	private String name;
	private ConnectionPool pool;

	public LoanType(){
		
	}
	
	public LoanType(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return this.name;
	}
	
	public String getLoanType(){
		return this.getLoanType();
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setLoanType(String name){
		this.name = name;
	}
	public ConnectionPool getPool() {
		return this.pool;
	}

}
