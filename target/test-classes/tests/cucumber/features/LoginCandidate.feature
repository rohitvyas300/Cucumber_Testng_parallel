Feature: Candidate Successful Login Feature

	@Candidate	
  Scenario: Login the app successfully as a candidate
    Given I fill "5910000010" as my telephone number
    When I click Giriş Yap button
    #And I go to Profilim page
    #And I click Giris Yap button
    #And I fill "5910000010" as my telephone number
    #And I click Giriş Yap button
    #And I give permission for SMS
    #And I fill "35880" as a login code
    #And I click Tamam button
    #Then I should see my profile page
    
    @Candidate
     Scenario: Login the app successfully as a candidate2
    Given I fill "9210564322" as my telephone number
    When I click Giriş Yap button