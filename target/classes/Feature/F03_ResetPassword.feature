@smoke
Feature: users could use login functionality to use their accounts

  Background: user open browser and navigates to login page
    Given user open browser
    And user navigates to login page



  Scenario:  User reset his/her password
    When user click on forgot password
    And user redirected to reset page
    And user enter his valid mail then click recover button
    Then reset mail should be sent to user

