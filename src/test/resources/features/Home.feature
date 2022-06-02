
Feature: Validate home page feature


  Scenario: validate user navigate to filter screen when click search text box
    Given User is on home screen
    When User click on search field
    Then User should navigate to filter screen

  Scenario: validate user can search property with address
    Given User is on Filter page
    When User enter "Vadodara" in search field
    Then User should get list of property of that city

  Scenario: validate user can search property with property id
    Given User is on Filter page
    When User enter "MUMCIN0027" in property ID field
    Then User should get list of property of that id


  Scenario: validate user can search property with city
    Given User is on Filter page
    When User select "Vadodara" from city dropdown
    Then User should get list of property of that city

  Scenario: validate user can search property with tenant type
    Given User is on Filter page
    When User select "E-commerce" from tenant type dropdown
    Then User should get list of property of that tenant type

  Scenario: validate user can navigate from navbar
    Given User is on home screen
    When User click on profile button
    Then User should navigate to profile screen

