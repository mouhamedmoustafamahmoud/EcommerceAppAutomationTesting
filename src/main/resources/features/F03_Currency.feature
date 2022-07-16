# Tags: optional
@smoke
Feature: Logged user can switch between currencies US-Euro

  Scenario: User change currency from US to Euro
    Given User log in with email "mohamed.moustafa@test.com" and password "P@ssword123"
    When User select euro currency from drop down menu
    Then All items prices change to euro