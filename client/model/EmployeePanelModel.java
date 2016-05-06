package model;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Client;
import socket.SocketClient;

//import model.Client;
//import model.Employee;

public class EmployeePanelModel {
	
	private ArrayList<String> entete;
	//private Employee employee;
	//private ArrayList<Client> clientList;
	private ArrayList<String> aClient;
	private ArrayList<ArrayList<String>> clientArray;
	private ArrayList<ArrayList<String>> finalClientArray;
	private SocketClient sck;
	private ArrayList<Client> arrayOfClient;
	
	public EmployeePanelModel() {
		
	}
	
	/**
	 * 
	 * @param isAgencyResponsable </br> 
	 * false : the call will return all client under the [Employee id] => @param idAgencyOrEmployee</br> 
	 * true : the call will return all clients under the [Agency id] => @param idAgencyOrEmployee
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 * create the entete and get all needed data from DB
	 * @throws IOException 
	 * 
	 */
	public EmployeePanelModel(boolean isAgencyResponsable, int idAgencyOrEmployee) throws ClassNotFoundException, SQLException, IOException {
		
		InetAddress localAdr= null;
		
		try {
			localAdr = InetAddress.getLocalHost();
		} catch (UnknownHostException e2) {
			e2.printStackTrace();
		}
		if (localAdr != null) {
			
			try {
				sck = new SocketClient(localAdr.getHostAddress(),144);
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		this.entete = new ArrayList<String>();
		this.entete.add("Nom");
		this.entete.add("Prenom");
		this.entete.add("ID");
		
		 
		 sck.send(idAgencyOrEmployee+"");
		 sck.receive();
		 
		 
		
		//this.employee = new Employee();
		//this.clientList = this.employee.seeClients(isAgencyResponsable, idAgencyOrEmployee);
		
		
		/*
		 * 
		 * 
		 * RECEPTION DES DONNEES
		 * jsonParsed = jsonfile.parse()
		 * this.clientList = jsonParsed
		 * 
		 */
		
		
		
		/*this.clientArray = new ArrayList<ArrayList<String>>();
		for(int i=0; i< this.clientList.size(); i++) {
        	this.aClient = new ArrayList<String>();
        	this.aClient.add(this.clientList.get(i).getFirstName());
        	this.aClient.add(this.clientList.get(i).getLastName());
        	this.aClient.add(this.clientList.get(i).getID()+"");
        	this.clientArray.add(this.aClient);
        }*/
		
		/*
		 * 
		 * 
		 * RECEPTION DES DONNEES
		 * jsonParsed = jsonfile.parse()
		 * this.clientList = jsonParsed
		 * 
		 */
		
		/*this.finalClientArray = new ArrayList<ArrayList<String>>();
		for(int i=0;i<this.clientArray.size();i++) {
			this.finalClientArray.add(this.clientArray.get(i));
        }*/
	}
	
	public void setArrayOfClients(Employee employee) throws ClassNotFoundException, SQLException {
		
		System.out.println(employee.getAllClients().get(1).getLastName());
		
		ArrayList<Client> arrayClient = employee.getAllClients();
		
		this.clientArray = new ArrayList<ArrayList<String>>();
		for(int i=0; i< arrayClient.size(); i++) {
			this.aClient = new ArrayList<String>();
        	this.aClient.add(arrayClient.get(i).getFirstName());
        	this.aClient.add(arrayClient.get(i).getLastName());
        	this.aClient.add(arrayClient.get(i).getID()+"");
        	this.clientArray.add(aClient);
			
		}
		
		this.finalClientArray = new ArrayList<ArrayList<String>>();
		for(int i=0;i<this.clientArray.size();i++) {
			this.finalClientArray.add(this.clientArray.get(i));
        }
        	
	}
	
	
	
	public Object getObject() {
		return arrayOfClient;
	}
	
	
	/**
	 * @return all clients
	 */
	public ArrayList<ArrayList<String>> getArrayOfClients() {
		return this.finalClientArray;
	}
	
	/**
	 * 
	 * @return the entete
	 */
	public ArrayList<String> getEntete() {
		return this.entete;
	}
	
	
}
