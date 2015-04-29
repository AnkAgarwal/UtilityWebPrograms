package com.ngi.pushserverBE;


public class ServerBE {
	
	
	
	//Android Info
	//public static String strSenderID="AIzaSyD2D6JG3_tBkYZYx8tA0YE8RxdgeYiCIRM";
	public static String strSenderID="";
		//static String strDeviceID="APA91bG8ziiN8fWLiwA62IINh07TFr1RSm7wV1rvPI8zAmCS2aL5XTZxQPbnycx_qcIzWYh4fqP0maAFIUkzksUdMy_9M3wRlpK1D59zY3qg9rbR7rBrWA95shkCMiR73VxO2gBcwS7j7wIlowNNZnbKQhdspEpOPg";
	public static String strDeviceid="";
		
	public static String strMessageAndroid="Hello How are you!!";

	public static String strResponseCode="Sucess";
	
	
	public static String keyEventCode="EventCode";
	public static String keyBookingID="BookingID";
	public static String keyBarID="BarID";
	public static String keyAction="Action";
	public static String keyMessage="message";
	public static String keyBarName="BarName";
		
		//Ios Info
		//static String strKeyStoreCertificate="Keystore/pushKey.p12";
	public static String strKeyStoreCertificate="Keystore/pushKey.p12";
		//static String strPassword="Apple11"; user App password
	public static String strPassword="linxpush"; //partner App Password
	public static Boolean isProduction=true;
	public static String strMessageIOS="Hi..Test Push notification";
	public static String strTokenID="964e3d13c83fc92daf798f7ee5b476a6a2969f24efbf8e1b9d2e69b434c9903c";
	public static String strPartnerAppKeyStore="";
	public static String strUserAppKeyStore="Keystore/UserAppKeyStore.p12";
		
		//Device Type
	public static boolean isDeviceTypeAndroid=true;
	public static boolean isDeviceTypeIos=true;
		
		//DataBase details
		//testing minuteman server
		public static String strDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		
		//public static String strDatabaseURl="jdbc:mysql://206.190.151.68/instaparty_production";
		//public static String strDatabaseURl="jdbc:mysql://192.168.1.61/isp_utildatabase_dev";
		public static String strDatabaseURl="jdbc:mysql://192.168.1.61/";
		public static String strDatabaseName="isp_utildatabase_dev";
		public static String strUserName="ISP_DEV";
		//public static String strDBPassword="FEu22MuGs^";
		public static String strDBPassword="G4RAMM2d";
		public static String strDeviceTypeAndroid="ANDROID";
		public static String strDeviceTypeIOS="IOS";
		
		
		
		
		
		/*//PA Machine
		public static String strDriver="com.mysql.jdbc.Driver";
		public static String strDatabaseURl="jdbc:mysql://192.168.1.61:3306/ISP_DEV";
		public static String strDatabaseName="";
//		public static String strUserName="ISP_DEV";
//		public static String strDBPassword="G4RAMM2d";
		public static String strUserName="root";
		public static String strDBPassword="admin";*/
		
		
		
		
		public String strPendingNotificationID="";
		public String strUserID="";
		public String strDeviceID="";
		public String strAppCode="";
		public String strDeviceDecription="";
		public String strDefaultUserID="";
		public String strDefaultDeviceID="";
		public String strPersonalizedMessage="";
		public String strNoNotificationStartTime="";
		public String strNoNotificationDuration="";
		public String strBarTimeZoneCode="";
		public String strNumberOfRetries="";
		public String strEventCode="";
		public String strEventDesc="";
		public String strEventMessage="";
		public String strSubject="";
		public static String strMaximumNoOFRetries="";
		
		
		public String strPendingNotificationCreatedOn="04-03-2014";
		public String strPushNotificationDateTime="04-03-2014";
		public String getStrPendingNotificationCreatedOn() {
			return strPendingNotificationCreatedOn;
		}

		public void setStrPendingNotificationCreatedOn(
				String strPendingNotificationCreatedOn) {
			this.strPendingNotificationCreatedOn = strPendingNotificationCreatedOn;
		}

		public String getStrPushNotificationDateTime() {
			return strPushNotificationDateTime;
		}

		public void setStrPushNotificationDateTime(String strPushNotificationDateTime) {
			this.strPushNotificationDateTime = strPushNotificationDateTime;
		}

		public static String isNotificationsentToDefaultUser="1";
		public static String strNotificationstatus="1";
		
		public static String strPushMEssage="";
		
