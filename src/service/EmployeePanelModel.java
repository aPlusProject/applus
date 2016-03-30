package service;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Client;
import model.Employee;

public class EmployeePanelModel {
	
	private ArrayList<String> entete;
	private Employee employee;
	private ArrayList<Client> clientList;
	private ArrayList<String> aClient;
	private ArrayList<ArrayList<String>> clientArray;
	private ArrayList<ArrayList<String>> finalClientArray; 
	
	/**
	 * 
	 * @param isAgencyResponsable </br> 
	 * false : the call will return all client under the [Employee id] => @param idAgencyOrEmployee</br> 
	 * true : the call will return all clients under the [Agency id] => @param idAgencyOrEmployee
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 * create the entete and get all needed data from DB
	 * 
	 */
	public EmployeePanelModel(boolean isAgencyResponsable, int idAgencyOrEmployee) throws ClassNotFoundException, SQLException {
		
		this.entete = new ArrayList<String>();
		this.entete.add("Nom");
		this.entete.add("Prenom");
		this.entete.add("ID");
		
		this.employee = new Employee();
		this.clientList = this.employee.seeClients(isAgencyResponsable, idAgencyOrEmployee);
		
		this.clientArray = new ArrayList<ArrayList<String>>();
		for(int i=0; i< this.clientList.size(); i++) {
        	this.aClient = new ArrayList<String>();
        	this.aClient.add(this.clientList.get(i).getFirstName());
        	this.aClient.add(this.clientList.get(i).getLastName());
        	this.aClient.add(this.clientList.get(i).getID()+"");
        	this.clientArray.add(this.aClient);
        }
		
		this.finalClientArray = new ArrayList<ArrayList<String>>();
		for(int i=0;i<this.clientArray.size();i++) {
			this.finalClientArray.add(this.clientArray.get(i));
        }
	}
	
	/**
	 * @return an all clients
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
