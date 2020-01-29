package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


	public class PropertiesAndConstants{							    			    
		public static Map<String, String> objFrames = new HashMap<String, String>();
	    public static Map<String, String> envDictionary = new HashMap<String, String>();
		public static String CurrentDirectory = System.getProperty("user.dir");;
		public static String Url;
		public static Properties TestData;	
		public static Properties Deviceinfo;
		public static WebDriver Selenium;
		public static AppiumDriver<MobileElement> Appium;
		public static String PrivateFarmAndroid;
		public static String PrivateFarmios;
		public static String PublicFarmAndroid;
		public static String PrivateFarmUploadedApps;
		public static Properties Repository;
		public static String ScenerioName;
		public static String Browser;		 
	 	public static String TempScreenshotPath;	     
	    public static String MainDriverWindowHandle;	     
	    public static Boolean IsFlashDisabled;
	 	public static String ReusableScriptPath;
		public static String finalScriptPath;	 	    
	    public static int JavaScriptErrorCount;
		public static String ScreenShotFullPath;		
		public static String CurrentRunReportFolder;
		public static String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a").format(Calendar.getInstance().getTime());				 	
		public static String DirectoryFilePath=".";
		public static String EvnFilePath;
		public static String core_balance;
		public static String calls;
		public static String pack_expiry;
		public static String total_data;
		public static String data_left_percent;
		public static String additional_packs;
		public static String balanceLeft;
		public static int serviceExpiryDays;
		public static String data_left; 
		public static int highest_pack_validity;
		public static String deviceName;
		public static String applicationType="MOBILE ANDROID NATIVE";
}
