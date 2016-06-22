package edu.client.socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class RateTCPClient {
	
	/*
	 *   The client class for the socket communication
	 *   As it knows the name of the machine  of the server and the port number that it listens to
	 *   The client asks a connection to the server by logging in with its IP address and port number linked to it.
	 */

	public String message;
	public String receivedMessage;
	public BufferedReader in = null;
	public PrintWriter out = null;
	public Socket socketClient;

	public RateTCPClient() throws UnknownHostException, IOException{
		int portNumber = 1237;
		socketClient = new Socket(InetAddress.getLocalHost(), portNumber);
	}

	public String sendReceive(String message) throws IOException {
		in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
		out = new PrintWriter(socketClient.getOutputStream(), true);
		out.println(message);
		System.out.println("Client send: " + message);
		receivedMessage = in.readLine();
		System.out.println("Client received: "+receivedMessage);
		return receivedMessage;
	}

	
	public void closeClient() throws IOException {
		in.close();
		out.close();
		socketClient.close();
	}

	
}