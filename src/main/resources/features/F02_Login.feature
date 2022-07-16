# Tags: optional
@smoke
Feature: User can log in the website

  Scenario: User login with valid credentials
    Given User open login page
    When User enter email "mohamed.moustafa@test.com" and password "P@ssword123"
    And User click on login button
    Then User login successfully and return to home page


  Scenario: User login with invalid credentials
    Given User open login page
    When User enter email "invalid.email@test.com" and password "invalid.password"
    And User click on login button
    Then User login failed and error message appears