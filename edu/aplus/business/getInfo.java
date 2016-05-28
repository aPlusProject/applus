package edu.aplus.business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class getInfo {
	
	public static int asked_amount(int id_loan){
//		Connection2 b = new Connection2();
//	      Connection vCon = b.connection();
//	      String requete = "SELECT * FROM LOAN WHERE ID_LOAN="+id_loan;
//	      try {
//				Statement vSt = vCon.createStatement();
//				ResultSet vRs = vSt.executeQuery(requete);
//
//				
//				while(vRs.next()){
//					int Amount = vRs.getInt("ASKED_AMOUNT");
//					return Amount;
//					}
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		return 0;
		}
	public static int asked_duration(int id_loan){
//		//Connection2 b = new Connection2();
//	      Connection vCon = b.connection();
//	      String requete = "SELECT * FROM LOAN WHERE ID_LOAN="+id_loan;
//	      try {
//				Statement vSt = vCon.createStatement();
//				ResultSet vRs = vSt.executeQuery(requete);
//
//				
//				while(vRs.next()){
//					int Amount = vRs.getInt("ASKED_DURATION");
//					return Amount;
//					}
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		return 0;
	}
	public static String decision(int id_loan){
//		//Connection2 b = new Connection2();
//	      Connection vCon = b.connection();
//	      String requete = "SELECT * FROM LOAN WHERE ID_LOAN="+id_loan;
//	      try {
//				Statement vSt = vCon.createStatement();
//				ResultSet vRs = vSt.executeQuery(requete);
//
//				
//				while(vRs.next()){
//					int Amount = vRs.getInt("DECISION");
//					if (Amount == 1)
//						return "Accepté";
//					else
//						return "Refusé";
//					}
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		return "";
	}
}