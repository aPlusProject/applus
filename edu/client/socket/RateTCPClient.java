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

public class RateTCPClient {

	public String message;
	public String receivedMessage;
	public BufferedReader in = null;
	public PrintWriter out = null;
	public Socket socketClient;

	public RateTCPClient() throws UnknownHostException, IOException{
		
		int portNumber = 1237;
		socketClient = new Socket(InetAddress.getLocalHost(), portNumber);
	}
	
	public String SendRecieve(String message) throws IOException {

		in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
		out = new PrintWriter(socketClient.getOutputStream(), true);
		out.println(message);
		
		System.out.println("CLIENT:Send: " + message);
	
		receivedMessage = in.readLine();
		
		System.out.println("CLIENT Received: "+receivedMessage);
		
		return receivedMessage;
	}
	
	public void closeClient() throws IOException {
		
		in.close();
		out.close();
		socketClient.close();
	}

	public String SendRecieve(String string, String objectToJSonRate) throws IOException {
		in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
		out = new PrintWriter(socketClient.getOutputStream(), true);
		out.println(message);
		out.println(objectToJSonRate);
		System.out.println("CLIENT:Send: " + message);
	
		receivedMessage = in.readLine();
		
		System.out.println("CLIENT Received: "+receivedMessage);
		
		return receivedMessage;
	}
}