# Tags: optional
@smoke
Feature: Logged user can purchase product from the website

  Scenario: Logged user purchase with cash payment
    Given User log in with email "mohamed.moustafa@test.com" and password "P@ssword123"
    When User select product from a category
    And User add the product to the shopping cart
    And User click on checkout button to purchase the product
    And User enter mandatory valid information for payment
    And User click on confirm button to complete the payment
    Then Success completed order message appears