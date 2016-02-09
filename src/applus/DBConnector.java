package applus;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import IHM.Connection_menu;
import oracle.jdbc.pool.OracleDataSource;

public class DBConnector {
	
	public static DataSource getConnection() throws SQLException, ClassNotFoundException {
		Properties props = new Properties();
		FileInputStream file = null;
		OracleDataSource co = null;
		try {
			file = new FileInputStream("lib/db.properties");
			props.load(file);
			
			//Class.forName(props.getProperty("DB_DRIVER_CLASS"));
			
			co = new OracleDataSource();
			co.setDriverType(props.getProperty("DB_DRIVER_CLASS"));
			co.setURL(props.getProperty("DB_URL"));
			co.setUser(props.getProperty("DB_USERNAME"));
			co.setPassword(props.getProperty("DB_PASSWORD"));
					/*DriverManager.getConnection(
					props.getProperty("DB_URL"),
					props.getProperty("DB_USERNAME"),
					props.getProperty("DB_PASSWORD"));*/
		} catch (IOException e) {
			e.printStackTrace();
		}
		return co;
		
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
