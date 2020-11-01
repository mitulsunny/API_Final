package com.osa.base;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

public class JsonPayload {
	public String email="george.bluth@reqres.in";
	public  String patchBody() {
		
		
		String body="{\"email\":\""+email+"\",\"first_name\": \"George\",\"last_name\": \"Bluth\",\"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg\"}";
		return body;
	}
	public static void main(String[] args) {
		JsonPayload js=new JsonPayload();
		System.out.println(js.patchBody());
	}
	
	/**
	 * This method will that HashMap as a parameter 
	 * then return a Json payload. 
	 * @param hashMap
	 * @return
	 */
public static  JSONObject payload(Map<String,String> hashMap) {
	
		JSONObject jo=new JSONObject(hashMap);
		
		return jo;
		
  }
}
