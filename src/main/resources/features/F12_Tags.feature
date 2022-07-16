# Tags: optional
@smoke
Feature: Logged user can select different tags

  Scenario: Logged user select awesome tag
    Given User log in with email "mohamed.moustafa@test.com" and password "P@ssword123"
    When User open notebooks category page
    And User click on awesome tag from product tags
    Then User will navigate to a page contains products related to awesome tag

  Scenario: Logged user select cell tag
    Given User log in with email "mohamed.moustafa@test.com" and password "P@ssword123"
    When User open notebooks category page
    And User click on cell tag from product tags
    Then User will navigate to a page contains products related to cell tag
