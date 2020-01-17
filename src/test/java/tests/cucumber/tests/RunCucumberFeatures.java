package tests.cucumber.tests;


import java.io.File;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;

//import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import tests.BaseTest;	


@CucumberOptions(        
        tags = "@Candidate",
        features = "src/test/java/tests/cucumber/features/LoginCandidate.feature",
        glue = "tests.cucumber.steps",
        //plugin = { "pretty", "html:target/cucumber-reports" },
        //plugin="com.cucumber.listener.ExtentCucumberFormatter:Reports/html/ExtentReport.html",        	
      // plugin = {"com.cucumber.listener.ExtentCucumberFormatter:Reports/html/ExtentReport.html"},
        		// plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","html:Reports/html/ExtentReport.html"},
        monochrome = true
                )
public class RunCucumberFeatures extends  BaseTest {

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
    	
    	CucumberResultsOverview results = new CucumberResultsOverview();
    	results.setOutputDirectory("/Users/macbook/Documents/Appium/appium-cucumber-testng-parallel-testing/Reports/html");
    	results.setOutputName("cucumber-results");
    	results.setSourceFile("/Users/macbook/Documents/Appium/appium-cucumber-testng-parallel-testing/target/cucumber-reports/CucumberTestReport.json");
    	results.executeFeaturesOverviewReport();
    	
//    	Reporter.loadXMLConfig(new File("/Users/macbook/Documents/Appium/appium-cucumber-testng-parallel-testing/Config/extent-config.xml"));
//		Reporter.setSystemInfo("User Name", "RV");
//		Reporter.setSystemInfo("Application Name", "Test App ");
//		Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
//		Reporter.setSystemInfo("Environment", "stage");
//		Reporter.setTestRunnerOutput("Test Execution Completed");
    	
        testNGCucumberRunner.finish();
    }

}
