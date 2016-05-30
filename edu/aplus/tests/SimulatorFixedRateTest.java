package edu.aplus.tests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import edu.aplus.business.SimulatorFixedRate;

public class SimulatorFixedRateTest {

	@Test
	public void getClientID() throws ClassNotFoundException, SQLException {
		
		System.out.println("testGetClientByID");
		//INSERT INTO CLIENT VALUES ('', 1, 45, 'DAVID', 'DUPONT', 'david@gmail.com', '0695562412', 'PARIS', '1 RUE DE CRETEIL', '75010', '2800', '1400', '10');
		//Insert firstly this sql code to make a test.
		SimulatorFixedRate sim = new SimulatorFixedRate();
		sim.getClientByID(5);
		assertTrue(sim.getClientByID(5).getSalary() == "2800");
		assertTrue(sim.getClientByID(5).getCharge() == "1400");
		assertTrue(sim.getClientByID(5).getSalary() == "10");
	}
	
	@Test
	public void calculateInstallmentTest() {
		System.out.println("testCalculateInstallment");
		SimulatorFixedRate sim = new SimulatorFixedRate();
		double d = sim.calculateInstallment("Crédit Immobilier", 100000, 12, 4.5);
		assertTrue(900.0 == d);
	}
}
