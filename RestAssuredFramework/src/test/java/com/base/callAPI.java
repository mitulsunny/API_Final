package com.base;

import java.util.HashMap;

import com.osa.base.JsonPayload;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class callAPI {
	public static void main(String[] args) {
		Response res=post("/users");
		//System.out.println(res.asString());
		res.prettyPrint();
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		
//		for(int i=1;i<=10;i++) {
//		Response res=callAPI.get(i);
//		String body=res.getBody().asString();
//		//System.out.println(body);
//		String ss=res.jsonPath().getString("data.email");
//		String name=res.jsonPath().getString("data.first_name")+" "+res.jsonPath().getString("data.last_name");
//		System.out.println(name);
//		System.out.println(ss+"\n");
//		}
	}
	public static Response get(int idNumber) {
		RestAssured.baseURI ="https://reqres.in/api";
		RequestSpecification request = RestAssured.given();
		Response res=request.get("/users?id="+idNumber);
		return res;
	}
	
    

	/**
	 * This method will be use for sending post request
	 * @param endpoint
	 * @return
	 */
	public static Response post(String endpoint) {
		RestAssured.baseURI ="https://reqres.in/api";
		RequestSpecification request = RestAssured.given();			
		Response res=request
				.contentType(ContentType.JSON)
				.body("JsonPayload.payload()")
				.post(endpoint);
		return res;
	}

}
