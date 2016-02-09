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

import IHM.MainPanel;


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

		MainPanel main_menu = new MainPanel();
		main_menu.setVisible(true);
		
		
	}
	

}
