package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginScreen extends BaseScreen {
    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    //Mobile Elements
    String telephoneNumber = "com.isinolsun.app:id/login_phone_number";
    String loginButton = "com.isinolsun.app:id/login";
    String EnterNumberfield = "//android.widget.EditText[@text='Enter your mobile number']";
    String termsandcondiion = "//android.widget.TextView[@text='I accept all the terms and conditions']";
    String allowbtn = "com.android.packageinstaller:id/permission_allow_button";



    public void enterPhoneNumber (String cellPhoneNumber) {
        //sendText(By.id(telephoneNumber), cellPhoneNumber);
    	waitAndClick(By.id(allowbtn));
    	sendText(By.xpath(EnterNumberfield), cellPhoneNumber);
        //hideKeyboard();
    }

    public void clickLogin () throws InterruptedException {
        //waitAndClick(By.id(loginButton));
    	waitAndClick(By.xpath(termsandcondiion));
    	Thread.sleep(30000);
    	//appReset();
    
    }


}
