@Regression
Feature: Test Password Help feature for an invalid user

  Scenario Outline: To Test Invalid users get proper error message during Password reset
    Given The user is on the AccessFirst Login Page
    When user clicks on Password Help option
    And enters email address as <emailid>
    And clicks on submit button
    Then the User must get a proper error message

    Examples: 
      | emailid             |
      | testernyu@gmail.com |
