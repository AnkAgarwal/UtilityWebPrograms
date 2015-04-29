package com.ngi.pushserver;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javapns.Push;
import javapns.communication.exceptions.CommunicationException;
import javapns.communication.exceptions.KeystoreException;
import javapns.notification.PushNotificationPayload;

import org.apache.log4j.BasicConfigurator;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Sender;
import com.ngi.configuration.ReadConfiguration;
import com.ngi.pushserverBE.ServerBE;
import com.ngi.pushserverDAL.ServerDAL;
import com.ngi.util.Util;

public class Serverpush {

	/**
	 * @param args
	 */

	static HashMap<String, String> objHashMapServerDetails=new HashMap<String, String>();
	static ArrayList<HashMap< String, String>> objarrayListHashMap;
	public static String strAndroidPushValue="";


	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		ArrayList<ServerBE> objarrayListDetails=null;
		ServerBE objServerBE=null;


		HashMap<String, String>	hmAction=new HashMap<String, String>();
		objarrayListHashMap=new ArrayList<HashMap< String, String>>();

		/*********Get Config Parameters***********/
		objHashMapServerDetails=ReadConfiguration.readParameter(ServerBE.strURlParameters,ServerBE.strDataBaseNameParam,ServerBE.strDBUsernameParam,ServerBE.strPassWordparam,ServerBE.strNoOFRetriesParam, ServerBE.strAndroidSenderID, ServerBE.strpartnerappKeyStore,ServerBE.struserAppKeyStore, ServerBE.isAppTypeProduction);					
		Util.getConfigParameters(objHashMapServerDetails);



//*************
	//	sendPushToIOSDevice("Hii...Linx Test push...","Keystore/LinxDevelopKeyStoreApril.p12","linxpush",false,"9f9cb20d1c7e3362096ada7c4d9b94bfe423c631424ab168f2b3776390d1bc18");
		
		//For testing purpose only 
		
		/*ServerBE objServerBEe=new ServerBE();
		sendPushToAndroidDevices(objServerBEe);*/
		//****************


