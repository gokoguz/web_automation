Feature: Product

Background:
  Given user is logged in with "standard_user" and "secret_sauce"

Scenario: Sort products by price low to high
  When user sorts products by "Price (low to high)"
  Then products should be sorted by price ascending