		public String strBarID="";
		public String strBookingID="";
		
		
		public String getStrPendingNotificationID() {
			return strPendingNotificationID;
		}

		public void setStrPendingNotificationID(String strPendingNotificationID) {
			this.strPendingNotificationID = strPendingNotificationID;
		}

		public String getStrUserID() {
			return strUserID;
		}

		public void setStrUserID(String strUserID) {
			this.strUserID = strUserID;
		}

		public String getStrDeviceID() {
			return strDeviceID;
		}

		public void setStrDeviceID(String strDeviceID) {
			this.strDeviceID = strDeviceID;
		}

		public String getStrAppCode() {
			return strAppCode;
		}

		public void setStrAppCode(String strAppCode) {
			this.strAppCode = strAppCode;
		}

		public String getStrDeviceDecription() {
			return strDeviceDecription;
		}

		public void setStrDeviceDecription(String strDeviceDecription) {
			this.strDeviceDecription = strDeviceDecription;
		}

		public String getStrDefaultUserID() {
			return strDefaultUserID;
		}

		public void setStrDefaultUserID(String strDefaultUserID) {
			this.strDefaultUserID = strDefaultUserID;
		}

		public String getStrDefaultDeviceID() {
			return strDefaultDeviceID;
		}

		public void setStrDefaultDeviceID(String strDefaultDeviceID) {
			this.strDefaultDeviceID = strDefaultDeviceID;
		}

		public String getStrPersonalizedMessage() {
			return strPersonalizedMessage;
		}

		public void setStrPersonalizedMessage(String strPersonalizedMessage) {
			this.strPersonalizedMessage = strPersonalizedMessage;
		}

		public String getStrNoNotificationStartTime() {
			return strNoNotificationStartTime;
		}

		public void setStrNoNotificationStartTime(String strNoNotificationStartTime) {
			this.strNoNotificationStartTime = strNoNotificationStartTime;
		}

		public String getStrNoNotificationDuration() {
			return strNoNotificationDuration;
		}

		public void setStrNoNotificationDuration(String strNoNotificationDuration) {
			this.strNoNotificationDuration = strNoNotificationDuration;
		}

		public String getStrBarTimeZoneCode() {
			return strBarTimeZoneCode;
		}

		public void setStrBarTimeZoneCode(String strBarTimeZoneCode) {
			this.strBarTimeZoneCode = strBarTimeZoneCode;
		}

		public String getStrNumberOfRetries() {
			return strNumberOfRetries;
		}

		public void setStrNumberOfRetries(String strNumberOfRetries) {
			this.strNumberOfRetries = strNumberOfRetries;
		}

		public String getStrEventCode() {
			return strEventCode;
		}

		public void setStrEventCode(String strEventCode) {
			this.strEventCode = strEventCode;
		}

		public String getStrEventDesc() {
			return strEventDesc;
		}

		public void setStrEventDesc(String strEventDesc) {
			this.strEventDesc = strEventDesc;
		}

		public String getStrEventMessage() {
			return strEventMessage;
		}

		public void setStrEventMessage(String strEventMessage) {
			this.strEventMessage = strEventMessage;
		}

		public String getStrSubject() {
			return strSubject;
		}

		public void setStrSubject(String strSubject) {
			this.strSubject = strSubject;
		}

		public String getStrMaximumNoOFRetries() {
			return strMaximumNoOFRetries;
		}

		public void setStrMaximumNoOFRetries(String strMaximumNoOFRetries) {
			this.strMaximumNoOFRetries = strMaximumNoOFRetries;
		}

		public String getStrBarID() {
			return strBarID;
		}

		public void setStrBarID(String strBarID) {
			this.strBarID = strBarID;
		}

		public String getStrBookingID() {
			return strBookingID;
		}

		public void setStrBookingID(String strBookingID) {
			this.strBookingID = strBookingID;
		}

		public static Boolean isSuccess=true;
		
		public static String strURlParameters="dataBase_url";
		public static String strDataBaseNameParam="dbName";
		public static String strDBUsernameParam="dataBase_userName";
		public static String strPassWordparam="database_password";
		public static String strNoOFRetriesParam="MaximumRetries";
		public static String strAndroidSenderID="androidSenderID";		
		public static int maximumRetriesSize=0;
		 public static String strpartnerappKeyStore="partnerAppKeyStore";
		  public static String struserAppKeyStore="userAppKeyStore";
		  public static String isAppTypeProduction="isAppProduction";
		  
		  public static String strDataBaseNamedev="dbName_dev";  
		
		
		
		

}
