# Tags: optional
@smoke
Feature: Logged user can add different products to compare list

  Scenario: Logged user add different products to compare list
    Given User log in with email "mohamed.moustafa@test.com" and password "P@ssword123"
    When User navigate to notebooks products page
    And User add different products to the compare list
    And User navigate to compare products list page
    Then compare products list will contain all selected products