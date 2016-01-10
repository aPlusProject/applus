/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applus;

import java.sql.*;

/**
 * 
 * @author
 */
public class Applus {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		try {
			//load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//create the connection object
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "vyach", "vyach");

			//create the statement object
			Statement stmt = con.createStatement();
			System.out.println("Connected");
			//execute query
			//ResultSet rs = stmt.executeQuery("select * from emp");
			//while (rs.next())
			//	System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  "
			//			+ rs.getString(3));

			//close the connection object
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
