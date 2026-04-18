Feature: Checkout

Scenario: Successful checkout
  Given user is on login page
  When user logs in with "standard_user" and "secret_sauce"
  And user adds "Sauce Labs Backpack" to cart
  And user proceeds to checkout
  And user fills checkout form with "Ali", "Veli", "34000"
  And user completes the purchase
  Then order should be successful

Scenario: Checkout validation fails when first name is empty
  Given user is on login page
  When user logs in with "standard_user" and "secret_sauce"
  And user adds "Sauce Labs Backpack" to cart
  And user proceeds to checkout
  And user fills checkout form with "", "Veli", "34000"
  Then checkout error message should be displayed