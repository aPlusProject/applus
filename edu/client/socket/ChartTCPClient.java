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

import edu.client.model.Chart;
import edu.client.service.JSONChartParser;

public class ChartTCPClient {

	public String sendMsg;
	private String receivedMsg="";

	public ChartTCPClient(String msg)
			throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
		Socket socket1;
		int portNumber = 1234;

		socket1 = new Socket(InetAddress.getLocalHost(), portNumber);

		BufferedReader br = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
		receivedMsg=br.readLine();
		System.out.println("Received: "+receivedMsg);
		JSONChartParser chartinfo = new JSONChartParser(receivedMsg);
		
		Chart c1 = new Chart("Loan evolution chart",chartinfo.getAmount(),chartinfo.getDuration(),chartinfo.getRate(),chartinfo.getRate_insurance(),chartinfo.getYear(),chartinfo.getMonth());
		c1.afficher();
		
		PrintWriter pw = new PrintWriter(socket1.getOutputStream(), true);

		pw.println(sendMsg);
		//System.out.println("Send: "+sendMsg);
		br.close();
		pw.close();
		socket1.close();
	}
}
