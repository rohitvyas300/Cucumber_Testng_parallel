package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utilities.PropertiesAndConstants;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.aop.ThrowsAdvice;

import java.awt.Dimension;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.testng.Assert;

public class BaseScreen {

    protected AppiumDriver driver;
    protected WebDriverWait wait;
    
    
    public void scrollup(String locatorName) throws IOException,InterruptedException {
    	String OS = (String) PropertiesAndConstants.Deviceinfo.get("APP_TYPE");
    	
    	// calculate coordinates for vertical swipe
    				org.openqa.selenium.Dimension size = PropertiesAndConstants.Appium.manage().window().getSize();
    				int startVerticalY = (int) (size.height * 0.8);
    				//System.out.println(startVerticalY + " startVerticalY");
    				int endVerticalY = (int) (size.height * 0.21);
    				//System.out.println(endVerticalY+ "  endVerticalY");
    				int startVerticalX = (int) (size.width / 2.1);
    				//System.out.println(startVerticalX + " startVerticalX");
    				if(OS.contains("MOBILE ANDROID NATIVE"))
    				{
    					boolean isElementFound = PropertiesAndConstants.Appium.findElements(By.xpath(PropertiesAndConstants.Repository.getProperty(locatorName))).size() > 0;	
    					int scrollCount = 1;
						while (isElementFound == false && scrollCount <= 10) 
    					{				
    						TouchAction action = new TouchAction(PropertiesAndConstants.Appium);
    						action.press(PointOption.point(startVerticalX,endVerticalY))
    						.waitAction(new WaitOptions().withDuration(Duration.ofMillis(10))) //you can change wait durations as per your requirement
    						.moveTo(PointOption.point(startVerticalX,startVerticalY-5))
    						.release()
    						.perform();	

    						isElementFound = PropertiesAndConstants.Appium.findElements(By.xpath(PropertiesAndConstants.Repository.getProperty(locatorName))).size() > 0;
    						scrollCount++;	

    					}// End of while
						
						if(isElementFound == true  && scrollCount <= 10)
						{
							System.out.println("--------------------");
							//captureLogs("Scrolled down till element sucessful ", locatorName, " - Pass");					
						}
						else
						{
							//captureLogs("Scrolled down till element Failed ", locatorName, " - Fail");															
							Assert.fail("Failed to preceed scroll down ");
						}	
    				}
		
	}//EOD of Method Scroll bottom

    public BaseScreen (AppiumDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
    }

    
     
    protected void waitAndClick (By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    protected void click (By by) {
        waitVisibility(by);
        driver.findElement(by).click();
    }

    protected void hideKeyboard(){
        driver.navigate().back();
    }
    
    protected void appReset(){
    	driver.resetApp();
    	
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected List<WebElement> waitAndFindElements (By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    protected WebElement waitAndFindElement (By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected String getText(By by) {
        return waitAndFindElement(by).getText();
    }

    protected void sendText (By by, String text) {
         waitAndFindElement(by).sendKeys(text);
    }

    protected void assertEquals (String actual, String expected) {
        Assert.assertEquals(actual,expected, "Two texts are not equal!" + "Actual: " + actual + " Expected: " + expected);
    }

    protected void waitVisibility (By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    protected void sleep (long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
    }
}
