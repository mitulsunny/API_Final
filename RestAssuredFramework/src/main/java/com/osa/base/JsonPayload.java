package com.osa.base;

import java.util.HashMap;

import org.json.simple.JSONObject;

public class JsonPayload {
	
	/**
	 * This method will that HashMap as a parameter 
	 * then return a Json payload. 
	 * @param hashMap
	 * @return
	 */
public static  String payload(HashMap<String,String> hashMap) {
		JSONObject jo=new JSONObject(hashMap);
		return jo.toString();
  }
}
