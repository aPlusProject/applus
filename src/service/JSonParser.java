package service;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import model.Client;

public class JSonParser {

	public ArrayList<Client> JSonToArray(JsonElement json) {

		Gson gson = new Gson();

		ArrayList<Client> clients = gson.fromJson(json, ArrayList.class);

		return clients;
	}
	
	public void ArrayToJSon(ArrayList<Client> arrClients){
		Gson gson = new GsonBuilder().create();
		
		for(int i=0;i<arrClients.size();i++){
			Client c = new Client();
			
		}
		
	}

}
