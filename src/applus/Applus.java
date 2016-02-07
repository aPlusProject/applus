/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import IHM.Connection_menu;


/**
 * 
 * @author
 */
public class Applus {
	
	private static Connection co;
	private static PreparedStatement ps;
	private static Statement stmt;
	private static ResultSet rs;
	private static String query;
	
	/**
	 * @param args
	 * the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here

		Connection_menu main_menu = new Connection_menu();
		main_menu.setVisible(true);
		
		try {
			co = DBConnector.getConnection();
			ps = co.prepareStatement(main_menu.get_connect_query());
			ResultSet s = ps.executeQuery();
			System.out.println(s);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}
