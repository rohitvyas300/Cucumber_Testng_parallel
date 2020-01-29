Feature: Login Screen
Description: The purpose of this feature is to test the login functionality
 
@login
Scenario: Verify cross number error message
       When I am on login screen
       And I enter "798311232" number
       Then Alert popup should be disaply as Please enter a valid Idea number
 
#@login
Scenario: Verify login functionality with blank text
	When I am on login screen
     And I click on Enter Number textbox
     Then User should not able to login
     
#@login
Scenario: Verify if there is a cross icon available to erase the entered text
	 When I am on login screen
     And I enter "8983112334" number
     Then User should click on cancel icon and verify textbox is empty