Feature: Candidate Successful Login Feature

  @Candidate	
  Scenario: Login the app successfully as a candidate
    Given I fill "5910000010" as my telephone number
    When I click Giriş Yap button
    
    @Candidate
     Scenario: Login the app successfully as a candidate2
    Given I fill "9210564322" as my telephone number
    When I click Giriş Yap button