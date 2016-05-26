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

import javax.sql.DataSource;

import edu.aplus.db.ConnectionPool;


public class ChartTCPServer {

	// static ServerSocket variable
	private static ServerSocket servSocket;
	// socket server port on which it will listen
	private static int port = 1234;
	private static String receivedMsg;
	private static String returnMsg;

	public static void main(String args[]) throws Exception {

		servSocket = new ServerSocket(port);
		System.out.println("Waiting for a connection on " + port);

		Socket fromClientSocket = servSocket.accept();
		PrintWriter pw = new PrintWriter(fromClientSocket.getOutputStream(), true);

		BufferedReader br = new BufferedReader(new InputStreamReader(fromClientSocket.getInputStream()));
		//receivedMsg = br.readLine();
		
		System.out.println(receivedMsg);
		ConnectionPool conn = new ConnectionPool();
		Connection co= null;
		conn.makeStack();
		
		co = conn.getConnection();
		if (co != null) {
			returnMsg="Connected";
		}
		else {
			returnMsg="Failed";
		}
		
		co.close();
		pw.println(returnMsg);

		pw.close();
		br.close();

		fromClientSocket.close();
	}

}
