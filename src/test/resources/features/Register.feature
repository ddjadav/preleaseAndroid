Feature: Validate register user scenario

  Scenario: validate user can successfully register as Buyer/Seller
    Given user is on Login screen
    When user click on sign up link
    Then user should navigate to signup screen
    When user fill all required field
    And click on register button
    Then user should navigate to