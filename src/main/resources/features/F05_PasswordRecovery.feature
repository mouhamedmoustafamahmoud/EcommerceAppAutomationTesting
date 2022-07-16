# Tags: optional
@smoke
Feature: User can reset his/her password successfully

  Scenario: User reset password with valid email
    Given User at login page
    When User click on forgot password link
    And User enter valid email "mohamed.moustafa@test.com"
    And User click on recover button
    Then message appears tell user that an email has been sent to him

  Scenario: User reset password with invalid email
    Given User at login page
    When User click on forgot password link
    And User enter valid email "invalid.email@test.com"
    And User click on recover button
    Then message appears tell user this email is not found