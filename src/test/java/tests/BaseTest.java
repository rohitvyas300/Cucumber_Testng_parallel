	package tests;

import java.io.IOException;
import java.net.URL;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.StaticApplicationContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import screens.LoginScreen;
import utilities.PropReader;
import utilities.PropertiesAndConstants;

public class BaseTest {

    public static WebDriverWait wait;
    //private ThreadLocalDriver threadLocalDriver = new ThreadLocalDriver();
    //Base Screens for all cases    
    //protected CandidateMainScreen candidateMainScreen = null;
    protected static LoginScreen LoginScreen = null;

    
 //@Parameters({"deviceName"})
//    public void setup (String deviceName) throws IOException {
//       // System.out.println("TestNG Before");
        
        //String applicationType = UtilityFunctions.getEnvKeyValue("APP_TYPE");

        //Unlock the device if it is locked.
        //final Runtime rt = Runtime.getRuntime();
        //rt.exec("adb shell input keyevent 224");
        
//        {
//
//			DesiredCapabilities  capabilities = new DesiredCapabilities();
//			  capabilities.setCapability("Capability_Username","rohitv@iprogrammer.com"); //username used for loging to m1
//			  capabilities.setCapability("Capability_ApiKey","crysw3jb36jvdymyz7zq3gzk");//password used for loging to m1
//			  capabilities.setCapability("Capability_ApplicationName", "Android_debug_TestIP_Prod_09_Jan_2020.apk");
//			  capabilities.setCapability("Capability_DurationInMinutes", 60); 
//			  capabilities.setCapability("Capability_DeviceFullName",deviceName);         
//			  capabilities.setCapability("appPackage", "com.ideacellular.myidea");
//			  capabilities.setCapability("appActivity","com.ideacellular.myidea.MainActivity");
//			  capabilities.setCapability("newCommandTimeout", 600);
//			  capabilities.setCapability("launchTimeout", 90000);
//			  capabilities.setCapability("unicodeKeyboard", true);
//			  capabilities.setCapability("resetKeyboard", true);
//			   capabilities.setCapability("systemPort", new Random().nextInt(100)+1024);
//			  capabilities.setCapability("automationName", "UiAutomator2");	 	  
//        ThreadLocalDriver.setTLDriver(new AndroidDriver<WebElement>(new URL("https://qkm1vil.qualitykiosk.com/appiumcloud/wd/hub"), capabilities));
        
        //wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);
       
        //Base Screen Initialization
       // LoginScreen = new LoginScreen(ThreadLocalDriver.getTLDriver());
       // splashScreen = new SplashScreen(ThreadLocalDriver.getTLDriver());        
//        }
//        }

    @BeforeMethod
    public void SwitchDriver() throws Exception
    {
    	String s = (String) PropertiesAndConstants.Deviceinfo.get("APP_TYPE");
    	
    	switch(s)
    	{
    	case "MOBILE ANDROID NATIVE":
        {	      
        	System.out.println("In a switch cases");
        	System.out.println("inside android native...");
        	
        	System.out.println("inside android native...");
        	
        	DesiredCapabilities capabilities = new DesiredCapabilities();
        	capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
			capabilities.setCapability(MobileCapabilityType.UDID,PropertiesAndConstants.Deviceinfo.get("DEVICEID"));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,PropertiesAndConstants.Deviceinfo.get("PLATFORMVERSION"));
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,PropertiesAndConstants.Deviceinfo.get("DEVICENAME"));
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
			capabilities.setCapability("appPackage", "com.ideacellular.myidea");
	        capabilities.setCapability("appActivity", "com.ideacellular.myidea.MainActivity");
	        System.out.println("Ujjwal shitole -----------------------");
	        capabilities.setCapability("app", PropertiesAndConstants.Deviceinfo.get("APK_IPA_Path"));
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "120");
	        capabilities.setCapability("browserName", "");
	        capabilities.setCapability("noReset", "true");
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
	        capabilities.setCapability(MobileCapabilityType.NO_RESET, "false");
	        capabilities.setCapability("deviceReadyTimeout", "300");
	        capabilities.setCapability("appWaitDuration", "15000");	            	        
		    System.out.println("Please wait:- Connecting to Mobile...");
		    //PropertiesAndConstants.Appium = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		    
		    ThreadLocalDriver.setTLDriver(new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities));
            //PropertiesAndConstants.Selenium = (WebDriver)PropertiesAndConstants.Appium;	                                                                     
            wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(),1);
            //Base Screen Initialization
            LoginScreen = new LoginScreen(ThreadLocalDriver.getTLDriver());
            // splashScreen = new SplashScreen(ThreadLocalDriver.getTLDriver());
	        }
//    	case "MOBILE IOS NATIVE":
//        {	           
//        	System.out.println("inside iOS native...");
//        	DesiredCapabilities capabilities = new DesiredCapabilities();
//			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
//			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,PropertiesAndConstants.envDictionary.get("DEVICEID"));
//			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,PropertiesAndConstants.envDictionary.get("PLATFORMVERSION"));
//			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
//			//capabilities.setCapability("app", PropertiesAndConstants.CurrentDirectory +"/Drivers/"+PropertiesAndConstants.envDictionary.get("APK_IPA_Path"));
//			//capabilities.setCapability(MobileCapabilityType.APP, PropertiesAndConstants.CurrentDirectory +"/Drivers/"+PropertiesAndConstants.envDictionary.get("APK_IPA_Path"));
//			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "120");
//	        //capabilities.setCapability("browserName", "");
//	        //capabilities.setCapability("noReset", "true");
//			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
//	        capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
//	        //capabilities.setCapability("deviceReadyTimeout", "300");
//	        capabilities.setCapability("appWaitActivity", "com.ideacellular.myidea.MainActivity");
//	        capabilities.setCapability("appWaitDuration", "15000");	            	        
//		    System.out.println("Please wait:- Connecting to Mobile...");
//		     //PropertiesAndConstants.Appium = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//		    ThreadLocalDriver.setTLDriver(new AndroidDriver<WebElement>(new URL("https://qkm1vil.qualitykiosk.com/appiumcloud/wd/hub"), capabilities));
//	        
//	        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);
//	       
//	        //Base Screen Initialization
//	           
//	        }
    	}
    }
    
   

    @AfterMethod
    public synchronized void teardown(){
    	System.out.println("Tesng after");
        ThreadLocalDriver.getTLDriver().quit();
    }

    
    
}//EOD class