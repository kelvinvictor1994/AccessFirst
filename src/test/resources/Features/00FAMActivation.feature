@Regression6
Feature: Test FAM API Integration

  Scenario: To Test Fam Api and to send activation email to user
    Given The user logs into FAM
    And The user sends an activation email
    Then The user sets up a password for AccessFirst


