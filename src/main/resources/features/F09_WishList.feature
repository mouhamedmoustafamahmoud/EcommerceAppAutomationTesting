# Tags: optional
@smoke
Feature: Logged user can add different products to Wishlist

  Scenario: Logged user add different products to Wishlist
    Given User log in with email "mohamed.moustafa321@test.com" and password "P@ssword123"
    When User navigate to the Notebooks category page
    And User click on Add To Wishlist button for a product
    And User navigate to the Books category page
    And User click on Add To Wishlist button for two books from products
    And User navigate to Wishlist page
    Then Wishlist will contains all selected products