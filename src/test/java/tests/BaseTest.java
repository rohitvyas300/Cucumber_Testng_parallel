	package tests;

import java.io.IOException;
import java.net.URL;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.appium.java_client.android.AndroidDriver;
import screens.LoginScreen;

public class BaseTest {

    public WebDriverWait wait;
    //private ThreadLocalDriver threadLocalDriver = new ThreadLocalDriver();
    //Base Screens for all cases    
    //protected CandidateMainScreen candidateMainScreen = null;
    protected LoginScreen LoginScreen = null;

    @BeforeMethod
    @Parameters({"deviceName"})
    public void setup (String deviceName) throws IOException {
        System.out.println("TestNG Before");

        //Unlock the device if it is locked.
        //final Runtime rt = Runtime.getRuntime();
        //rt.exec("adb shell input keyevent 224");

			DesiredCapabilities  capabilities = new DesiredCapabilities();
			  capabilities.setCapability("Capability_Username","rohitv@iprogrammer.com"); //username used for loging to m1
			  capabilities.setCapability("Capability_ApiKey","crysw3jb36jvdymyz7zq3gzk");//password used for loging to m1
			  capabilities.setCapability("Capability_ApplicationName", "Android_debug_TestIP_Prod_09_Jan_2020.apk");
			  capabilities.setCapability("Capability_DurationInMinutes", 60); 
			  capabilities.setCapability("Capability_DeviceFullName",deviceName);         
			  capabilities.setCapability("appPackage", "com.ideacellular.myidea");
			  capabilities.setCapability("appActivity","com.ideacellular.myidea.MainActivity");
			  capabilities.setCapability("newCommandTimeout", 600);
			  capabilities.setCapability("launchTimeout", 90000);
			  capabilities.setCapability("unicodeKeyboard", true);
			  capabilities.setCapability("resetKeyboard", true);
			   capabilities.setCapability("systemPort", new Random().nextInt(100)+1024);
			  capabilities.setCapability("automationName", "UiAutomator2");	 	  
        ThreadLocalDriver.setTLDriver(new AndroidDriver<WebElement>(new URL("https://qkm1vil.qualitykiosk.com/appiumcloud/wd/hub"), capabilities));
        
        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);
       
        //Base Screen Initialization
        LoginScreen = new LoginScreen(ThreadLocalDriver.getTLDriver());
       // splashScreen = new SplashScreen(ThreadLocalDriver.getTLDriver());        
    }

    @AfterMethod
    public synchronized void teardown(){
    	System.out.println("Tesng after");
        ThreadLocalDriver.getTLDriver().quit();
    }

}//EOD class