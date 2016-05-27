package edu.aplus.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

import edu.aplus.service.ChartsIndicator;
import edu.client.service.JSONChartParser;
import edu.client.socket.ChartTCPClient;
import edu.client.socket.ChartTCPServer;

public class ShowChartTest {

	// test all functionality of UC "Afficher et imprimer les resultats d'un
	// calcul de pret
	
	@Test
	public void testChartTCPServerDBConnexion() throws ClassNotFoundException, SQLException {
		String expectedStr = " {chart: {'1':[ {ASKED_AMOUNT:10000, ASKED_DURATION:2,ASKED_RATE:2, ASKED_RATEINSURANCE:1,ASKED_DATE:'2016-05-10 00:00:00.0'} ]}}";
		ChartTCPServer chartServer = new ChartTCPServer();
		String receivedStr = chartServer.getReturnMsg();
		assertTrue(expectedStr == receivedStr);
	}
	
	@Test
	public void testJSONChartParser() throws ClassNotFoundException, SQLException {
		String JSONSample = " {chart: {'1':[ {ASKED_AMOUNT:10000, ASKED_DURATION:2,ASKED_RATE:2, ASKED_RATEINSURANCE:1,ASKED_DATE:'2016-05-10 00:00:00.0'} ]}}";
		JSONChartParser parsed = new JSONChartParser(JSONSample);
		String expectedStr="10000";
		String receivedStr=parsed.getAmount();
		assertTrue(expectedStr == receivedStr);
	}
	
	
	
	
}
