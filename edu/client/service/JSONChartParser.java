package edu.client.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONChartParser {

	private String result;
	
	public JSONChartParser(String jsonLine){
		JsonElement jelement = new JsonParser().parse(jsonLine);
	    JsonObject  jobject = jelement.getAsJsonObject();
	    jobject = jobject.getAsJsonObject("chart");
	    JsonArray jarray = jobject.getAsJsonArray("1");
	    jobject = jarray.get(0).getAsJsonObject();
	    result = jobject.get("ASKED_AMOUNT").toString();
	    
	}
	
	public String getResult() {
		return result;
	}
	 
}
