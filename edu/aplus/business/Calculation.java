package edu.aplus.business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import edu.aplus.db.DBConnector;


public class Calculation {
	
	public static float totalinteret(int id_loan) throws ClassNotFoundException, SQLException{
		//Connection2 b = new Connection2();
		DataSource b = DBConnector.createDataSource();
	      Connection vCon = b.getConnection();
	      String requete = "SELECT * FROM LOAN WHERE ID_LOAN="+id_loan;
	      try {
				Statement vSt = vCon.createStatement();
				ResultSet vRs = vSt.executeQuery(requete);

				
				while(vRs.next()){
					int Amount = vRs.getInt("ASKED_AMOUNT");
					int Duration = vRs.getInt("ASKED_DURATION");
					float rate = vRs.getFloat("ASKED_RATE");
					rate = (float) rate/100;
					float rate_month=(float)(Amount * rate)/12;
					float rate_total = (float) rate_month * Duration;
					vCon.close();
					return rate_total;
					}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	     // (33500 * 8.12/100)/12
		
		return 0;
	}
	public static float totalinteretParMois(int id_loan) throws ClassNotFoundException, SQLException{
		DataSource b = DBConnector.createDataSource();
	      Connection vCon = b.getConnection();
	      String requete = "SELECT * FROM LOAN WHERE ID_LOAN="+id_loan;
	      try {
				Statement vSt = vCon.createStatement();
				ResultSet vRs = vSt.executeQuery(requete);

				
				while(vRs.next()){
					int Amount = vRs.getInt("ASKED_AMOUNT");
					float rate = vRs.getFloat("ASKED_RATE");
					rate = (float) rate/100;
					float rate_month=(float)(Amount * rate)/12;
					vCon.close();
					return rate_month;
					}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	     // (33500 * 8.12/100)/12
		
		return 0;
	}
	public static float txdendettement(int id_loan) throws ClassNotFoundException, SQLException{
		
		DataSource b = DBConnector.createDataSource();
	      Connection vCon = b.getConnection();
	      String requete = "SELECT * FROM LOAN WHERE ID_LOAN="+id_loan;
	      try {
				Statement vSt = vCon.createStatement();
				ResultSet vRs = vSt.executeQuery(requete);
				while(vRs.next()){
					int id_client = vRs.getInt("ID_CLIENT");
					float Amount = (float) vRs.getInt("ASKED_AMOUNT")/12;
					String requete2 = "SELECT * FROM CLIENT WHERE ID_CLIENT="+id_client;
					ResultSet vRs2 = vSt.executeQuery(requete2);
			
					while(vRs2.next()){
						int salary = vRs2.getInt("SALARY");
						int charge = vRs2.getInt("CHARGE");
						System.out.println("salary "+salary);
						System.out.println("charge "+charge);
						float mensualite=totalinteretParMois(id_loan);
						
						System.out.println("mensualité "+ mensualite);
						mensualite = mensualite + Amount;
						System.out.println("mensualité final "+mensualite);
							
						float tx = (float)(mensualite + charge)/salary;
						vCon.close();
						System.out.println("taux : "+tx);
						return tx;
					}
					
					}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		

		vCon.close();
		return 0;
	}
}
