/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applus;

import java.sql.*;

import Model.Client;

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
			//execute query
			//ResultSet rs = stmt.executeQuery("select * from emp");
			//while (rs.next())
			//	System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  "
			//			+ rs.getString(3));

			//close the connection object
			
			Client client = new Client();
			int mensualite = client.simuler(0, 20000, 30);
			System.out.println(mensualite);
			
			
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
