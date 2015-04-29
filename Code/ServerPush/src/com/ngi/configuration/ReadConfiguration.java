package com.ngi.configuration;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import com.ngi.pushserverBE.ServerBE;

public class ReadConfiguration {
	static Properties prop = new Properties();
	static String strConfiguePath="Configuration/Configuration.property";
		
		public static HashMap<String, String> readParameter(String dataBaseurl, String strDBName, String strUserName, String strPassword, String strMaximumRetries, String strsenderID,String strpartnerAppKeyStore, String struserAppKeyStore,String strAppType)
		{
			BufferedReader readMag;			
			String strUrl = "";
			String strDataBasename="";
			String strUsername="";
			String strPass="";
			String strNoOFRetries="";
			String strSenderID="";
			String strPartnerAppKeystore="";
			String strUserAppKeyStore="";
			String strApptype="";
			
			HashMap<String, String> objServerDetails= new HashMap<String, String>();
			
			
			try {
				    readMag = new BufferedReader(new FileReader(strConfiguePath));//Reading configration file parameter				
					prop.load(readMag);
					//ReadMag.close();
					strUrl = prop.getProperty(dataBaseurl).toString().trim();
					strDataBasename=prop.getProperty(strDBName).toString().trim();
					strUsername=prop.getProperty(strUserName).toString().trim();
					strPass=prop.getProperty(strPassword).toString().trim();
					strNoOFRetries=prop.getProperty(strMaximumRetries).toString().trim();
					strSenderID=prop.getProperty(strsenderID).toString().trim();
					strPartnerAppKeystore=prop.getProperty(strpartnerAppKeyStore).toString().trim();
				     strUserAppKeyStore=prop.getProperty(struserAppKeyStore).toString().trim();
				     strApptype=prop.getProperty(strAppType).toString().trim();
				    // ServerBE.strDataBaseNamedev=prop.getProperty( ServerBE.strDataBaseNamedev).toString().trim();

					objServerDetails.put(dataBaseurl, strUrl);
					objServerDetails.put(strDBName, strDataBasename);
					objServerDetails.put(strUserName, strUsername);
					objServerDetails.put(strPassword, strPass);
					objServerDetails.put(strMaximumRetries, strNoOFRetries);
					objServerDetails.put(strsenderID, strSenderID);
					objServerDetails.put(strpartnerAppKeyStore, strPartnerAppKeystore);
				     objServerDetails.put(struserAppKeyStore, strUserAppKeyStore);
				     objServerDetails.put(strAppType, strApptype);
				    
				     
					
					
					System.out.println(strUrl);
					
					readMag.close();
			}
				 catch (IOException e) {
					
					e.printStackTrace();
				}
			
			
			
		
		return objServerDetails;
		}
		
}

