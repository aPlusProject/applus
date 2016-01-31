package applus;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Properties props = new Properties();
		FileInputStream file = null;
		Connection co = null;
		try {
			file = new FileInputStream("lib/db.properties");
			props.load(file);
			
			Class.forName(props.getProperty("DB_DRIVER_CLASS"));
			
			co = DriverManager.getConnection(
					props.getProperty("DB_URL"),
					props.getProperty("DB_USERNAME"),
					props.getProperty("DB_PASSWORD"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return co;
		
	}

}
