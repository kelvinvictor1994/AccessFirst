@Regression
Feature: Test wait times with wait time API's

  Scenario: To Test wait time API
    Given The user is already on the Homepage
    And The user clicks on Waittime button
    Then The user must be able to see the waittime which matches the waittime API