		/*******Call to get Push Details From database***********/
		objarrayListDetails=ServerDAL.getNotificationDetails();	
		for(int index=0;index<objarrayListDetails.size();index++){

			objServerBE=objarrayListDetails.get(index);


			//getBarName on the behalf of barID
			//String strBarName=ServerDAL.getBarName(objServerBE.getStrBarID());


			//add addition information into hash map and sended with push

			hmAction.put(ServerBE.keyBookingID,objServerBE.getStrBookingID());
			hmAction.put(ServerBE.keyEventCode,objServerBE.getStrEventCode());
			//					 hmAction.put(ServerBE.keyBarID, ServerBE.strBarID);
			//					 hmAction.put(ServerBE.keyBarName,strBarName);

			objarrayListHashMap.add(hmAction);
			strAndroidPushValue=Util.getJsonInputFiled(hmAction);

			//					 sendPushToAndroidDevices();

			//					 sendPushToIOSDevice("User App Test Push!", "Keystore/6Nov_UserAppDemoPush.p12", "apple101", true, "7876e1d88f626d26d9f51f09d17d4d96d41b4197d15b1e4c4081f08273c84199");


			if(objServerBE.getStrDeviceDecription().trim().equalsIgnoreCase(ServerBE.strDeviceTypeAndroid))
			{					 
				//Parse Event Message
				if(objServerBE.getStrPersonalizedMessage()!=null){

					objServerBE.setStrEventMessage(Util.getEventMessage(objServerBE.getStrPersonalizedMessage(), objServerBE.getStrEventMessage()));
				}
				//Call To send Push Notification on Android Device
				sendPushToAndroidDevices(objServerBE);						
				if(ServerBE.isSuccess)
				{						
					int noOFRetries=Integer.parseInt(objServerBE.getStrNumberOfRetries());


					/*********Insert into sentpushnotification Table**********/
					ServerDAL.insertIntoSentPushNotification(objServerBE,ServerBE.strResponseCode,
							ServerBE.strNotificationstatus,noOFRetries+1,ServerBE.isNotificationsentToDefaultUser);

					/**********Delete From tbl_pendingpushNotification*************/
					ServerDAL.deleteFromPendingPushNotification(objServerBE.getStrPendingNotificationID());

				}
				else{
					int noOFRetries=Integer.parseInt(objServerBE.getStrNumberOfRetries());
					if(noOFRetries>=ServerBE.maximumRetriesSize)
					{

						ServerBE.strNotificationstatus="0";
						/*********Insert into sentpushnotification Table**********/

						ServerDAL.insertIntoSentPushNotification(objServerBE,ServerBE.strResponseCode,
								ServerBE.strNotificationstatus,noOFRetries,ServerBE.isNotificationsentToDefaultUser);

						/************Delete From tbl_pendingpushNotification************/
						ServerDAL.deleteFromPendingPushNotification(objServerBE.getStrPendingNotificationID());

					}
					else{									  
						/************Call Method to Update NumberOFREtries***************/
						//ServerDAL.updateNumberOfRetries(noOFRetries+1,objServerBE.getStrPendingNotificationID(),
							//	objServerBE.getStrUserID());

						  for(int size=noOFRetries; size<4;size++)
						  {
							sendPushToAndroidDevices(objServerBE);
							if(ServerBE.isSuccess)
							{				


								/*********Insert into sentpushnotification Table**********/
								ServerDAL.insertIntoSentPushNotification(objServerBE,ServerBE.strResponseCode,
										ServerBE.strNotificationstatus,size+1,ServerBE.isNotificationsentToDefaultUser);

								/**********Delete From tbl_pendingpushNotification*************/
								ServerDAL.deleteFromPendingPushNotification(objServerBE.getStrPendingNotificationID());
								
								break;
							}
							
							else{
								
								if(size==3){
								ServerBE.strNotificationstatus="0";
								/*********Insert into sentpushnotification Table**********/

								ServerDAL.insertIntoSentPushNotification(objServerBE,ServerBE.strResponseCode,
										ServerBE.strNotificationstatus,5,ServerBE.isNotificationsentToDefaultUser);

								/************Delete From tbl_pendingpushNotification************/
								ServerDAL.deleteFromPendingPushNotification(objServerBE.getStrPendingNotificationID());
								}
							}
							
						  }

					}

				}

			}



			//					sendPushToAndroidDevices();



			//	 sendPushToIOSDevice("User App Push Made by Kunwar!","Keystore/PartnerApp_AppStorePush.p12","Apple101",true,"73d7d0c318cad05751c30d8bc0e2e00c5260e226542120eacddf900318b9cb6d");						

			else if(objServerBE.getStrDeviceDecription().trim().equalsIgnoreCase(ServerBE.strDeviceTypeIOS))
			{

				/********Get push Message to be send********/
				if(objServerBE.getStrPersonalizedMessage()!=null){

					objServerBE.setStrEventMessage(Util.getEventMessage(objServerBE.getStrPersonalizedMessage(), objServerBE.getStrEventMessage()));
				}
				
				if(objServerBE.getStrAppCode().trim().equalsIgnoreCase("PartnerApp"))
				{
					// strKeyStoreCertificate="Keystore/partnerApppushKeyStore.p12";
					ServerBE.strKeyStoreCertificate=ServerBE.strPartnerAppKeyStore;   

				}
				else{
					ServerBE.strKeyStoreCertificate=ServerBE.strUserAppKeyStore;

				}
				/**********CAll Method to send ios push Notification****************/
				sendPushToIOSDevice(objServerBE.strEventMessage,ServerBE.strKeyStoreCertificate,ServerBE.strPassword,ServerBE.isProduction,objServerBE.getStrDeviceID());
				if(ServerBE.isSuccess)
				{

					int noOFRetries=Integer.parseInt(objServerBE.getStrNumberOfRetries());	
					/*********Insert into sentpushnotification Table**********/
					ServerDAL.insertIntoSentPushNotification(objServerBE,ServerBE.strResponseCode,
							ServerBE.strNotificationstatus,noOFRetries,ServerBE.isNotificationsentToDefaultUser);

					/*********Delete from pending Push Notification***********/
					ServerDAL.deleteFromPendingPushNotification(objServerBE.getStrPendingNotificationID());

				}
				else{
					int noOFRetries=Integer.parseInt(objServerBE.getStrNumberOfRetries());
					if(noOFRetries>=ServerBE.maximumRetriesSize)
					{

						ServerBE.strNotificationstatus="0";
						/*********Insert into sentpushnotification Table**********/
						ServerDAL.insertIntoSentPushNotification(objServerBE,ServerBE.strResponseCode,
								ServerBE.strNotificationstatus,noOFRetries,ServerBE.isNotificationsentToDefaultUser);

						/*********Delete from pending Push Notification***********/
						ServerDAL.deleteFromPendingPushNotification(objServerBE.getStrPendingNotificationID());


					}
					else{
						
						 for(int size=noOFRetries; size<4;size++)
						  {
							 sendPushToIOSDevice(objServerBE.strEventMessage,ServerBE.strKeyStoreCertificate,ServerBE.strPassword,ServerBE.isProduction,objServerBE.getStrDeviceID());
								
							if(ServerBE.isSuccess)
							{		
								
								/*********Insert into sentpushnotification Table**********/
								ServerDAL.insertIntoSentPushNotification(objServerBE,ServerBE.strResponseCode,
										ServerBE.strNotificationstatus,size+1,ServerBE.isNotificationsentToDefaultUser);

								/*********Delete from pending Push Notification***********/
								ServerDAL.deleteFromPendingPushNotification(objServerBE.getStrPendingNotificationID());

								
								break;
							}
							
							else{
								
								if(size==3){
								
									ServerBE.strNotificationstatus="0";
									/*********Insert into sentpushnotification Table**********/
									ServerDAL.insertIntoSentPushNotification(objServerBE,ServerBE.strResponseCode,
											ServerBE.strNotificationstatus,5,ServerBE.isNotificationsentToDefaultUser);

									/*********Delete from pending Push Notification***********/
									ServerDAL.deleteFromPendingPushNotification(objServerBE.getStrPendingNotificationID());

								}
							}
							
						  } 
						
						   

						/***********Call Method to Update NumberOFREtries*************/
						//ServerDAL.updateNumberOfRetries(noOFRetries+1,objServerBE.getStrPendingNotificationID(),objServerBE.getStrUserID());
					}

				}

			}
		}


	}


	//Method to send Ios Push Notification
	public static void sendPushToIOSDevice( String strMesasage, String strKeyStore, String strPassword, boolean isProduction, String strTokenID)
	{

		BasicConfigurator.configure();
		try {
			PushNotificationPayload payload = PushNotificationPayload.complex();

			try {
				payload.addAlert(strMesasage);
				payload.addCustomDictionary(ServerBE.keyAction, objarrayListHashMap);
			} catch (Exception e) {
				// TODO: handle exception
				ServerBE.strResponseCode=e.toString();
			}
			Push.payload(payload, new File(strKeyStore), strPassword, isProduction, strTokenID);

			//=================
			ServerBE.isSuccess=true;				
		} catch (CommunicationException e) {
			// TODO Auto-generated catch block
			ServerBE.isSuccess=false;
			ServerBE.strResponseCode=e.toString();
			e.printStackTrace();
		} catch (KeystoreException e) {
			// TODO Auto-generated catch block
			ServerBE.isSuccess=false;
			e.printStackTrace();
			ServerBE.strResponseCode=e.toString();
		}


	}



	//Method to send Android Push notification
	public static void sendPushToAndroidDevices(ServerBE objServerBE)
	{

		try {

			Sender sender = new Sender(ServerBE.strSenderID.trim());  //AIzaSyCCHIqwINskdVGRMp5851rgBFiMyj2wqxs
			ArrayList<String> devicesList = new ArrayList<String>();	
			devicesList.add(objServerBE.getStrDeviceID().trim());
			Message message = new Message.Builder().collapseKey("1").timeToLive(3).delayWhileIdle(true).addData(ServerBE.keyMessage,objServerBE.getStrEventMessage()).addData(ServerBE.keyAction,strAndroidPushValue).build();
			
			//For testing purpose only
			
			/*Sender sender = new Sender("AIzaSyB1HVD35NSqZ8Dr7w5zSkYX3-VMNiNd-N0");  //AIzaSyCCHIqwINskdVGRMp5851rgBFiMyj2wqxs
			ArrayList<String> devicesList = new ArrayList<String>();	
			devicesList.add("APA91bGdCC9YjnJdYtSvBYC68UgvHVclfHP6i-Xkk-eMrfT4ud3t_nKBVArIsu1vtjOnUvg1NgfUu3sqowxKmGFcbZciSzSvBG3DsTAQzWo47Mpg4gWPutsN8_KVifSqagHr4AgrSvfM");
			Message message = new Message.Builder().collapseKey("1").timeToLive(3).delayWhileIdle(true).addData("message","Hi hello").build();

*/
			//tab
			//			devicesList.add("APA91bEVbZ4YI97wvi7-yVSCHoK0q7Ixj1D_57oKiP2gFzsd8Q6pBDJywB--Jl7OCaq-C2x4rtkwANwIIcquvzdYE5oJSklN6hCLvOcXKi44RDb_Evf5YmmD3K1JkSMwiJyAJzduRIj-jGFmLytS_2nxz33lX77w1zgbLMm5dsvhg27z0GkHszo");

			//		
					


			// Use this for multicast messages
			MulticastResult result = sender.send(message, devicesList, 1);
			sender.send(message, devicesList, 1);
			System.out.println(result.toString());

			int i=result.getFailure();
			int j=result.getSuccess();

			if(i==1)
			{
				ServerBE.isSuccess=false;

				try{
					String strerorCode=result.toString().substring(result.toString().indexOf("[[")+2);
					System.out.println(strerorCode.replace("]]", ""));
					ServerBE.strResponseCode=strerorCode.replace("]]", "").trim();
				}catch(Exception e){

					e.printStackTrace();
				}

			}
			else{
				ServerBE.isSuccess=true;

			}

			if (result.getResults() != null) {
				int canonicalRegId = result.getCanonicalIds();
				if (canonicalRegId != 0) {
				}

			}
			else {
				int error = result.getFailure();
				ServerBE.strResponseCode="Error";
				System.out.println(error);
				//System.out.println("sumit");
			}
		} catch (Exception e) {
			ServerBE.isSuccess=false;
			ServerBE.strResponseCode=e.toString();
			e.printStackTrace();
		}	
		
	}


}
