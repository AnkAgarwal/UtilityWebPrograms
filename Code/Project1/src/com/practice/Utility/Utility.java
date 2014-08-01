package com.practice.Utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.json.simple.JSONObject;

import com.ngi.RegexValidation.Configuration.RegexConfiguration;
import com.ngi.RegexValidation.utility.RegexMaches;
import com.practice.Configuration.Configuration;

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
	
	public static void read(String configFilePath){
		Properties prop=new Properties();
		BufferedReader ReadMag=null;
		
		try {
			ReadMag=new BufferedReader(new FileReader(new File(configFilePath)));			
			prop.load(ReadMag);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Configuration.MaxentTaggerManyObjects=prop.getProperty("MaxentTaggerManyObjects");
		//System.out.println(prop.getProperty("MaxentTaggerManyObjects"));
	}

}
