package tests.cucumber.Runner;


import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
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



@CucumberOptions(
		 monochrome = true,  
        tags = "@Candidate",
        features = "src/test/java/tests/cucumber/features/LoginCandidate.feature",
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

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {    	
    	System.out.println("afret class teardown...");
        testNGCucumberRunner.finish();                
    }
    
    

}
