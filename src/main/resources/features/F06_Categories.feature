# Tags: optional
@smoke
Feature: Logged user can select different Categories in the website

  Scenario: User select sub-category
    Given User log in with email "mohamed.moustafa@test.com" and password "P@ssword123"
    When User hover to a category and click on one of its sub-categories
    Then User will navigate to a page contains products about that sub-category

