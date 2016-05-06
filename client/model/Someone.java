package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class Someone implements Serializable{
	
	public abstract int getID();
	public abstract String getLastName();
	public abstract String getFirstName();
	public abstract String getEmail();
	public abstract String getTelNum();
	
	//public abstract void simulate(int amountAsked, Connection co) throws SQLException;

}
