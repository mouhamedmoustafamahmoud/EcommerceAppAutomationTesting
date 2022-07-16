# Tags: optional
@smoke
Feature: User can open followUs links

  Scenario: User opens facebook link
    Given User at the home page
    When User click on facebook icon
    Then "https://www.facebook.com/nopCommerce" is opened in new tab

  Scenario: User opens twitter link
    Given User at the home page
    When User click on twitter icon
    Then "https://twitter.com/nopCommerce" is opened in new tab

  Scenario: User opens rss link
    Given User at the home page
    When User click on rss icon
    Then "https://demo.nopcommerce.com/new-online-store-is-open" is opened in new tab

  Scenario: User opens youtube link
    Given User at the home page
    When User click on youtube icon
    Then "https://www.youtube.com/user/nopCommerce" is opened in new tab