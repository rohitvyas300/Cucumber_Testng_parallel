package tests.cucumber.steps;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import screens.*;
import tests.ThreadLocalDriver;

public class BaseSteps {
    //protected CandidateMainScreen candidateMainScreen = null;
    protected LoginScreen LoginScreen = null;
    protected WebDriverWait wait;

    //Screen Classes Initialization
    protected void setupCucumber () {
        System.out.println("Cucumber Base Test Before-login-test-cucumber");
        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);
        LoginScreen = new LoginScreen(ThreadLocalDriver.getTLDriver());
       // splashScreen = new SplashScreen(ThreadLocalDriver.getTLDriver());       

        /*//Unlock the device if it is locked.
        final Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("adb shell input keyevent 224");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    protected void teardown(){
        ThreadLocalDriver.getTLDriver().quit();
    }
}
