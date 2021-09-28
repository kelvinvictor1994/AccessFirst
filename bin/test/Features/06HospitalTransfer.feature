@Regression
Feature: Test Hospital to Hospital transfer

  Scenario: To test if we can perform hospital transfer
    Given The user is on Homepage
    And The user clicks on Hospital transfer option
    Then The user must land on Successfull transfer page
