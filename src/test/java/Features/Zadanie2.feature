Feature: Purchasing items in store

  Scenario: Purchasing items in store
    Given user is on "https://mystore-testlab.coderslab.pl" webpage
    When user logs into his account and click on Hummingbird Printed Sweater
    And user chooses M size and picks quantity 5, then adds to cart and proceeds to checkout
    And user finalizes his order
    Then screenshot with payment confirmation is done