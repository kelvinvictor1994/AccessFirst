@Regression
Feature: Test whether an invalid user is unable to login

  Scenario Outline: To Test if an unregisterd user gets a proper error message when logging in
    Given The User has launched the app
    And Enters the userid as <username>
    And Enters password as <password>
    And clicks on Login button
    Then The User must see the invalid credentials error message

    Examples: 
      | username            | password |
      | testernyu@gmail.com | Test@123 |
