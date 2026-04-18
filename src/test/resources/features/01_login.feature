Feature: Login

  Scenario: Successful login
    Given user is on login page
    When user logs in with "standard_user" and "secret_sauce"
    Then user should see products page

  Scenario: Invalid login
    Given user is on login page
    When user logs in with "locked_out_user" and "secret_sauce"
    Then error message should be displayed

  Scenario: Logout returns to login page
    Given user is logged in with "standard_user" and "secret_sauce"
    When user logs out
    Then login page should be displayed