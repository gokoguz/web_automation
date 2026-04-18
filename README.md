# Selenium Cucumber Automation Framework

## Overview
This project is a UI automation framework built with:
- Java 17
- Selenium WebDriver
- Cucumber BDD
- JUnit
- Page Object Model (POM)
- Allure Reporting

Target application:
https://www.saucedemo.com

---

## Project Structure

src/test/java
├── pages # Page Object classes
├── steps # Step Definitions
├── runners # Test Runner
├── hooks # Setup / Teardown
├── drivers # WebDriver factory
├── utils # Helpers (wait, config, screenshot)


---

## How to Run Tests

```bash
mvn clean test

Generate Allure report:

allure serve target/allure-results


Covered Modules

Login / Logout
Product Listing
Sorting
Cart Management
Checkout Flow


Reporting

Allure Reports
Screenshots on failure
JSON Cucumber report


Design Pattern

Page Object Model (POM)
Driver Factory Pattern
Hooks for lifecycle management


Test Strategy

Positive / Negative / Boundary cases
Regression suite (P1 / P2 / P3)
End-to-End coverage


P1 (Critical)
Login success
Login failure
Add to cart
Checkout success
Logout

P2 (High)
Sorting
Remove product
Multiple product add
Cart badge validation

P3 (Medium)
UI validations
Edge cases (empty inputs)


ARCHITECTURE

UI Tests (Cucumber)
     ↓
Step Definitions
     ↓
Page Objects (POM)
     ↓
Selenium WebDriver
     ↓
Driver Factory