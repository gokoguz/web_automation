Feature: Cart Management

  Background:
    Given user is logged in with "standard_user" and "secret_sauce"

  Scenario: Add product to cart
    When user adds "Sauce Labs Backpack" to cart
    Then cart badge should show "1"
    And cart should contain "Sauce Labs Backpack"

  Scenario: Add multiple products to cart
    When user adds "Sauce Labs Backpack" to cart
    And user adds "Sauce Labs Bike Light" to cart
    Then cart badge should show "2"

  Scenario: Remove product from cart
    Given user adds "Sauce Labs Backpack" to cart
    When user removes "Sauce Labs Backpack" from cart
    Then cart should be empty

  Scenario: Add two different products to cart
    When user adds "Sauce Labs Backpack" to cart
    And user adds "Sauce Labs Bike Light" to cart
    Then cart badge should show "2"