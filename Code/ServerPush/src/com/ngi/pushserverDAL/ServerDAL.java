package com.ngi.pushserverDAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.JAXBElement.GlobalScope;

import com.ngi.pushserverBE.ServerBE;

public class ServerDAL {
	
	
	
	
	public static String getBarName(String strBarID){
		String strBarName="";
		Connection  conn;
		try {
			
		
		  String url = ServerBE.strDatabaseURl+ServerBE.strDataBaseNamedev;	
		// String url = "jdbc:mysql://Localhost:3306/isp_utildatabase_dev";  
       Class.forName (ServerBE.strDriver);
       conn = DriverManager.getConnection (url,ServerBE.strUserName,ServerBE.strDBPassword);    
	     // PreparedStatement st = conn.prepareStatement("select * from tbl_utilevent");	         
       PreparedStatement st=conn.prepareStatement("call SP_GetBarName(?)");     
       st.setString(0, strBarID);
	     ResultSet r1=st.executeQuery();
	     
	     if(r1.next()) {  
	    	 
	    	strBarName =r1.getString(ServerBE.keyBarName);
	     }
	     
	     
		} catch (Exception e) {
			// TODO: handle exception
		}
	     
		return strBarName;
	}
	
	//Check Any pendingnotification 
	
	public static ArrayList<ServerBE> getNotificationDetails() 
	{
		ArrayList<ServerBE> objarrList=new ArrayList<ServerBE>();
		Connection  conn=null;
		CallableStatement cs=null;
		ServerBE objServerBE=null;
		
		try{
			
					
			 // String url = ServerBE.strDatabaseURl+ServerBE.strDatabaseName;	
			 String url = ServerBE.strDatabaseURl;
			// String url = "jdbc:mysql://Localhost:3306/isp_utildatabase_dev";  
	         Class.forName (ServerBE.strDriver);
	         conn = DriverManager.getConnection (url,ServerBE.strUserName,ServerBE.strDBPassword);    
		     // PreparedStatement st = conn.prepareStatement("select * from tbl_utilevent");	         
//	         PreparedStatement st=conn.prepareStatement("call SP_GetPushNotificationDetail()"); 
	         cs=(CallableStatement)conn.prepareCall("Exec SP_GetPushNotificationDetail");
		     ResultSet r1=cs.executeQuery();

		     while(r1.next()) {    
		    	 objServerBE=new ServerBE();
		    	 objServerBE.setStrPendingNotificationID(r1.getString("PendingNotificationID").trim());
		    	 objServerBE.setStrUserID(r1.getString("UserID").trim());
		    	 objServerBE.setStrAppCode(r1.getString("AppCode").trim());
		    	 objServerBE.setStrDeviceID(r1.getString("DeviceID").trim());
		    	 objServerBE.setStrDeviceDecription(r1.getString("DeviceDecription").trim());
		    	 objServerBE.setStrDefaultUserID(r1.getString("DefaultUserID").trim());
		    	 objServerBE.setStrDefaultDeviceID(r1.getString("DefaultDeviceID").trim());
		    	 objServerBE.setStrPersonalizedMessage(r1.getString("PersonalizedMessage").trim());
		    	 objServerBE.setStrNoNotificationStartTime(r1.getString("NoNotificationStartTime").trim());
		    	 objServerBE.setStrNoNotificationDuration(r1.getString("NoNotificationDuration").trim());
		    	 objServerBE.setStrBarTimeZoneCode(r1.getString("BarTimeZoneCode").trim());
		    	 objServerBE.setStrNumberOfRetries(r1.getString("NumberOfRetries").trim());				 
		    	 objServerBE.setStrEventCode(r1.getString(ServerBE.keyEventCode).trim());
		    	 objServerBE.setStrEventDesc(r1.getString("EventDesc").trim());
		    	 objServerBE.setStrEventMessage(r1.getString("EventMessage").trim());
		    	 objServerBE.setStrSubject(r1.getString("Subject").trim());
		    	 objServerBE.setStrPendingNotificationCreatedOn(r1.getString("Createdon").trim());
		    	 objServerBE.setStrBarID(r1.getString("BarID").trim());
		    	 objServerBE.setStrBookingID(r1.getString(ServerBE.keyBookingID).trim());
		    	 objServerBE.setStrEventMessage(r1.getString("EventMessage").trim());
		    	 objarrList.add(objServerBE);
					
		      }
		     
		    /* ServerBE.strMessageIOS=ServerBE.strPersonalizedMessage;
		     //strTokenID=strDeviceID;
		     ServerBE.strDeviceid=ServerBE.strDeviceID;
		    */
		     /*System.out.println( strPendingNotificationID);
		     System.out.println(strAppCode);
		     System.out.println(strUserID);
		     System.out.println(strDeviceID);
		     System.out.println(strDeviceDecription);
		     System.out.println(strPersonalizedMessage);
		     System.out.println(strNoNotificationStartTime);
		     System.out.println(strNoNotificationDuration);
		     System.out.println(strNumberOfRetries);
		     System.out.println(strEventCode);
		     System.out.println(strEventDesc);
		     System.out.println(strEventMessage);
		     System.out.println(strSubject);
		     System.out.println(strPendingNotificationCreatedOn);
				*/
		     
		    // conn.commit();
		     
		     
			}
			
			catch(Exception e)
			{
				 //conn.close();
				e.printStackTrace();
				
			}finally{
				try{
				conn.close();
				}catch(Exception e){
					
					
				}
				
			}
				
		return objarrList;
	}
	
	
	
	
	   //Method To Update Number OF Retries
		public static  void insertIntoSentPushNotification(ServerBE objServerBE,String strResponseCode,
				String strNotificationstatus,int intNoOFRetries,
				String isNotificationSentToDefaultUser)
		{
			
			  
    		 
    	  
    			
   
			
			 		Connection  conn;
			
					try{
					 String url = ServerBE.strDatabaseURl;
					 //String url = "jdbc:mysql://Localhost:3306/isp_utildatabase_dev";  
			         Class.forName (ServerBE.strDriver);
			         conn = DriverManager.getConnection (url,ServerBE.strUserName,ServerBE.strDBPassword);    
				     // PreparedStatement st = conn.prepareStatement("select * from tbl_utilevent");	         
			         PreparedStatement st=conn.prepareStatement("{call SP_InsertIntoPushNotification(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");  
			         st.setString(1, objServerBE.getStrPendingNotificationID());
			         st.setString(2, objServerBE.getStrPendingNotificationCreatedOn());
			         st.setString(3, objServerBE.getStrPushNotificationDateTime());
			         st.setString(4, objServerBE.getStrUserID());
			         st.setString(5, objServerBE.getStrEventCode().trim());
			         st.setString(6, objServerBE.getStrAppCode());
			         st.setString(7, objServerBE.getStrDeviceID());
			         st.setString(8, objServerBE.getStrDefaultUserID());
			         st.setString(9, objServerBE.getStrDefaultDeviceID());
			         st.setString(10,objServerBE.getStrBarID());
			         st.setString(11, objServerBE.getStrBookingID());
			         st.setString(12, strResponseCode);
			         st.setString(13, objServerBE.getStrPersonalizedMessage());
			         st.setString(14, isNotificationSentToDefaultUser);
			         st.setString(15, objServerBE.getStrBarTimeZoneCode());
			         st.setInt(16, intNoOFRetries);
			         st.setString(17, objServerBE.getStrDeviceDecription());
			         st.setString(18, strNotificationstatus);
				     st.execute();
				    // conn.commit();
				     conn.close();
				     
					}
					catch(Exception e)
					{
						e.printStackTrace();
						
					}
			
		}
		
		
		
