# Tags: optional
@smoke
Feature: User can add different products to Wishlist

  Scenario: User add htc phone product to Wishlist
    Given User at the homepage
    When User click on add to wishlist button of htc phone
    Then success message appears which confirm adding of the product

  Scenario: User add htc phone product to Wishlist and validate its quantity
    Given User at the homepage
    When User click on add to wishlist button of htc phone
    And User click on Wishlist link
    Then User will navigate to wishlist page which contain htc phone product with its quantity