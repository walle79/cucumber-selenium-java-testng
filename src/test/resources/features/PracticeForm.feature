Feature: Practice Form Feature

  @Form  @regression_test
  Scenario: Verify submit form successful
    Given user is on practice form page
    When user input all the valid information
    Then user information will be displayed correctly