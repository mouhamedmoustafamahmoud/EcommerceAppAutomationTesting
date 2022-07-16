# Tags: optional
@smoke
Feature: Logged user can add different products to Shopping cart

  Scenario: Logged user add different products to Shopping cart
    Given User log in with email "mohamed.moustafa@test.com" and password "P@ssword123"
    When User navigate to Notebooks category page
    And User click on Add To Cart button for a product
    And User navigate to Books category page
    And User click on Add To Cart button for two books from products
    And User navigate to Shopping Cart page
    Then Shopping cart will contains all selected products