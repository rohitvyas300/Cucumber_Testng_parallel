package screens;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class CandidateLoginScreen extends BaseScreen {

    public CandidateLoginScreen(AndroidDriver driver) {
        super(driver);
    }

    //Mobile Elements
    String loginButton = "com.isinolsun.app:id/login";

    public void clickLogin () {
        waitVisibility(By.id(loginButton));
        click(By.id(loginButton));
    }


}
