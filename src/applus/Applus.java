/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import IHM.LoginPanel;


/**
 * 
 * @author
 */
public class Applus {
	
	/**
	 * @param args
	 * the command line arguments
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO code application logic here

		LoginPanel main_menu = new LoginPanel();
		main_menu.setVisible(true);
		
		
	}
	

}
