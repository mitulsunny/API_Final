package com.base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class callAPI {
	public static void main(String[] args) {
		for(int i=1;i<=10;i++) {
		Response res=callAPI.makeGetCall(i);
		String body=res.getBody().asString();
		//System.out.println(body);
		String ss=res.jsonPath().getString("data.email");
		String name=res.jsonPath().getString("data.first_name")+" "+res.jsonPath().getString("data.last_name");
		System.out.println(name);
		System.out.println(ss+"\n");
		}
	}
	public static Response makeGetCall(int idNumber) {
		RestAssured.baseURI ="https://reqres.in/api";
		RequestSpecification request = RestAssured.given();
		Response res=request.get("/users?id="+idNumber);
		return res;
	}

}
