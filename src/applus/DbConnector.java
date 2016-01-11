package applus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnector {
	
	ResultSet rs;
    Statement stmt = null;
	
	String DRIVER = "oracle.jdbc.driver.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER_NAME = "vyach";   //VERIFIER QUE L'USER POSSEDE TOUS LES DROIT : 
	String PASSWORD = "vyach";    //SE CONNECTER EN ADMIN et faire : GRANT ALL [table] ON [user];
	private Connection co;
	
	public Connection Open() {
		
		
		
		try {
			Class.forName(DRIVER);
			co = DriverManager.getConnection(URL, USER_NAME, PASSWORD);            
			System.out.println("Succeed!");

        } catch (Exception e) {

            System.out.println("error to connect");

        }

		//create the connection object
		
		return co;
		
	}
	
	public void db_Close(Connection co) throws SQLException {
        co.close();
        return;
    }

}
