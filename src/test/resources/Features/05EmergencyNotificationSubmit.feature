@Regression

Feature: To Test the emergency notification submission

  Scenario Outline: Test Emergency Notification submission 
    Given The user is on the Homepage
    When clicks on emergency notification
    And user enters the patients name as <Patient Name>
    And user selects patient type as <Patient Type>
    And user chooses an emergency location as <City> and <Location>
    And user enters patient age as <Patient Age>
    And user enters Emergency as <Patient Emergency>
    And user enters primary contact name as <Primary ContactName>
    And user enters primary contact as <Primary Contact>
    And user clicks on submit
    Then user must land on Notification successfully submitted page <Location>

    Examples: 
      | Patient Name  | Patient Type | City        | Location                                                | Patient Age | Patient Emergency       | Primary ContactName | Primary Contact     |
      | Tester QA 1   | Adult        | Manhattan   | Ronald O. Perelman Center for Emergency Services        |          22 | Test Perelman emergency | Perelman Primary    | testernyu@gmail.com |
      | Tester QA 2   | Adult        | Manhattan   | Samuels Orthopedic Immediate Care Center                |          23 | Test Samuels emergency  | Samuels Primary     | testernyu@gmail.com |
      | Tester QA 3   | Adult        | Brooklyn    | Emergency Department at NYU Langone Hospital—Brooklyn   |          24 | Test Brooklyn emergency | Brooklyn Primary    | testernyu@gmail.com |
      | Tester QA 4   | Adult        | Brooklyn    | NYU Langone Health—Cobble Hill                          |          25 | Test Cobble emergency   | Cobble Primary      | testernyu@gmail.com |
      | Tester QA 5   | Adult        | Long Island | Emergency Department at NYU Langone Hospital—Long Island|          26 | Test LI emergency       | LI Primary          | testernyu@gmail.com |
      | Tester QA 6   | Pedatric     | Manhattan   | KiDS Emergency Department                               |          2  | Test kids emergency     | Kids Primary        | testernyu@gmail.com |
      | Tester QA 7   | Pedatric     | Manhattan   | Samuels Orthopedic Immediate Care Center                |          3  | Test Samuels emergency  | Samuels Primary     | testernyu@gmail.com |
      | Tester QA 8   | Pedatric     | Brooklyn    | Emergency Department at NYU Langone Hospital—Brooklyn   |          4  | Test Brooklyn emergency | Brooklyn Primary    | testernyu@gmail.com |
      | Tester QA 9   | Pedatric     | Brooklyn    | NYU Langone Health—Cobble Hill                          |          5  | Test Cobble emergency   | Cobble Primary      | testernyu@gmail.com |
      | Tester QA 10  | Pedatric     | Long Island | Emergency Department at NYU Langone Hospital—Long Island|          6  | Test LI emergency       | LI Primary          | testernyu@gmail.com |
