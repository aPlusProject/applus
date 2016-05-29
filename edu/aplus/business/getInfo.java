package edu.aplus.business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import edu.aplus.db.DBConnector;


public class getInfo {
	
	public static int asked_amount(int id_loan) throws ClassNotFoundException, SQLException{
		DataSource b = DBConnector.createDataSource();
	      Connection vCon = b.getConnection();
	      String requete = "SELECT * FROM LOAN WHERE ID_LOAN="+id_loan;
	      try {
				Statement vSt = vCon.createStatement();
				ResultSet vRs = vSt.executeQuery(requete);

				
				while(vRs.next()){
					int Amount = vRs.getInt("ASKED_AMOUNT");
					vCon.close();
					return Amount;
					}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	      
	      vCon.close();
		return 0;
		}
	public static int asked_duration(int id_loan) throws ClassNotFoundException, SQLException{
		DataSource b = DBConnector.createDataSource();
	      Connection vCon = b.getConnection();
	      String requete = "SELECT * FROM LOAN WHERE ID_LOAN="+id_loan;
	      try {
				Statement vSt = vCon.createStatement();
				ResultSet vRs = vSt.executeQuery(requete);

				
				while(vRs.next()){
					int Amount = vRs.getInt("ASKED_DURATION");
					vCon.close();
					return Amount;
					}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	      
	      vCon.close();
		return 0;
	}
	public static String decision(int id_loan) throws ClassNotFoundException, SQLException{
		DataSource b = DBConnector.createDataSource();
	      Connection vCon = b.getConnection();
	      String requete = "SELECT * FROM LOAN WHERE ID_LOAN="+id_loan;
	      try {
				Statement vSt = vCon.createStatement();
				ResultSet vRs = vSt.executeQuery(requete);

				
				while(vRs.next()){
					int Amount = vRs.getInt("DECISION");
					if (Amount == 1) {
						vCon.close();
						return "Accepté";
						
					}
					else if(Amount == 2) {
						vCon.close();
						return "en cours";
					}
					else {
						vCon.close();
						return "Refusé";
					}
						
						
					}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		return "";
	}
}