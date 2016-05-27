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

import edu.aplus.db.ConnectionPool;

public class ChartTCPServer {

	// static ServerSocket variable
	private static ServerSocket servSocket;
	// socket server port on which it will listen
	private static int port = 1234;
	private static String receivedMsg;
	private static String returnMsg = "";

	public static String getReturnMsg() {
		return returnMsg;
	}

	public static void main(String args[]) throws Exception {

		servSocket = new ServerSocket(port);
		System.out.println("Waiting for a connection on " + port);

		Socket fromClientSocket = servSocket.accept();
		PrintWriter pw = new PrintWriter(fromClientSocket.getOutputStream(), true);

		BufferedReader br = new BufferedReader(new InputStreamReader(fromClientSocket.getInputStream()));
		// receivedMsg = br.readLine();

		System.out.println(receivedMsg);
		ConnectionPool conn = new ConnectionPool();
		Connection co = null;
		conn.makeStack();

		co = conn.getConnection();
		try {
			PreparedStatement ps;
			ResultSet rs;

			String sql = "SELECT ID_LOAN, ASKED_AMOUNT,ASKED_DURATION,ASKED_RATE,ASKED_RATEINSURANCE,ASKED_DATE FROM LOAN";

			ps = co.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				// return JSON string
				/*
				 * {"loan_id":[ {"ASKED_AMOUNT":"10000", "ASKED_DURATION":"5",
				 * "ASKED_RATE":"2", "ASKED_RATEINSURANCE":"2", "ASKED_DATE":
				 * "2016-05-10 00:00:00.0"} ]}
				 */
				System.out.println(rs.getString("ASKED_AMOUNT"));
				returnMsg = "{chart: {'" + rs.getString("ID_LOAN") + "':[ {ASKED_AMOUNT:" + rs.getString("ASKED_AMOUNT")
						+ ", ASKED_DURATION:" + rs.getString("ASKED_DURATION") + ",ASKED_RATE:"
						+ rs.getString("ASKED_RATE") + ", ASKED_RATEINSURANCE:" + rs.getString("ASKED_RATEINSURANCE")
						+ ",ASKED_DATE:'" + rs.getString("ASKED_DATE") + "'} ]}}";
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				co.close();
			} catch (Exception e) {
				;
			}
		}

		co.close();
		pw.println(returnMsg);

		pw.close();
		br.close();

		fromClientSocket.close();
	}

}
