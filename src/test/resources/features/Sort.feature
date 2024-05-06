Feature: Sort Feature

  @Sort  @regression_test
  Scenario: Sort low to high feature
    Given user is on login page
    When user login with valid username and password
    Then user can go to home page successfully
    Then user choose sort low to high
    Then verify product price will be order low to high