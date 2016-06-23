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

import edu.aplus.model.Client;
import edu.aplus.model.Loan;
import edu.aplus.model.Rate;
import edu.aplus.service.JsonParser_new;

/* 
 *  The server is on a specific machine and is linked to a specific number port
 *  It listens to the client which asks a connetion
 */

public class RateTCPServer {

	private static ServerSocket serverSocket;
	private static int port = 1237;
	
   /* The main server */
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
/*
 *  Now, if the client wants to connect with the server,  thread will make the connection. It won't be necessary
 *  to call the server. All will be done by this thread
 */
class StuffThread1 extends Thread {

	private byte[] data = new byte[255];
	public final JsonParser_new jparser = new JsonParser_new();
	private Socket fromClientSocket;

	public StuffThread1(Socket socket) {

		for (int i = 0; i < data.length; i++)
			data[i] = (byte) i;
		this.fromClientSocket = socket;
	}

	public void run() {
		Rate rate = new Rate();
		ConnectionPool conn = rate.getPool();
		Connection co;
		float value = 0;


		try {
			PrintWriter out = new PrintWriter(fromClientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(fromClientSocket.getInputStream()));
			String ClientMessageRule = in.readLine();
			final int duration ;
			final String loanName;

			/* If the director want to see a rate */
			if (ClientMessageRule.equals("calculateRate")){
				System.out.println("Server received: " + ClientMessageRule);
				out.println("Yes?");
				String ClientMessage = in.readLine();
				System.out.println("Server received:" + ClientMessage);
				rate = JsonParser_new.JSonToObjectRate(ClientMessage);
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
				sql = "SELECT RATE_VALUE FROM RATE WHERE RATE_DURATION = "+duration+" AND RATE_TYPE = '"+loanName+"' ";
				System.out.println(sql);
				rs = co.createStatement().executeQuery(sql);
				while(rs.next()) {
					value = rs.getFloat("RATE_VALUE");
					rate.setRateValue(value);
				} 
				conn.closeConnection(co);
				// Parsing
				JsonObject root = new JsonObject();
				System.out.println("je suis ici : "+value);
				root.addProperty("rate", value);
				out.println(root.toString());
			}
			/* Director want to update a rate */
			else if (ClientMessageRule.equals("updateRate")){
				System.out.println("Server received:" + ClientMessageRule);
				System.out.println("je dois modifier les données");
				out.println("Yes 2?");
				String ClientMessage = in.readLine();
				System.out.println("Server recieved:" + ClientMessage);
				rate = JsonParser_new.JSonToObjectRate(ClientMessage);
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
				System.out.println("je modifie les données");
				System.out.println("j'ai ça comme rate agency:"+rate.getRateAgency());
				// SQL Query
				sql = "UPDATE RATE SET RATE_AGENCY = "+rate.getRateAgency()+" WHERE RATE_DURATION = "+duration+" AND RATE_TYPE = '"+loanName+"' ";
				System.out.println(sql);
				ps = co.prepareStatement(sql);
				value = rate.getRateAgency();
				rs = ps.executeQuery();
				conn.closeConnection(co);
				// Parsing
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

