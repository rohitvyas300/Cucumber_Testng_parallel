package tests;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class ThreadLocalDriver {

    //private static ThreadLocal<AndroidDriver> tlDriver = new ThreadLocal<>();
	private static ThreadLocal<AppiumDriver> tlDriver = new ThreadLocal<>();

    public synchronized static void setTLDriver(AndroidDriver driver) {
        tlDriver.set(driver);
    }

   // public synchronized static AndroidDriver getTLDriver() {
    public synchronized static AppiumDriver getTLDriver() {
        return tlDriver.get();
    }
}
