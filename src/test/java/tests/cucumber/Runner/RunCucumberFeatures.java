package tests.cucumber.Runner;


import java.io.File;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import tests.BaseTest;
import utilities.PropReader;
import utilities.check_mail;

import java.util.Properties;

import javax.activation.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



@CucumberOptions(
		 monochrome = true,  
        tags = "@login",
        features = "src/test/java/tests/cucumber/features",
        glue = "tests.cucumber.steps",        
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/html/ExtentReport.html"}        		       
                )
public class RunCucumberFeatures extends  BaseTest {
	
	
	
	private static ExtentReports extent;
 
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        System.out.println("Cucumber Test Class Before");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        
        }
    
    
    

//    @Test(groups = "cucumber", description = "Runs LoginCandiate Feature", dataProvider = "features")
//    public void feature(CucumberFeatureWrapper cucumberFeature) {
//        System.out.println("Cucumber Test Class Inside Test");
//        System.out.println(cucumberFeature.getCucumberFeature());
//        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
//    }

    
   


	@Test(groups = "cucumber", description = "Runs LoginCandiate Feature", dataProvider = "scenarios")
    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable{
        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
    }
    
    
    
	@DataProvider
    public Object[][] scenarios() {
        //return testNGCucumberRunner.provideScenarios();
		System.out.println("Data Provider test Class");
    	 return testNGCucumberRunner.provideScenarios();
    }

    
//    @DataProvider
//    public Object[][] features() {
//        System.out.println("Data Provider test Class");
//        return testNGCucumberRunner.provideFeatures();
//    }

	
	@BeforeSuite(alwaysRun = true)
	public void BeforeSuit() throws Exception {

		PropReader.LoadDeviceData();
        System.out.println("Device data populated Sucess");
        
        PropReader.LoadObjectsRepository();
        System.out.println("Object Repository prepopulated");
    }
	
	
	
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {    	
    	System.out.println("afret class teardown...");
        testNGCucumberRunner.finish();        
    }
    
    @AfterSuite
    public void suitteardown() throws InterruptedException {
    	System.out.println("after suite teat down...");
    	//Thread.sleep(9000);
       // check_mail.Automail();	
	}
    
}//EOD class

