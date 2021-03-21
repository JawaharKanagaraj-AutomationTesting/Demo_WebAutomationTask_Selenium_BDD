@demo
Feature: WebAutomationTask - Order T-Shirt and Update personal info on sample website

  Background:
    Given user logs into the automationpractice website
    When user inputs the valid email and password
    Then user enters the home automationpractice page

  Scenario: User orders T-shirt
    Given user lands on my order page
    When user selects a T-shirt
    And user proceeds to checkout by passing summary,address,shipping and payment screens
    Then Now User Clicks the Confirm Button
    And order is successfully placed
    And user logs out from store

  Scenario: User change/updates the personal info
    Given user lands on personal information page
    And user updates the last name value
    When user save the changes
    Then value is successfully changed
    And user logs out from store
