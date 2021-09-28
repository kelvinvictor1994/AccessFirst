@Regression1
Feature: To Test the emergency notification submission

  Scenario Outline: Test Emergency Notification submission 
    Given The user is on the Homepage
    When clicks on emergency notification
    And user enters the patients name as <Patient Name>
    And user selects patient type as <Patient Type>
    And user chooses an emergency location as <City> and <Location>
    #And user enters patient age as <Patient Age>
    #And user enters Emergency as <Patient Emergency>
    #And user enters primary contact name as <Primary ContactName>
    #And user enters primary contact as <Primary Contact>
    #And user clicks on submit
    #Then user must land on Notification successfully submitted page

    Examples: 
      | Patient Name | Patient Type | City        | Location              | Patient Age | Patient Emergency   | Primary ContactName | Primary Contact |
      | Tester QA    | Adult        | Long Island | Emergency Long Island |          26 | Test kids emergency | Kids Primary        |      9876543210 |
      #| Kelvin       | Pediatric    | Manhattan   | KiDS Emergency        |           5 | Test kids emergency | Kids Primary        |      9876543210 |
