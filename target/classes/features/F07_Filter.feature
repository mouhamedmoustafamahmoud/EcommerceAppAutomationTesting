# Tags: optional
@smoke
Feature: Logged user can filter with color

  Scenario: Logged user filter products with color
    Given User log in with email "mohamed.moustafa@test.com" and password "P@ssword123"
    And User navigate to category which has filter color options for its products
    When User select a specific color from options
    Then Category products will change to be for that color only