package com.osa.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;

public class Rest_Utility {
	
	
	public static Map<String,Map<String, String>> mangeInputData(DataTable data) {
		Map<String, String> verify = new HashMap<String, String>();
		Map<String, String> header = new HashMap<String, String>();
		Map<String, String> parameter = new HashMap<String, String>();
		List<List<String>> info= data.raw();
		Map<String,Map<String,String>> all = new HashMap< String, Map<String,String>>();
		
		for (int i = 0; i < info.size(); i++) {
			if(info.get(i).get(0).equals("VAL")) {
					
			verify.put(info.get(i).get(1),info.get(i).get(2));
			
			}
			else if(info.get(i).get(0).equals("HEA")) {
					
					header.put(info.get(i).get(1),info.get(i).get(2));
					
					}
			else if(info.get(i).get(0).equals("PAR")) {
				
				parameter.put(info.get(i).get(1),info.get(i).get(2));
				
				}
			
		
	}
	all.put("VAL",verify);
	all.put("HEA",header);
	all.put("PAR",parameter);
	return all;
	}
	

}
