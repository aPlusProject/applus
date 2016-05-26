package edu.client.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	public String msg;
	public String receivedMsg;
	
	BufferedReader br = null;
	PrintWriter pw = null;
	Socket socket1;

	public TCPClient() throws UnknownHostException, IOException{
		
		int portNumber = 1234;

		socket1 = new Socket(InetAddress.getLocalHost(), portNumber);
	}
	
	public String SendRecieve(String msg)
			throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {

		

		 br = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
		 pw = new PrintWriter(socket1.getOutputStream(), true);

		pw.println(msg);
		System.out.println("CLIENT:Send: " + msg);
	
		receivedMsg = br.readLine();
		System.out.println("CLIENT Recieved: "+receivedMsg);
	
		
		return receivedMsg;
	}
	
	public void closeClient() throws IOException {
		
		br.close();
		pw.close();
		socket1.close();
	}
}
