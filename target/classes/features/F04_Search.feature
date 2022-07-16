# Tags: optional
@smoke
Feature: Logged user can search for any product

  Scenario Outline: Logged user search using product name
    Given User log in with email "mohamed.moustafa@test.com" and password "P@ssword123"
    When User enter a product name "<name>" in search text field
    And User click on search button
    Then Search result appears with products related to the product name "<name>"

    Examples:
      | name   |
      | book   |
      | laptop |
      | nike   |

  Scenario Outline: Logged user search using product sku
    Given User log in with email "mohamed.moustafa@test.com" and password "P@ssword123"
    When User enter a product sku "<sku>" in search text field
    And User click on search button
    Then Search result appears with products related to the product sku "<sku>"

    Examples:
      | sku       |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |