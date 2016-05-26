package edu.aplus.service;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import edu.aplus.model.Client;
import edu.aplus.model.Employee;

public class JsonParser_new {
	
	

	public static Client JSonToObject(String json) {

		Gson gson = new GsonBuilder().create();

		Client client = gson.fromJson(json, Client.class);

		return client;
	}
	
	public static String ObjectToJSon(Client client){
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(client);
		
		return json;
	}
	

}
