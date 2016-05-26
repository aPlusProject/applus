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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.aplus.business.SimulatorFixedRate;
import edu.aplus.model.Client;
import edu.aplus.model.Loan;
import edu.aplus.service.JsonParser_new;

public class TCPServer {

	// static ServerSocket variable
	private static ServerSocket servSocket;
	// socket server port on which it will listen
	private static int port = 1234;
	private static String receivedMsg;
	private static String returnMsg;
	
	public static JsonParser_new jparser = new JsonParser_new();
	
	
	

	public static void main(String args[]) throws Exception {

		servSocket = new ServerSocket(port);
		System.out.println("Waiting for a connection on " + port);

		Socket fromClientSocket = servSocket.accept();
		PrintWriter pw = new PrintWriter(fromClientSocket.getOutputStream(), true);

		BufferedReader br = new BufferedReader(new InputStreamReader(fromClientSocket.getInputStream()));
		
		String ClientMsgRule = br.readLine();
		System.out.println("SERVER recieved:" + ClientMsgRule);
		
		pw.println("recieved");
	
		
		String ClientMsg = br.readLine();
		
		System.out.println("SERVER recieved:" + ClientMsg);
		
		if(ClientMsgRule.equals("getclientbyID")) {
			System.out.println("oldoson");
			
			SimulatorFixedRate fixedrate = new SimulatorFixedRate();
			Client cl = null;
			
			cl = fixedrate.getClientByID(Integer.parseInt(ClientMsg));
			
			if (cl == null) { 
				System.out.println("Not found");
				pw.println("Not found");
				}
			else {
				
				System.out.println("SERVER: found");
			
				pw.println(jparser.ObjectToJSon(cl));
			}
			
		}
		else if(ClientMsgRule =="addloan") {
			
			Gson gson = new GsonBuilder().create();
			Loan loan = gson.fromJson(ClientMsg, Loan.class);
			
			SimulatorFixedRate fixedrate = new SimulatorFixedRate();
			Client cl = null;
			
		//	cl = fixedrate.addLoan(
		//			idClient, idConseiller, idLoanType, idHistory, askedAmount, askedDuration, askedRate, askedRateInsurance);(Integer.parseInt(ClientMsg));
			
		}
		
		
		

		pw.close();
		br.close();

		fromClientSocket.close();
	}
	
	


}
