package com.ngi.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.ngi.pushserverBE.ServerBE;

public class Util {
	
	
	//get Value from Json
	
	public static  String getEventMessage(String strPersonelMessage, String strEventMessage1)
	{
		String strEventMessage="";
		  JSONParser parser = new JSONParser();
		  String str ="";
		  try {
		   if(!strPersonelMessage.equals("")){
		   Object obj = parser.parse(strPersonelMessage);
		 //  HashMap<String,String> dictionary=new HashMap<String, String>();		   
		   JSONObject jsonObject = (JSONObject) obj;
				   
		    Iterator iter = jsonObject.entrySet().iterator();
		    Map.Entry entry ;
		       while(iter.hasNext()){
		          entry = (Map.Entry)iter.next();
		         System.out.println(entry.getKey() + "=>" + entry.getValue());
		         //dictionary.put(entry.getKey().toString().trim(),entry.getValue().toString().trim());
		         
		         if(strEventMessage1.contains(entry.getKey().toString().trim()))
		         {
		        	String strMessage=strEventMessage1.replace(entry.getKey().toString().trim(), entry.getValue().toString().trim());
		         
		        	strEventMessage=strMessage;
		         }
		         
		         else{
		        	 
		        	 strEventMessage=strEventMessage1;
		         }
		         
		       }
		   }
		  
		  }catch (Exception e) {
		  
		   e.printStackTrace();
		   return strEventMessage;
		  }
		  
		  
		
		return strEventMessage;
		
	}
	
	
	
	//Get Config Parameters
	public static void getConfigParameters(HashMap<String, String> objHashMapServerDetails)
	{
		
		  ServerBE.strDatabaseURl=objHashMapServerDetails.get(ServerBE.strURlParameters);
		   ServerBE.strDatabaseName=objHashMapServerDetails.get(ServerBE.strDataBaseNameParam);
		   ServerBE.strUserName=objHashMapServerDetails.get(ServerBE.strDBUsernameParam);
		   ServerBE.strDBPassword=objHashMapServerDetails.get(ServerBE.strPassWordparam);
		   ServerBE.strMaximumNoOFRetries=objHashMapServerDetails.get(ServerBE.strNoOFRetriesParam);
		   ServerBE.strSenderID=objHashMapServerDetails.get(ServerBE.strAndroidSenderID);					 
		   ServerBE.maximumRetriesSize=Integer.parseInt(ServerBE.strMaximumNoOFRetries);
		 
		   ServerBE.strPartnerAppKeyStore=objHashMapServerDetails.get(ServerBE.strpartnerappKeyStore);
		   ServerBE.strUserAppKeyStore=objHashMapServerDetails.get(ServerBE.struserAppKeyStore);
		   String strproduction=objHashMapServerDetails.get(ServerBE.isAppTypeProduction);
		   ServerBE.isProduction=Boolean.parseBoolean(strproduction.trim());
		
	}
	
	
	
	//Reques json of input parameter
		public static String getJsonInputFiled(HashMap<String,String> hmInputQuery)
		{

			JSONObject objJson=new JSONObject();
			HashMap<String,String> hmQueryInput=hmInputQuery;

			Iterator iter = hmQueryInput.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry mEntry = (Map.Entry) iter.next();

				objJson.put(mEntry.getKey(),mEntry.getValue());

			}
			return objJson.toString();
		}


}
