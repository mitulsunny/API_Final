package com.api_Steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.base.callAPI;
import com.osa.base.JsonPayload;
import com.osa.utilities.Rest_Utility;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;

public class Rest_Steps {
	Response r;
	public static String l;

	@Given("^I want to create a new user with the following information$")
	public void i_want_to_create_a_new_user_with_the_following_information() throws Throwable {
		

	}

	@Then("^I want the  new user to be created  through \"([^\"]*)\" HTTP Method using the endpoint \"([^\"]*)\"$")
	public void i_want_the_new_user_to_be_created_through_HTTP_Method_using_the_endpoint(String arg1, String arg2,Map<String, String> data) {
		Map<String, String> store = new HashMap<String, String>();
		for (Map.Entry<String, String> entry : data.entrySet()) {
			store.put(entry.getKey(), entry.getValue());
      
		}
		
		

		l = JsonPayload.payload(store);
		r = callAPI.executeRquest(arg1, arg2);


	}
	@Then("^I verify first name$")
	public void i_verify_first_name(DataTable data) throws Throwable {
		Map<String,Map<String, String>> info =Rest_Utility.mangeInputData(data);
	     
		Map<String,String> keyy= info.get("VAL");
		for (Map.Entry<String, String> entry : keyy.entrySet()) {
			System.out.println(entry.getKey()+ " "+ entry.getValue());
      
		}
	}

	@Then("^Later I validate the HTTP Status code$")
	public void later_I_validate_the_HTTP_Status_code() throws Throwable {
		if (r.statusCode() == 201) {
			System.out.println("A valid HTTP code  " + r.statusCode() + " occured");
		} else {
			System.out.println("An error HTTP code " + r.statusCode() + " occured");
		}
	}

	@Then("^it should create a new user$")
	public void it_should_create_a_new_user() throws Throwable {
		System.out.println("User created Sucessfully");
	}

}
