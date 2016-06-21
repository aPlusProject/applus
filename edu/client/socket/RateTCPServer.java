package edu.client.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import edu.aplus.business.SimulatorFixedRate;
import edu.aplus.db.ConnectionPool;
import edu.aplus.gui.ChooseLoanTypePanel;
import edu.aplus.model.Client;
import edu.aplus.model.Loan;
import edu.aplus.model.Rate;
import edu.aplus.service.JsonParser_new;

public class RateTCPServer {

	private static ServerSocket serverSocket;
	private static int port = 1237;
	private static String receivedMessage;
	private static String returnMessage;
	

	public static void main(String args[]) throws Exception {

		serverSocket = new ServerSocket(port);

		System.out.println("Waiting for a connection on " + port);

		while (true) {

			Socket socket = serverSocket.accept();
			Thread stuffer = new StuffThread1(socket);
			stuffer.start();
		}
	}
}



class StuffThread1 extends Thread {

	private byte[] data = new byte[255];
	public final JsonParser_new jparser = new JsonParser_new();
	private Socket fromClientSocket;
	private Rate rate;

	public StuffThread1(Socket socket) {

		for (int i = 0; i < data.length; i++)
			data[i] = (byte) i;
		this.fromClientSocket = socket;
	}

	public void run() {
		Rate rate = new Rate();
		ConnectionPool conn = rate.getPool();
		Connection co;
		double value = 0;
		

		try {

			PrintWriter out = new PrintWriter(fromClientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(fromClientSocket.getInputStream()));
			String ClientMessageRule = in.readLine();
			int duration ;
			String loanName;

			System.out.println("SERVER received:" + ClientMessageRule);
			
			System.out.println("je dois mouliner les données");
			out.println("la7rira");
			String ClientMessage = in.readLine();

			System.out.println("SERVER recieved:" + ClientMessage);
			rate = jparser.JSonToObjectRate(ClientMessage);
			 duration= rate.getDuration();
			 loanName = rate.getLoanName();
			System.out.println(duration+" : " + loanName);
			System.out.println(rate);
			conn = new ConnectionPool();

			conn.makeStack();
			co = conn.getConnection();
			PreparedStatement ps;
			ResultSet rs;
			String sql = null;	

			//out.println("received");

			if (ClientMessageRule.equals("calculateRate")){
				

				// requete SQL
				/////////////////////////////////////////////////////////////////
					

				sql = "SELECT RATE_VALUE FROM RATE WHERE RATE_DURATION = "+duration+" AND RATE_TYPE = '"+loanName+"' ";
				System.out.println(sql);

				rs = co.createStatement().executeQuery(sql);
				while(rs.next()) {
					value = rs.getDouble("RATE_VALUE");
				} 
				conn.closeConnection(co);
				/////////////////////////////////////////////////////////////

				JsonObject root = new JsonObject();
				System.out.println("je suis ici6 : "+value);
				root.addProperty("rate", value);
				out.println(root.toString());

			}

				else if (ClientMessageRule.equals("updateRate")){

				// requete SQL
				/////////////////////////////////////////////////////////////////
				
				
					
				// value = rate.getRateValue();

				sql = "UPDATE RATE SET RATE_AGENCY = ? WHERE RATE_DURATION = "+duration+" AND RATE_TYPE = '"+loanName+"' ";
				System.out.println(sql);
				ps = co.prepareStatement(sql);
				
				ps.setDouble(1,value); 
				
				//double value = 0;
				//value  = rate.getRateAgency(co);
				//double value;
				//rs = ps.executeQuery();

				//rs.updateDouble(1,value);

				//ps.setString(1, champ.getText());
				ps.executeUpdate();

				
				conn.closeConnection(co);
				/////////////////////////////////////////////////////////////

				JsonObject root = new JsonObject();
				System.out.println("je suis ici6 : "+value);
				root.addProperty("rate", value);
				out.println(root.toString());

			} 

			out.close();
			in.close();

			fromClientSocket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}		  
	}
}
/*
	public void run(float f) throws IOException {
		

			PrintWriter out = new PrintWriter(fromClientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(fromClientSocket.getInputStream()));
			String ClientMessageRule = in.readLine();

			System.out.println("SERVER received:" + ClientMessageRule);

			//out.println("received");

			if (ClientMessageRule.equals("updateRate")){
				System.out.println("je dois mouliner les données");
				out.println("la7rira");
				String ClientMessage = in.readLine();

				System.out.println("SERVER recieved:" + ClientMessage);
				Rate rate = jparser.JSonToObjectRate(ClientMessage);
				int duration= rate.getDuration();
				String loanName = rate.getLoanName();
				System.out.println(duration+" : " + loanName);
				System.out.println(rate);

				ConnectionPool conn = rate.getPool();
				Connection co= null;
				conn = new ConnectionPool();
				try {
					conn.makeStack();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try{
					ResultSet rs;
					PreparedStatement ps ;
					co = conn.getConnection();

					// rate_agency is the column for the new rate"( modified by the director)
					String query = "UPDATE RATE SET RATE_AGENCY = "+f+" WHERE RATE_DURATION = "+duration+" AND RATE_TYPE = '"+loanName+"' ";

					System.out.println(query);
					ps = co.prepareStatement(query);

					//ps.setString(1, champ.getText());
					//ps.executeUpdate();
					rs = ps.executeQuery();


				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		
	}

}*/




