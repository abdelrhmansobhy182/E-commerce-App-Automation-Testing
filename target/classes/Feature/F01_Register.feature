@smoke
Feature:  guest user could register with valid data successfully

  Scenario:  User register with valid data
    Given user open browser for register
    And user navigates to register page
    When user enter valid data and click on register
    Then user could register successfully