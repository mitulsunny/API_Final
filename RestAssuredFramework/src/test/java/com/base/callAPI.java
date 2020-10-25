package com.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.api_Steps.Rest_Steps;
import com.osa.base.JsonPayload;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class callAPI {
	//When I send a "GET" request using the endpoint "/users?id=2"

	public static Response executeRquest(String request, String endPoint) {
		String req=request.toLowerCase();
		Response res=null;
		if(req.equals("get")) {
			res=get(endPoint);
		}else if(req.equals("post")) {
		    res=post(endPoint);	
		}else if(req.equals("patch")) {
			res=patch(endPoint);
		}else if(req.equals("delete")) {
			res=delete(endPoint);
		}
		return res;
	}
	
	
	/**
	 * This method will take the id and return response
	 * Example: get("/users?id=1");
	 * @param endpoint
	 * @return
	 */
	public static Response get(String endpoint) {
		RestAssured.baseURI ="https://reqres.in/api";
		RequestSpecification request = RestAssured.given();
		Response res=request.get(endpoint);
		return res;
	}
	
    

	/**
	 * This method will be use for sending post request
	 * @param endpoint
	 * @return
	 * post("/endpoint")
	 * Need to include body
	 */

	
	
	public static Response post(String endpoint) {
		String value=Rest_Steps.l;
		RestAssured.baseURI ="https://reqres.in/api";
		RequestSpecification request = RestAssured.given();
		
		Response res=request
				.contentType(ContentType.JSON)
				.body(value)
				.post(endpoint);
		return res;
	}
	
	/**
	 * This method will be use for sending Update request
	 * @param endpoint
	 * @return
	 * Example: patch("/endpoint/id")
	 * Nedd to include body
	 */
	public static Response patch(String endpoint) {
		JsonPayload js=new JsonPayload();
		RestAssured.baseURI ="https://reqres.in/api";
		RequestSpecification request = RestAssured.given();			
		Response res=request
				.contentType(ContentType.JSON)
				.body(js.patchBody())
				.patch(endpoint);
		return res;
	}
	
	
	
	/**
	 * This method will be used for sending Delete request
	 * @param endpoint
	 * @return
	 * delete("/endpoint/id")
	 */
	public static Response delete(String endpoint) {
		RestAssured.baseURI ="https://reqres.in/api";
		RequestSpecification request = RestAssured.given();			
		Response res=request
				.contentType(ContentType.JSON)
				.delete(endpoint);
		return res;
	}
	
}
