package edu.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class DBConnector {
	
	public static DataSource createDataSource() throws SQLException, ClassNotFoundException {
		Properties props = new Properties();
		FileInputStream file = null;
		OracleDataSource ds = null;
		try {
			file = new FileInputStream("lib/db.properties");
			props.load(file);
			
			//Class.forName(props.getProperty("DB_DRIVER_CLASS"));
			
			ds = new OracleDataSource();
			ds.setDriverType(props.getProperty("DB_DRIVER_CLASS"));
			ds.setURL(props.getProperty("DB_URL"));
			ds.setUser(props.getProperty("DB_USERNAME"));
			ds.setPassword(props.getProperty("DB_PASSWORD"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ds;
		
	}
	
	/*public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		DataSource ds = DBConnector.getConnection();
		Connection co = ds.getConnection();
		
		if (co != null) {
			System.out.println("connecté à la db");
		}
		else {
			System.out.println("failed to connect");
		}
		
		
	}*/

}
