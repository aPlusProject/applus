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

	private static ServerSocket servSocket;
	private static int port = 1234;
	private static String receivedMsg;
	private static String returnMsg;
	

	public static void main(String args[]) throws Exception {

		servSocket = new ServerSocket(port);
		
		System.out.println("Waiting for a connection on " + port);

			while (true) {
				
		      Socket socket = servSocket.accept();
		      Thread stuffer = new StuffThread(socket);
		      stuffer.start();
		    }
	}
}

class StuffThread extends Thread {
		  
	private byte[] data = new byte[255];
	public final JsonParser_new jparser = new JsonParser_new();
	private Socket fromClientSocket;

	public StuffThread(Socket socket) {

		for (int i = 0; i < data.length; i++)
			data[i] = (byte) i;
		    this.fromClientSocket = socket;
	}

	public void run() {
		try {
			
			PrintWriter pw = new PrintWriter(fromClientSocket.getOutputStream(), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(fromClientSocket.getInputStream()));
			String ClientMsgRule = br.readLine();
			
			System.out.println("SERVER recieved:" + ClientMsgRule);
				
			pw.println("recieved");
			
			String ClientMsg = br.readLine();
				
			System.out.println("SERVER recieved:" + ClientMsg);
				
			if(ClientMsgRule.equals("getclientbyID")) {
				
				System.out.println("Client found");
					
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
			
				else if(ClientMsgRule.equals("calculateLoan")) {
					
					Gson gson = new GsonBuilder().create();
					JsonParser_new jparser = new JsonParser_new();
					Loan loan = jparser.JSonToObjectLoan(ClientMsg);
					Double installment = new SimulatorFixedRate().calculateInstallment(
							
							loan.getLoanType(), 
							loan.getAskesAmount(),
							loan.getAskedDuration(),
							loan.getAskedRate());
					
					Double installmentFinal = new SimulatorFixedRate().calculateFinalInstallment(
							
							loan.getLoanType(), 
							loan.getAskesAmount(),
							loan.getAskedDuration(),
							loan.getAskedRate(),
							loan.getAskedRateInsurance());
				
					System.out.println("SERVER:" + installment);
				
					System.out.println("SERVER:" + installmentFinal);
					
					pw.println( "{\"installment\":" + installment +",\"installmentFinal\":" + installmentFinal + "}");
						
				}
			
				else if(ClientMsgRule.equals("saveLoan")) {
					
					Gson gson = new GsonBuilder().create();
					JsonParser_new jparser = new JsonParser_new();	
					Loan loan = jparser.JSonToObjectLoan(ClientMsg);
					
					SimulatorFixedRate sim = new SimulatorFixedRate();
					sim.addLoan(loan.getClient().getID()
					,1,1,1,
					loan.getAskesAmount(), 
					loan.getAskedDuration(), 
					Double.valueOf(loan.getAskedRate()), 
					Double.valueOf(loan.getAskedRateInsurance()));
			
					 //loan.setLoanTypeID(creditType.getSelectedIndex() +3);
					
					pw.println("Saved");
					
				}
			
				pw.close();
				br.close();

				fromClientSocket.close();
		   
		    } catch (Exception e) {
		    	
		    }		  
	}
}

