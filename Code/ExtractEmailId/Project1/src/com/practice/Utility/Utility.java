package com.practice.Utility;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.json.simple.JSONObject;

import com.ngi.RegexValidation.Configuration.RegexConfiguration;
import com.ngi.RegexValidation.utility.RegexMaches;

public class Utility {
	public static JSONObject CreateJson(String text){
		//JSONObject obj=new JSONObject("{\"text\":\""+text+"\"}");
		JSONObject obj=new JSONObject();
		obj.put("text", text);
		
		return obj;
	}
	
	public static List<String> ProcessRequest(JSONObject obj){
		
		RegexMaches regObj = new RegexMaches();
		String text=parseJSON(obj);
		try {
			return(regObj.getMatchedResult(RegexConfiguration.regexEmilId,text));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static String parseJSON(JSONObject obj){
		return (String) obj.get("text");
	}

}
