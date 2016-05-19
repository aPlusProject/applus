package edu.aplus.service;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import edu.aplus.model.Client;
import edu.aplus.model.Employee;

public class JSonParser {
	
	

	public static Employee JSonToArray(String json) {

		Gson gson = new GsonBuilder().create();

		Employee employee = gson.fromJson(json, Employee.class);

		return employee;
	}
	
	public static String ObjectToJSon(Employee employee){
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(employee);
		
		return json;
	}
	

}
