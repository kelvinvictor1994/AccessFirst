@Regression7
Feature: Test Password Help Functionality

  Scenario Outline: Test Password reset
    Given The user has launched the AccessFirst app
    When user clicks on Password Help
    And enters the email address <emailid>
    And clicks on submit
    Then user gets a success message about their password reset

    Examples: 
      | emailid           |
      | kelvin@qburst.com |
