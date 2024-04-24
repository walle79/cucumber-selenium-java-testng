Feature: Login Feature

  @Login  @regression_test
  Scenario: Login with valid credentials
    Given user is on login page
    When user login with valid username and password
    Then user can go to home page successfully