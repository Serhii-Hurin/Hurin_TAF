@Parallel
Feature: Desktop Login for Existed User
  As a Epam user
  I want to be able login to site
  So that I can perform actions as a logged user

  Scenario: Customer can be logged in as existing user
    When User opens the "Login page" page
    And User enters credentials
      | Login    | default |
      | Password | 1q2w3e  |
    And User clicks "Login" button
    Then User is redirected to "Sign In" page
    When User clicks Launches button
    Then Verify demo api tests have the following amount of tests:
      | total | passed | failed | skipped |
      | 20    | 10     | 8      | 2       |




