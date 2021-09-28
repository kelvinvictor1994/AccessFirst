@Regression2
Feature: Test login Functionality

  Scenario Outline: To Test Login Functionlity with valid credentials
    Given The User launches the app
    And Enters the username as <username>
    And Enters the password as <password>
    And user clicks on Login button
#    And user enter a valit otp from their mail id
    And user allows the permission for contacts and location
    Then the user must land successfully on the Homepage

    Examples: 
      | username            | password |
      | kelvin@qburst.com   | Test@123 |
#      | testernyu@gmail.com | Test@123 |