		       //Delete from tbl_utilpendingpushNotification
				public static void deleteFromPendingPushNotification(String strPendingNotificationID)
				{
					
					Connection  conn;
					
					try{
					 String url = ServerBE.strDatabaseURl;
					// String url = "jdbc:mysql://Localhost:3306/isp_utildatabase_dev";  
			         Class.forName (ServerBE.strDriver);
			         conn = DriverManager.getConnection (url,ServerBE.strUserName,ServerBE.strDBPassword);    
				     // PreparedStatement st = conn.prepareStatement("select * from tbl_utilevent");	         
			         PreparedStatement st=conn.prepareStatement("{call SP_DeleteFrompendingPushNotification(?)}");  
			         st.setString(1, strPendingNotificationID);
			         
				     st.execute();
				    // conn.commit();
				     conn.close();
				     
					}
					catch(Exception e)
					{
						e.printStackTrace();
						
					}			
				}
				
				
				//Method To Update Number OF Retries
				public static  void updateNumberOfRetries(int noOFretries, String strNotificationID, String strModifiedBy)
				{
					
					Connection  conn;
					
							try{
							 String url = ServerBE.strDatabaseURl;
							// String url = "jdbc:mysql://Localhost:3306/isp_utildatabase_dev";  
					         Class.forName (ServerBE.strDriver);
					         conn = DriverManager.getConnection (url,ServerBE.strUserName,ServerBE.strDBPassword);    
						     // PreparedStatement st = conn.prepareStatement("select * from tbl_utilevent");	         
					         PreparedStatement st=conn.prepareStatement("{call SP_UpdateNoOFRetriesPendingPush(?,?,?)}");  
					         st.setInt(1, noOFretries);
					         st.setString(2, strNotificationID);
					         st.setString(3, strModifiedBy);
						    // st.executeQuery();
						     st.execute();
						    // conn.commit();
						     conn.close();
						     
							}
							catch(Exception e)
							{
								
							}
					
				}

}
