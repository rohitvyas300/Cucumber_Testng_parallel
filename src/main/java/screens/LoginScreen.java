package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utilities.PropertiesAndConstants;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen {
    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }

    //New Mobile Elements
    
    
    
    String loginButton = "com.isinolsun.app:id/login";
    String NewEnterNumberfield = "//android.widget.EditText[@text='Enter your mobile number']";
    String termsandcondiion = "//android.widget.TextView[@text='I accept all the terms and conditions']";
    
    String msidenislocked_msg =  "//android.widget.TextView[@text='Msisdn is Locked,Try after some time (AOL0014)']";
    String Skip = "//android.widget.TextView[@text='Skip']";
    String plzentervalidnum="//android.widget.TextView[@text='Please enter a valid Idea number!']";
    String resend_btn="//android.widget.TextView[@text='Re-send']";
    String crossbar_num= "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView";
    String s1= (String) PropertiesAndConstants.Repository.get("NewEnterNumberfield");    


    public void enterPhoneNumber (String cellPhoneNumber) throws InterruptedException {
    	
    	System.out.println("inside ... enterPhoneNumber");
    	
//     	boolean allow_btn = isElementPresent(By.id(allowbtn_ideacontacts));
//    	if (allow_btn == true) {
//    		waitAndClick(By.id(allowbtn_ideacontacts));
//		} 
    	Thread.sleep(10000);

    	
    	 sendText((By)(By.xpath((String) PropertiesAndConstants.Repository.get("NewEnterNumberfield"))), cellPhoneNumber);
        System.out.println("Number Entered Successfully");
    }

    
    
    
    
    
    public void clickLogin () throws InterruptedException {
    	System.out.println("inside .... click login...");
    	
    	waitAndClick(By.xpath(loginButton));
    	Thread.sleep(30000);    	
    	//appReset();    
    }
    
    public void clickOnEnterNumberField() {
    	System.out.println("I am in EnterNumberMethod");
    	//waitAndClick(By.xpath(EnterNumberfield));
    	waitAndClick((By) (PropertiesAndConstants.Repository.get("NewEnterNumberfield")));
	}
    
 public void onLoginScreen () throws InterruptedException { 
	 //System.out.println("Inside ON-LOGIN-----");
	 //System.out.println(loginButton);
	 //System.out.println(NewEnterNumberfield);
	 //System.out.println(By.xpath(s1));
	
	 //System.out.println(allowbtn_ideacontacts);
	 System.out.println("allowbtn_ideacontacts");
	 waitAndClick(By.id((String) PropertiesAndConstants.Repository.get("allowbtn_ideacontacts")));
	  //waitAndClick(By.id(allowbtn_ideacontacts));
	    System.out.println("Click On Allow Button ");
	    Thread.sleep(2000);
	   
	    //By str = (By) PropertiesAndConstants.Repository.get(NewEnterNumberfield);
	   // System.out.println(str);
	   // waitAndClick( (By.xpath((By)((String) PropertiesAndConstants.Repository.get("NewEnterNumberfield")))));  
    System.out.println("On Login Completed");   
 }
 
 public void seeSkipHeadingOnDashboard() {
	 
	 boolean installupdate_msidn =  isElementPresent(By.xpath(msidenislocked_msg));
	 if(installupdate_msidn == true)
		{
		//  waitAndClick(By.xpath(EnterNumberfield));
		  //sendText(By.xpath(EnterNumberfield), "9921059355");			
		}
	 	String skip = getText(By.xpath(Skip));
	    assertEquals("Skip", skip);	
}
 
 
 public void seeOnboardingScreen() {
	// boolean allow_btn = isElementPresent(By.id(allowbtn_ideacontacts));	
		// assertTrue(allow_btn);
}
 
 public void validIdeaNumberPopup() {
	 String validnum = getText(By.xpath(plzentervalidnum));
	    assertEquals("Please enter a valid Idea number!", validnum);	
}
 
public void userShouldNotAbleToLogin() {
	boolean resendButton =  isElementPresent(By.xpath(resend_btn));
	assertFalse(resendButton);
	
}

public void clickOnCancelIcon() {
	waitAndClick(By.xpath(crossbar_num));
	//boolean Enternum =  isElementPresent(By.xpath(EnterNumberfield));
	//assertTrue(Enternum);	
}


}
