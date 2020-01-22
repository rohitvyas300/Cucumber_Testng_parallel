package tests.cucumber.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import screens.LoginScreen;
import tests.ThreadLocalDriver;

public class LoginSteps extends BaseSteps {

    //Instantiations
    
    LoginScreen loginScreen;
    //MyProfileScreen myProfileScreen;

    //Screen Classes Initialization
    @Before
    public void setupLoginSteps () {
        System.out.println("Cucumber Before-login-test-cucumber");
        setupCucumber();
       // profileLoginScreen = new CandidateLoginScreen(ThreadLocalDriver.getTLDriver());
        loginScreen = new LoginScreen(ThreadLocalDriver.getTLDriver());        
    }

   
    @And("^I click on Enter Number textbox$")
    public void iClickGirisYapButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginScreen.clickOnEnterNumberField();
    }

    @And("^I fill \"([^\"]*)\" as my telephone number$")
    public void iFillAsMyTelephoneNumber(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginScreen.enterPhoneNumber(arg0);
    }

   
@When("^I am on login screen$")
public void i_am_on_login_screen() throws Throwable {	
	loginScreen.onLoginScreen();
} 


@When("^I am on login screen after reset app$")
public void i_am_on_login_screen_after_reset_app() throws Throwable {
	loginScreen.onLoginScreen();
} 


@When("^I enter \"([^\"]*)\" number$")
public void i_enter_number(String number) throws Throwable {		
	 loginScreen.enterPhoneNumber(number);
}


@Then("^Alert popup should be disaply as Please enter a valid Idea number$")
public void alert_popup_should_be_disaply_as_Failure_in_Vodafone_system() throws Throwable {
	loginScreen.validIdeaNumberPopup();
}


@Then("^User should not able to login$")
public void user_should_not_able_to_login() throws Throwable {
	//keyword.NavigateBack();
	loginScreen.userShouldNotAbleToLogin();
}

@When("^User should click on cancel icon and verify textbox is empty$")
public void User_should_click_on_cancel_icon_and_verify_textbox_is_empty () throws Throwable {
	loginScreen.clickOnCancelIcon();
}

@Then("^I should see Skip heading on onboarding screen$")
public void i_should_see_Skip_heading_on_dashboard_screen() throws Throwable {
	loginScreen.seeSkipHeadingOnDashboard();
}

@Then("^I should see onboarding screen$")
public void I_should_see_onboarding_screen() throws Throwable {
	loginScreen.seeOnboardingScreen();
}

    
    
}
