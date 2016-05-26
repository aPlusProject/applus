package edu.client.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONChartParser {

	private String amount;
	private String duration;
	private String rate;
	private String rate_insurance;
	private String date;
	private String year;
	private String month;
	
	
	public JSONChartParser(String jsonLine){
		JsonElement jelement = new JsonParser().parse(jsonLine);
	    JsonObject  jobject = jelement.getAsJsonObject();
	    jobject = jobject.getAsJsonObject("chart");
	    JsonArray jarray = jobject.getAsJsonArray("1");
	    jobject = jarray.get(0).getAsJsonObject();
	    amount = jobject.get("ASKED_AMOUNT").toString();
	    duration = jobject.get("ASKED_DURATION").toString();
	    rate = jobject.get("ASKED_RATE").toString();
	    rate_insurance = jobject.get("ASKED_RATEINSURANCE").toString();
	    date = jobject.get("ASKED_DATE").toString();
	}


	public String getAmount() {
		return amount;
	}


	public String getDuration() {
		return duration;
	}


	public String getRate() {
		return rate;
	}


	public String getRate_insurance() {
		return rate_insurance;
	}

	
	public String getYear(){
		String[] parts = date.split("-");
		year = parts[0]; // 2016
		return year;
	}
	
	public String getMonth(){
		String[] parts = date.split("-");
		month = parts[1]; // 05
		return month;
	}
	 
}
