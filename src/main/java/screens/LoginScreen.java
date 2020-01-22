package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;

public class LoginScreen extends BaseScreen {
    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }

    //Mobile Elements
    String telephoneNumber = "com.isinolsun.app:id/login_phone_number";
    String loginButton = "com.isinolsun.app:id/login";
    String EnterNumberfield = "//android.widget.EditText[@text='Enter your mobile number']";
    String termsandcondiion = "//android.widget.TextView[@text='I accept all the terms and conditions']";
    String allowbtn_ideacontacts = "com.android.packageinstaller:id/permission_allow_button";
    String msidenislocked_msg =  "//android.widget.TextView[@text='Msisdn is Locked,Try after some time (AOL0014)']";
    String Skip = "//android.widget.TextView[@text='Skip']";
    String plzentervalidnum="//android.widget.TextView[@text='Please enter a valid Idea number!']";
    String resend_btn="//android.widget.TextView[@text='Re-send']";
    String crossbar_num= "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView";
    


    public void enterPhoneNumber (String cellPhoneNumber) {
        
    	System.out.println("inside ... enterPhoneNumber");
    	boolean allow_btn = isElementPresent(By.id(allowbtn_ideacontacts));
    	if (allow_btn == true) {
    		waitAndClick(By.id(allowbtn_ideacontacts));
		}    	    	
    	sendText(By.xpath(EnterNumberfield), cellPhoneNumber);
        
    }

    public void clickLogin () throws InterruptedException {
    	System.out.println("inside .... click login...");
    	
    	waitAndClick(By.xpath(termsandcondiion));
    	Thread.sleep(30000);    	
    	//appReset();    
    }
    
    public void clickOnEnterNumberField() {
    	waitAndClick(By.xpath(EnterNumberfield)); 
	}
    
 public void onLoginScreen () { 
	    waitAndClick(By.id(allowbtn_ideacontacts));
    	waitAndClick(By.xpath(EnterNumberfield));        
    }
 
 public void seeSkipHeadingOnDashboard() {
	 
	 boolean installupdate_msidn =  isElementPresent(By.xpath(msidenislocked_msg));
	 if(installupdate_msidn == true)
		{
		  waitAndClick(By.xpath(EnterNumberfield));
		  sendText(By.xpath(EnterNumberfield), "9921059355");			
		}
	 	String skip = getText(By.xpath(Skip));
	    assertEquals("Skip", skip);	
}
 
 
 public void seeOnboardingScreen() {
	 boolean allow_btn = isElementPresent(By.id(allowbtn_ideacontacts));	
		 assertTrue(allow_btn);
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
	boolean Enternum =  isElementPresent(By.xpath(EnterNumberfield));
	assertTrue(Enternum);	
}


}
