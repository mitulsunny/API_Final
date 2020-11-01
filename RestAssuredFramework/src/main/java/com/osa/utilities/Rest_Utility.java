package com.osa.utilities;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.api_Steps.Rest_Steps;
import com.base.callAPI;

import cucumber.api.DataTable;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
public class Rest_Utility {

	public static Map<String, Map<String, String>> mangeInputData(DataTable data) {
		Map<String, String> verify = new HashMap<String, String>();
		Map<String, String> header = new HashMap<String, String>();
		Map<String, String> parameter = new HashMap<String, String>();
		List<List<String>> info = data.raw();
		Map<String, Map<String, String>> all = new HashMap<String, Map<String, String>>();

		for (int i = 0; i < info.size(); i++) {
			if (info.get(i).get(0).equals("VAL")) {

				verify.put(info.get(i).get(1), info.get(i).get(2));

			} else if (info.get(i).get(0).equals("HEA")) {

				header.put(info.get(i).get(1), info.get(i).get(2));

			} else if (info.get(i).get(0).equals("PAR")) {

				parameter.put(info.get(i).get(1), info.get(i).get(2));

			}

		}
		all.put("VAL", verify);
		all.put("HEA", header);
		all.put("PAR", parameter);
		return all;
	}

	/*
	 * public static void verifyInfo(Response r, Map<String, Map<String, String>>
	 * in) {
	 * 
	 * if (in.containsKey("VAL")) { Map<String, String> keyy = in.get("VAL");
	 * printVerify(r, keyy);
	 * 
	 * }
	 * 
	 * else if (in.containsKey("HEA")) { Map<String, String> keyy = in.get("HEA");
	 * 
	 * }
	 * 
	 * else if (in.containsKey("PAR")) { Map<String, String> keyy = in.get("PAR");
	 * printVerify(r, keyy);
	 * 
	 * } }
	 */
	public static void printVerify(Map<String, Map<String, String>> value, Response r) {
		Map<String, String> keyy = value.get("VAL");
		for (Map.Entry<String, String> entry : keyy.entrySet()) {
			
			if (r.body().jsonPath().getString(entry.getKey()).equals(entry.getValue())) {
				System.out.println("The actual "+entry.getKey() +" and expected are matched");
			} else {
				System.out.println("The actual and expected did not match");
				System.out.println("The expected value is: " + entry.getValue());
				System.out.println("But the actual value is: " + Rest_Steps.r.jsonPath().getString(entry.getKey()));
			}
		}

	}
	
	

		
	

}


